package com.shiro.Utils;

import junit.framework.Assert;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;
public class EncryptUtils {
	public static final String encryptMD5(String source) {
		if (source == null) {
			source = "";
		}
		Md5Hash md5 = new Md5Hash(source);
		return md5.toString();
	}
	@SuppressWarnings("deprecation")
	@Test
    public void test1(){
        String str1 = "hello";
        //base64进行编码
        String base64Encoded = Base64.encodeToString(str1.getBytes());
        //base64进行解码
        String str2 = Base64.decodeToString(base64Encoded);
        //16进制编码
        String hexEncoded = Hex.encodeToString(str1.getBytes());
        //16进制解码
        String str3 = new String(Hex.decode(hexEncoded.getBytes()));
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equals(str3));
        System.out.println(base64Encoded);
        System.out.println(hexEncoded);
        Assert.assertEquals(str1,str2);
        Assert.assertEquals(str1, str3);
    }
	
	  @Test
	    public void test2(){
	        String str1 = "hello";
	        String md5Str0 = new Md5Hash(str1).toString();
	        System.out.println("MD5值0：" + md5Str0);
	        String salt = "123";
	        String md5Str1 = new Md5Hash(str1, salt).toString();
	        System.out.println("MD5值1：" + md5Str1);
	        //还可以把MD5加密后的值再转成Base64或16进制的编码形式
	        String md5Str2 = new Md5Hash(str1, salt).toBase64();
	        String md5Str3 = new Md5Hash(str1, salt).toHex();
	        System.out.println("toBase64-MD5值2：" + md5Str2);
	        System.out.println("toHex-MD5值3：" + md5Str3);
	        //还可以指定加密次数，这里散列加密3次
	        String md5Str4 = new Md5Hash(str1, salt, 3).toString();
	        System.out.println("散列加密3次-MD5值4：" + md5Str4);
	         
	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	         
	        //使用SHA256加密算法
	        String shaStr0 = new Sha256Hash(str1).toString();
	        String shaStr1 = new Sha256Hash(str1,salt).toString();
	        String shaStr2 = new Sha256Hash(str1, salt).toBase64();
	        String shaStr3 = new Sha256Hash(str1, salt).toHex();
	        String shaStr4 = new Sha256Hash(str1, salt,3).toString();
	        System.out.println("SHA256值0：" + shaStr0);
	        System.out.println("SHA256值1：" + shaStr1);
	        System.out.println("toBase64-SHA256值2：" + shaStr2);
	        System.out.println("toHex-SHA256值3：" + shaStr3);
	        System.out.println("散列加密3次-SHA256值4：" + shaStr4);
	    }
}
