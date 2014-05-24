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
package org.tarrsalah.owls.examples.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.tarrsalah.owls.examples.Bootstrap;

/**
 *
 * @author tarrsalah.org
 */
@WebService(serviceName = "Hello")
public class Hello {

	private static final Logger LOG = Logger.getLogger(Hello.class.getName());

	public static final String ROUTE = "/hello";
	public static final String OWLS_FILE = Bootstrap.OWLS_DIR + "/hello.owl";
	public static final String WSDL_FILE = Bootstrap.HOST + ROUTE + "?wsdl";

	/**
	 * This is a sample web service operation
	 *
	 * @param txt
	 * @return
	 */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		LOG.log(Level.INFO, "The first param: is ".concat((txt == null) ? "*null*" : txt));
		return "Hello " + txt + " !";
	}
}
