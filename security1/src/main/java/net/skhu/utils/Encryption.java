package net.skhu.utils;

import java.security.MessageDigest;

/*
 * 유틸리티 클래스 : 여러 프로젝트에서 공통으로 사용될 수 있는 범용 기능을 구현한 클래스.
 */

//암호화를 위한 클래스
public class Encryption {
	
	public static final String SHA256 = "SHA-256";
	public static final String MD5 = "MD5";
	
	public static String encrypt(String s, String messageDigest) {
		try {
			MessageDigest md = MessageDigest.getInstance(messageDigest);
			byte[] passBytes = s.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<digested.length; ++i)
				sb.append(Integer.toHexString(0xff & digested[i]));
			return sb.toString();
		}catch(Exception e) {
			return s;
		}
	}
	
}
