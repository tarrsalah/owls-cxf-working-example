
package org.tarrsalah.owls.working.examples.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author tarrsalah.org
 */


@WebService(serviceName = "SayHey")
public class HelloService {

	/**
	 * This is a sample web service operation
	 * @return 
	 */
	@WebMethod(operationName = "hello")
	public String hello() {
		return "Hey OWLS mother fucker, I'm here !";
	}
}
