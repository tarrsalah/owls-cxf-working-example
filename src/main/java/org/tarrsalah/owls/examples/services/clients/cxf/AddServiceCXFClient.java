/*
 * The MIT License (MIT)
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
package org.tarrsalah.owls.examples.services.clients.cxf;

import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.tarrsalah.owls.examples.services.AddService;

/**
 * AddServiceCXFClient.java (UTF-8)

 May 21, 2014
 *
 * @author tarrsalah.org
 */
public class AddServiceCXFClient {

	private final static Logger logger = Logger.getLogger(AddServiceCXFClient.class.getName());

	public void start() {
		try {
			Properties properties = System.getProperties();
			properties.put("org.apache.cxf.stax.allowInsecureParser", "1");

			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			Client client = dcf.createClient(new URL(AddService.WSDL_FILE));

			Object[] res = client.invoke("add", new Integer(1), new Integer(2));
			logger.log(Level.INFO, String.join(" ", "The result of the service call is", Arrays.toString(res)));
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Can't play well with this " + AddServiceCXFClient.class.getCanonicalName(), ex);
		}
	}
}
