package com.dt.rts.sftp.connect;
import java.security.Security;

import org.junit.Before;
import org.junit.Test;

import com.dt.rts.sftp.connect.SFTPConnect;

import static org.junit.Assert.*;

public class SFTPConnectTest {

	public static final String DTRTS_HOSTNAME = "ftp.dtrts.com";
	public static final String DTRTS_USERNAME = "gauser";
	public static final String DTRTS_PASSWORD = "D1sn3yW0rld!";
	
	public static final String GSSOLRS_HOSTNAME = "flash.gssolrs.net";
	public static final String GSSOLRS_USERNAME = "tomcat";
	public static final String GSSOLRS_PASSWORD = "c00kie";
	
	SFTPConnect sftp;
	
	@Before
	public void setup() {
		sftp = new SFTPConnect();
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	
	@Test
	public void testConnectToDTRTS() {
		String res = sftp.connect(DTRTS_HOSTNAME, DTRTS_USERNAME, DTRTS_PASSWORD);
		System.out.println(res);
		assertTrue("Expected failing to connect to DTRTS server, but no error occurs", res.contains("Failed to connect to SFTP server") || res.contains("Error while trying to connect to SFTP server"));
	}
	
	@Test
	public void testConnectToGSSOLRS() {
		String res = sftp.connect(GSSOLRS_HOSTNAME, GSSOLRS_USERNAME, GSSOLRS_PASSWORD);
		assertTrue("Expected to connect to GSSOLRS SFTP server successfully, but failed", res.contains("Successfully connected to SFTP server"));
	}
}
