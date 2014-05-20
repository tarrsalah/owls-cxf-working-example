/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tarrsalah.owls.working.examples;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.mindswap.owl.OWLFactory;
import org.mindswap.owl.OWLKnowledgeBase;
import org.mindswap.owls.service.Service;

/**
 *
 * @author tarrsalah.org
 */
public class OwlsExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpServer httpServer = new HttpServer();
		NetworkListener networkListener = new NetworkListener("grizzly", "0.0.0.0", 8080);			
		httpServer.getServerConfiguration().addHttpHandler(new CLStaticHttpHandler(OwlsExample.class.getClassLoader(), "static/"), "/");

		httpServer.addListener(networkListener);
		httpServer.start();
		Play();
		Thread.sleep(2 * 1000);
		Thread.currentThread().join();
	}

	public static final URI AURI = URI.create("http://127.0.0.1/services/1.1/BookFinder.owls");

	public static void Play() throws IOException {
		OWLKnowledgeBase kb = OWLFactory.createKB();
		Service service = kb.readService(AURI);
		System.out.println(service.toPrettyString());
	}
}
