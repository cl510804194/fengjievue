package com.yjf.esupplier.test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println((1200*0.01*Math.pow(1+0.01,3))/((Math.pow(1+0.01,3))-1));
    }
	
	private static byte[] readBytes(InputStream in) throws IOException{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int count = 0;
//		byte[] buff = new byte[512];
		while((count = in.read()) != -1){
			byteArrayOutputStream.write(count);
		}	
		byte[] data = byteArrayOutputStream.toByteArray();
		byteArrayOutputStream.close();
		return data;
	}
	
	
	private static void writeBytes(OutputStream out, byte[] data) throws IOException{
		out.write(data);
	}
	
	private static void writeByte(OutputStream out, byte b) throws IOException{
		out.write(b);
	}

}
