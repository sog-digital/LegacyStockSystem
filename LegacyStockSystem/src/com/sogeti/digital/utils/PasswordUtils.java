/**
 * 
 */
package com.sogeti.digital.utils;


import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import net.iharder.Base64;

/**
 * @author NIRGOYAL
 *
 */
public class PasswordUtils {


	public static String decrypt(final String encrypted)  {

		String decryptedPassword = null;

		try {
			SecretKey key = new SecretKeySpec(Base64.decode("u/Gu5posvwDsXUnV5Zaq4g=="), "AES");
			AlgorithmParameterSpec iv = new IvParameterSpec(Base64.decode("5D9r9ZVzEYYgha93/aUK2w=="));
			byte[] decodeBase64 = Base64.decode(encrypted);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			String decryptedString = new String(cipher.doFinal(decodeBase64), "UTF-8");
			byte[] bytes = Hex.decodeHex(decryptedString.toCharArray());

			decryptedPassword = new String(bytes, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedPassword;
	} 

}
