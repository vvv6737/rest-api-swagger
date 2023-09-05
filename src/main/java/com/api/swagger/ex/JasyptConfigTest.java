package com.api.swagger.ex;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import java.io.FileReader;
import java.io.IOException;

public class JasyptConfigTest {

//    @Value("${jasypt.encryptor.key}")
//    private String KEY;

    private static String key() throws IOException {
        String path = System.getProperty("user.dir");
        String key2 = "";
        FileReader reader = new FileReader(path + "/../../../Downloads/usefulWebJasyptKey.txt");
        int ch;
        while ((ch = reader.read()) != -1) {
            key2 = key2 + (char) ch;
        }
        return key2;
    }

    public static void main(String[] args) throws IOException {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key());
        config.setPoolSize("1");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setStringOutputType("base64");
        config.setKeyObtentionIterations("1000");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        encryptor.setConfig(config);

//        System.out.println(encryptor.encrypt("jdbc:mysql://localhost:3306/park_web_project_db?autoReconnect=true"));
//        System.out.println(encryptor.decrypt("VdNr7yG/X/Z1e1bYF8sBgnNWHvY6300uHTvRWtIuGDUvRIgveMdxeN/Z5clZ4CGM7PMqg5qDG9jL56GClC1CvdWM2cFJrk0RmqQRgY5kR5U="));
    }
}
