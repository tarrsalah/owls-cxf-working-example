/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tarrsalah.owls.working.examples;

import java.net.URI;

/**
 * Env.java (UTF-8)
 *
 * May 23, 2014
 * @author tarrsalah.org
 */
public class Env {
	public static final URI ADD_OWLS = URI.create("http://127.0.0.1/services/1.2/Add.owl");
	public static final URI HELLO_OWLS = URI.create("http://127.0.0.1/services/1.2/hello.owl");	
	public static final URI ADD_SERVICE_WSDL = URI.create("http://127.0.0.1/add?wsdl");
	public static final URI HELLO_SERVICE_WSDL = URI.create("http://127.0.0.1/hello?wsdl");

}
