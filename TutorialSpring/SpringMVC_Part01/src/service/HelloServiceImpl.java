/**
 * 
 */
package service;

import org.springframework.stereotype.Service;

/**
 * @author suleymancan Feb 23, 2018
 */

@Service
public class HelloServiceImpl implements HelloService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.HelloService#createMessage()
	 */
	@Override
	public String createMessage() {

		return "created message";
	}

}
