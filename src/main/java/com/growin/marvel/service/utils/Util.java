package com.growin.marvel.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Util {

    private final Environment env;
    //public static String MARVEL_SERVICE_AUTH_TS = "";
    //public static String MARVEL_SERVICE_AUTH_PUBLIC_KEY = "";
    //public static String MARVEL_SERVICE_AUTH_PRIVATE_KEY = "";

        //this.MARVEL_SERVICE_AUTH_TS = env.getProperty("marvel.service.key.ts");
        //this.MARVEL_SERVICE_AUTH_PUBLIC_KEY = env.getProperty("marvel.service.key.public");
        //this.MARVEL_SERVICE_AUTH_PRIVATE_KEY = env.getProperty("marvel.service.key.private");

    @Autowired
    public Util(Environment env) {
        this.env = env;
    }

    public String getMarvelServiceUrlCharacter(){
        String baseUrl = env.getProperty("marvel.service.baseurl");
        String methodListCharacters = env.getProperty("marvel.service.method.characters");

        return baseUrl + methodListCharacters + getMarvelServiceAuthDetailPath();
    }

    public String getMarvelServiceAuthDetailPath(){
        String ts = env.getProperty("marvel.service.key.ts");
        String publicKey = env.getProperty("marvel.service.key.public");

        return "?ts="+ ts +"&apikey="+ publicKey +"&hash="+ getMD5Hash();
    }

    public String getMD5Hash(){
        String ts = env.getProperty("marvel.service.key.ts");
        String publicKey = env.getProperty("marvel.service.key.public");
        String privateKey = env.getProperty("marvel.service.key.private");

        return toMD5(ts + privateKey + publicKey);
    }

    public static String toMD5(String s){
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (byte b : messageDigest) hexString.append(Integer.toHexString(0xFF & b));

            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
