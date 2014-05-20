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
import org.mindswap.exceptions.ExecutionException;
import org.mindswap.owl.OWLFactory;
import org.mindswap.owl.OWLIndividualList;
import org.mindswap.owl.OWLKnowledgeBase;
import org.mindswap.owls.OWLSFactory;
import org.mindswap.owls.process.execution.ProcessExecutionEngine;
import org.mindswap.owls.service.Service;

/**
 *
 * @author tarrsalah.org
 */
public class OwlsExample {

	public static final URI AURI = URI.create("http://127.0.0.1/services/1.2/ZipCodeFinder.owl");

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// My proxy configuration 
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "5477");
		
		
		HttpServer httpServer = new HttpServer();
		NetworkListener networkListener = new NetworkListener("grizzly", "0.0.0.0", 8080);
		httpServer.getServerConfiguration().addHttpHandler(new CLStaticHttpHandler(OwlsExample.class.getClassLoader(), "static/"), "/");

		httpServer.addListener(networkListener);
		httpServer.start();

		Thread.sleep(2 * 1000);
		Play();
		Thread.currentThread().join();
	}

	public static void Play() throws IOException, ExecutionException {
		ProcessExecutionEngine exec = OWLSFactory.createExecutionEngine();

		OWLKnowledgeBase kb = OWLFactory.createKB();
		OWLIndividualList<Service> services = kb.readAllServices(AURI);
		System.out.println(services.toString());

	}
}
