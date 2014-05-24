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

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.tarrsalah.owls.examples.Bootstrap;

/**
 * AddService.java (UTF-8)
 *
 * May 13, 2014
 *
 * @author tarrsalah.org
 */
@WebService
public class AddService {

	public static final String ROUTE = "/add";
	public static final String OWLS_FILE = Bootstrap.OWLS_DIR + "/add.owl";
	public static final String WSDL_FILE = Bootstrap.HOST + ROUTE + "?wsdl";

	public static void main(String[] args) {
		System.out.println(WSDL_FILE);
	}

	@WebMethod(operationName = "add")
	public int Add(@WebParam(name = "value1") int value1, @WebParam(name = "value2") int value2) {
		return value1 + value2;
	}
}
