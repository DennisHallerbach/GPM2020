package edu.thi.flytransport;

/**
 * Author: Julian Bauer
 */

import java.util.HashMap;

public class UserProvider {
	
	private static HashMap<String, String> accounts;
	
	public UserProvider() {
	}
	
	private static void init() {
		if (accounts == null) {
			accounts = new HashMap<String,String>();		
			accounts.put("Dennis","Passwort1");
			accounts.put("Julian","Passwort2");
		}
	}
	
	public static boolean findUser(String username) {
		init();
		return accounts.containsKey(username);		
	}
	
	public static boolean checkPassword(String username, String password) {
		init();
		String accountPassword = accounts.get(username);
		return password.equals(accountPassword);
	}

}
