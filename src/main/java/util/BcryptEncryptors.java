package util;

import java.io.File;

public class BcryptEncryptors implements Encryptors {
    @Override
    public File encryption(File target) {
        // Bcrypt 로 암호화한다.
        System.out.println("Bcrypt로 암호화");
        return null;
    }
}
