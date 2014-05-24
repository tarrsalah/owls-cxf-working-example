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
package org.tarrsalah.owls.examples.services.clients.owls;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindswap.exceptions.ExecutionException;
import org.mindswap.owl.OWLFactory;
import org.mindswap.owl.OWLKnowledgeBase;
import org.mindswap.owl.OWLValue;
import org.mindswap.owls.OWLSFactory;
import org.mindswap.owls.process.Process;
import org.mindswap.owls.process.execution.ProcessExecutionEngine;
import org.mindswap.owls.process.variable.Input;
import org.mindswap.owls.process.variable.Output;
import org.mindswap.owls.service.Service;
import org.mindswap.query.ValueMap;
import org.tarrsalah.owls.examples.services.Hello;

/**
 * HelloServiceOWLSClient.java (UTF-8)
 *
 * May 24, 2014
 *
 * @author tarrsalah.org
 */
public class HelloServiceOWLSClient {

	private static final Logger LOG = Logger.getLogger(HelloServiceOWLSClient.class.getName());

	public void start() {
		try {
//			ProxyFucker.fuck();
			OWLKnowledgeBase kb = OWLFactory.createKB();
			Service service = kb.readService(URI.create(Hello.OWLS_FILE));
			Process process = service.getProcess();
			ProcessExecutionEngine executionEngine = OWLSFactory.createExecutionEngine();

			ValueMap<Input, OWLValue> inputs = new ValueMap<>();
			inputs.setValue(process.getInput("name"), kb.createDataValue("tarrsalah"));
			LOG.log(Level.INFO, inputs.debugString());

			ValueMap<Output, OWLValue> outputs = executionEngine.execute(process, inputs, kb);			
			LOG.log(Level.INFO, outputs.debugString());

		} catch (IOException | ExecutionException ex) {
			LOG.log(Level.SEVERE, ex.toString());
		} finally {
//			ProxyFucker.unfuck();
		}
	}
}
