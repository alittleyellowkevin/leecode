package utils;

public class FixedKeyXorEncryption {
    // 硬编码的固定密钥（实际使用时可改为更长更复杂的字符串）
    private static final String FIXED_KEY = "38KjacI50743";

    /**
     * 加密：通过密钥与数据的异或运算
     */
    public static String encrypt(String data) {
        if (data == null) return null;
        
        byte[] dataBytes = data.getBytes();
        byte[] keyBytes = FIXED_KEY.getBytes();
        byte[] encryptedBytes = new byte[dataBytes.length];
        
        // 异或运算：数据字节与密钥字节逐个对应计算
        for (int i = 0; i < dataBytes.length; i++) {
            // 密钥循环使用（i % keyBytes.length确保密钥不越界）
            encryptedBytes[i] = (byte) (dataBytes[i] ^ keyBytes[i % keyBytes.length]);
        }
        
        // 转换为Base64便于存储和传输（非加密，仅为编码）
        return java.util.Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 解密：使用相同密钥进行异或运算还原
     */
    public static String decrypt(String encryptedData) {
        if (encryptedData == null) return null;
        
        // 先解码Base64
        byte[] encryptedBytes = java.util.Base64.getDecoder().decode(encryptedData);
        byte[] keyBytes = FIXED_KEY.getBytes();
        byte[] decryptedBytes = new byte[encryptedBytes.length];
        
        // 异或运算还原
        for (int i = 0; i < encryptedBytes.length; i++) {
            decryptedBytes[i] = (byte) (encryptedBytes[i] ^ keyBytes[i % keyBytes.length]);
        }
        
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        String original = "JV5ATKXWxXSf!OTKtByRe#RDLn$UwABfE";
        String encrypted = encrypt(original);
        String decrypted = decrypt(encrypted);
        
        System.out.println("原始数据：" + original);
        System.out.println("加密后：" + encrypted);  // 输出类似：j8+Nl5y1Qw...（Base64字符串）
        System.out.println("解密后：" + decrypted);  // 输出原始数据
    }
}
