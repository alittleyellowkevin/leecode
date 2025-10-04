package utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {
    // 算法名称
    private static final String ALGORITHM = "AES";
    // 加密模式和填充方式
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    // 密钥长度（128/256位，256位需要额外配置JCE无限制权限文件）
    private static final int KEY_SIZE = 128;

    /**
     * 生成AES密钥
     * @return Base64编码的密钥
     * @throws Exception 异常
     */
    public static String generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * AES加密
     * @param data 明文
     * @param key  Base64编码的密钥
     * @return 加密后的Base64字符串
     * @throws Exception 异常
     */
    public static String encrypt(String data, String key) throws Exception {
        // 还原密钥
        byte[] keyBytes = Base64.getDecoder().decode(key);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);

        // 加密
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(encryptedData);
    }

    /**
     * AES解密
     * @param encryptedData 加密后的Base64字符串
     * @param key           Base64编码的密钥
     * @return 解密后的明文
     * @throws Exception 异常
     */
    public static String decrypt(String encryptedData, String key) throws Exception {
        // 还原密钥和加密数据
        byte[] keyBytes = Base64.getDecoder().decode(key);
        byte[] dataBytes = Base64.getDecoder().decode(encryptedData);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);

        // 解密
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(dataBytes);

        return new String(decryptedData, "UTF-8");
    }

    // 测试
    public static void main(String[] args) throws Exception {
        String test = "dp_tmp";
        System.out.println(test.contains("_tmp"));

        // 生成密钥（实际应用中需妥善保存，只生成一次）
        String key = generateKey();
        System.out.println("密钥：" + key);

        // 加密
        String plaintext = "Hello, AES Encryption!";
        String encrypted = encrypt(plaintext, key);
        System.out.println("加密后：" + encrypted);

        // 解密
        String decrypted = decrypt(encrypted, key);
        System.out.println("解密后：" + decrypted);
    }
}
