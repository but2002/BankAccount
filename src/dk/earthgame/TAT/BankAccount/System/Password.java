package dk.earthgame.TAT.BankAccount.System;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dk.earthgame.TAT.BankAccount.BankAccount;

public class Password {
	private BankAccount plugin;
	
	public Password(BankAccount instantate) {
		plugin = instantate;
	}
	
	public boolean passwordCheck(String accountname,String password) {
		String CryptPassword = passwordCrypt(password);
		try {
			ResultSet rs;
			rs = plugin.stmt.executeQuery("SELECT `password` FROM `" + plugin.SQL_account_table + "` WHERE `accountname` = '" + accountname + "'");
			while (rs.next()) {
				if (CryptPassword.equalsIgnoreCase(rs.getString("password"))) {
					return true;
				} else if (rs.getString("password").equalsIgnoreCase(password)) {
					return true;
				}
			}
		} catch(SQLException e) {
			if (!e.getMessage().equalsIgnoreCase(null))
				plugin.consoleWarning("Error #20-3: " + e.getMessage());
			else
				plugin.consoleWarning("Error #20-2: " + e.getErrorCode() + " - " + e.getSQLState());
		} catch(Exception e) {
			plugin.consoleWarning("Error #20-1: " + e.toString());
		}
		return false;
	}
	
	public String passwordCrypt(String password) {
		byte[] temp = password.getBytes();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(temp);
			byte[] output = md.digest();
			password = bytesToHex(output);
			return password;
		} catch (NoSuchAlgorithmException e) {
			plugin.consoleWarning("Error #21-1: Couldn't crypt password");
			return "Error";
		}
	}

	private String bytesToHex(byte[] b) {
		char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuffer buf = new StringBuffer();
		for (int j=0; j<b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}
}