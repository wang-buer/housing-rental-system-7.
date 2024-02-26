package com.fwzl.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Part;




public class MyUtil {
	public static String getFileName(Part part) {
		if(part==null) {
			return null;
		}
		String fileName = part.getHeader("content-disposition");
		if(fileName.lastIndexOf("=")+2==fileName.length()-1) {
			return null;
		}
		return fileName.substring(fileName.lastIndexOf("=")+2, fileName.length()-1);
		
	}
	
	public static String toUTF8String (String str) {
		StringBuffer sb=new StringBuffer();
		int len=str.length();
		for(int i=0;i<len;i++) {
			char c=str.charAt(i);
			if(c>=0 && c<=255)
			{
				sb.append(c);
			}
			else {
				byte b[];
				try {
					b=Character.toString(c).getBytes("UTF-8");
				}
				catch(UnsupportedEncodingException e) {
					e.printStackTrace();
					b=null;
				}
				
				for(int j=0;j<b.length;j++) 
				{
					int k=b[j];
					if(k<0) {
						k&=255;
					}
					sb.append("%"+Integer.toHexString(k).toUpperCase());
				}
				
			}
		}
		return sb.toString();
	}
}
