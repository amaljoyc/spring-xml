package mypack;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES {
	static byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static String plaintext = "amaljoy123456789";
	static String encryptionKey = "thebestsecretkey";

	public static void main(String[] args) {
		try {
			System.out.println("Plain Text: " + plaintext);
			byte[] cipher = encrypt(plaintext, encryptionKey);

			System.out.print("Cipher Text: ");
			for (int i = 0; i < cipher.length; i++)
				System.out.print(new Integer(cipher[i]) + " ");
			System.out.println("");

			String decrypted = decrypt(cipher, encryptionKey);
			System.out.println("Decrypted Text: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] encrypt(String plainText, String encryptionKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
		byte[] enbyteArray = cipher.doFinal(plainText.getBytes("UTF-8"));
		System.out.println("Base64: " + Base64.encodeBase64URLSafeString(enbyteArray));
		return enbyteArray;
	}

	public static String decrypt(byte[] cipherText, String encryptionKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
		return new String(cipher.doFinal(cipherText), "UTF-8");
	}
}
