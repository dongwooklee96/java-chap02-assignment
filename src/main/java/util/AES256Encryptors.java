package util;

import java.io.File;

public class AES256Encryptors implements Encryptors {
    @Override
    public File encryption(File target) {
        // AES로 암호화 한다.
        System.out.println("AES로 암호화");
        return null;
    }
}
