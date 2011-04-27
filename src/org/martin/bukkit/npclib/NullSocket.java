/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.martin.bukkit.npclib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author martin
 */
public class NullSocket extends Socket {
	@Override
	public InputStream getInputStream() {
		byte[] buf = new byte[1];
		return new ByteArrayInputStream(buf);
	}

	@Override
	public OutputStream getOutputStream() {
		return new ByteArrayOutputStream();
	}
}
