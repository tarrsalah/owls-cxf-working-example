/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tarrsalah.owls.working.examples;

/**
 * ProxyFucker.java (UTF-8)
 *
 * May 22, 2014
 *
 * @author tarrsalah.org
 */
public class ProxyFucker {

	public static void fuck() {
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "5477");
	}

	public static void unfuck() {
		System.setProperty("http.proxyHost", "");
		System.setProperty("http.proxyPort", "");
	}

}
