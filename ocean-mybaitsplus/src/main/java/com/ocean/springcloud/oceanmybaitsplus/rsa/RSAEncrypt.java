package com.ocean.springcloud.oceanmybaitsplus.rsa;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {


    public static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIIlQbOdc5qvvHq0o1Y0vpY4r2/6FKs9zoY/wml5jDvjPO2LYO/y3Fb/kIf4qNcQL6Rtujp1M8cH0NDObCZS8HJbM+E9WpadowfMEd6NoL8lNOG7pn242WRyGpBSqMWpR8+0+UIEt2B7CczHQLWaqzzox3C7z76T4NwrTgBc66FfAgMBAAECgYBEfMaudtU3OfO9vwGVg/wnoXzxOHFYDBZ6n2L3jnc1rMeLWiWRIATD44lzhG+VfXcU2Il/6d1th7djqr1PDaZqPM2nhGrE4LvYtD2DhUJnne674OJlhd4fYyRBarLqV+uvByHeHV7BytO2bsYxcLe46jo6ufKrZKJEDjOpf3q9gQJBAP4UP0+QWwMb9Kf42KEHb+M6/DEb7hopYf/nL8FiXB4uRYE1Cx8SbKt7x7UJsUEJJHKEk4fI+5r5F4yO49rW09cCQQCDIST4wkQRw2WuxS0YrSqs4LRvLbKnY8g9zEEpYc9OAmNne32guVOz12hmgSAXDmXiBJgM6ZCe5ewMA2dtFm25AkEArvWwVxCXq39vrM9OFSzy3i17BjIudrNyeW5wUyFxP5MrZ3roSqA8VqWo8sBW3+r0vysOEF3U7HWEwtSOkN6IBwJAVAwsfF1X7+LEC+9J5mUn00L7o78woWWtdR60LWgJzcBuImfer+PZqI3K1tiwztZlqyaypqQWFCLe1xxfcGZN0QJARY11QnXfgQNQGT6w/M33K7ozRdoB4sBuRIeaPKe2PTbbpuCLfchteQeYrQQnNNpJARtunhey8yUq1avHAstNJg==";
    public static String publicKey = "DIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCJUGznXOar7x6tKNWNL6WOK9v+hSrPc6GP8JpeYw74zzti2Dv8txW/5CH+KjXEC+kbbo6dTPHB9DQzmwmUvByWzPhPVqWnaMHzBHejaC/JTThu6Z9uNlkchqQUqjFqUfPtPlCBLdgewnMx0C1mqs86Mdwu8++k+DcK04AXOuhXwIDAQAB";

    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥
    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "df723820";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message,publicKey);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn+"123131",privateKey);
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0,publicKeyString);  //0表示公钥
        keyMap.put(1,privateKeyString);  //1表示私钥
    }
    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}


