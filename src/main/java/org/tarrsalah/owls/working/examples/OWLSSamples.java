package org.tarrsalah.owls.working.examples;

import impl.owls.process.variable.InputImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindswap.exceptions.ExecutionException;
import org.mindswap.owl.OWLFactory;
import org.mindswap.owl.OWLIndividual;
import org.mindswap.owl.OWLKnowledgeBase;
import org.mindswap.owl.OWLValue;
import org.mindswap.owls.OWLSFactory;
import org.mindswap.owls.process.Process;
import org.mindswap.owls.process.execution.ProcessExecutionEngine;
import org.mindswap.owls.process.variable.Input;
import org.mindswap.owls.process.variable.Output;
import org.mindswap.owls.service.Service;
import org.mindswap.query.ValueMap;

/**
 * OWLSSamples.java (UTF-8)
 *
 * May 15, 2014
 *
 * @author tarrsalah.org;
 */
public class OWLSSamples implements Player {

	static final Logger logger = Logger.getLogger(OWLSSamples.class.getName());

	@Override
	public void play() {
		try {
//			ProxyFucker.fuck();
			ProcessExecutionEngine executionEngine = OWLSFactory.createExecutionEngine();
			OWLKnowledgeBase kb = OWLFactory.createKB();
			Service service = kb.readService(Env.HELLO_OWLS);
			Process process = service.getProcess();
			
			ValueMap<Input, OWLValue> inputs = new ValueMap<>();			
			
			ValueMap<Output, OWLValue> outputs = executionEngine.execute(process, kb);
			System.out.println(process.getProfile().getInputs().toString());
			System.out.println(process.getProfile().getOutputs().toString());
			System.err.println(process.getService().getGrounding().toPrettyString());
			System.out.println(outputs.getValue(process.getOutput().toPrettyString()));
			
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		} catch (ExecutionException ex) {
			Logger.getLogger(OWLSSamples.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
//			ProxyFucker.unfuck();
		}
	}
}
