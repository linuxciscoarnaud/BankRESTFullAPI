/**
 * 
 */
package com.bank.tools;

/**
 * @author Arnaud
 *
 */

public class Tools {

	public String getSessionIdAsDigits(String sessionId) {
		return sessionId.replaceAll("\\D", "");
	}
}
