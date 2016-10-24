package com.dt.rts.sftp.connect;

import com.trivin.inet.inetException;
import com.trivin.inet.ftp.SFtpSession;

public class SFTPConnect {
    
	public String connect(String hostname, String username, String password) {
		SFtpSession sess = null;
		try {
			sess = new SFtpSession(hostname, username, password) ;
		} catch(inetException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		if(sess != null && !sess.hasError()) {
			if(sess.canConnect()) {
				return "Successfully connected to SFTP server - hostname: " + hostname + ", userName: " + username + ", password: " + password + ".";  	
			} else {
				return "Failed to connect to SFTP server - hostname: " + hostname + ", userName: " + username + ", password: " + password + ".";  	
			}
		}
		
		return "Error while trying to connect to SFTP server. Error: " + sess.getLastError();
	}
}
