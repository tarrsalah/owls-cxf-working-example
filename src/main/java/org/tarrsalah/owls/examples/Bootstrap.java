/*
 * The MIT License (MIT),
 *
 * Copyright (c) 2014 tarrsalah@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.tarrsalah.owls.examples;

import java.io.IOException;
import java.util.Properties;
import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.jaxws.JaxwsHandler;

/**
 * Bootstrap.java (UTF-8)
 *
 * May 21, 2014
 *
 * @author tarrsalah.org
 */
public class Bootstrap {

	public static final String HOST = "http://127.0.0.1";
	public static final String OWLS_DIR = String.join("/", "static", "services", "1.2");

	public static void main(String[] args) throws IOException, InterruptedException {
		Properties properties = System.getProperties();
		properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
		System.setProperties(properties);
		new Bootstrap().start();
	}

	public void start() throws IOException, InterruptedException {
		HttpServer httpServer = new HttpServer();
		NetworkListener networkListener = new NetworkListener("grizzly", "0.0.0.0", 8080);
		httpServer.addListener(networkListener);
		httpServer.getServerConfiguration().addHttpHandler(new CLStaticHttpHandler(Bootstrap.class.getClassLoader(), "static/"), "/");
		httpServer.getServerConfiguration().addHttpHandler(new JaxwsHandler(new HelloService()), HelloService.ROUTE);

		httpServer.start();
		Thread.sleep(2 * 1000); // The services are up and running
		System.out.println(" --- OWLS client --- ");
		new HelloServiceOWLSClient().start();
		System.out.println("-----");
		Thread.currentThread().join();
	}

	public static void set() {
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "5477");
	}

	public static void unset() {
		System.setProperty("http.proxyHost", "");
		System.setProperty("http.proxyPort", "");
	}
}
