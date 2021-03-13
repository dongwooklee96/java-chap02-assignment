package service;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.Crypto;

class EncryptorsTest {

    File file;
    Encryptors encryptors;

    @BeforeEach
    void setUp() {
        file = new File("test.txt");
        encryptors = new Encryptors(new Crypto(), new Saving());
    }

    @DisplayName("파일을 암호화 하고, 결과를 파일을 로컬에 저장한다.")
    @Test
    void encryptFileAndSaveLocal() {
        encryptors.encryption(file, "AES").saveFileToLocal("/usr/tmp");
        encryptors.encryption(file, "BCRYPT").saveFileToLocal("/usr/tmp");
    }

    @DisplayName("파일을 암호화하고, API를 통해 업로드 합니다.")
    @Test
    void encyrptFileAndUpload() {
        encryptors.encryption(file, "AES").uploadFileToServer("https://client.io/api/v1/uplodas");
        encryptors.encryption(file, "BCRYPT").uploadFileToServer("https://client.io/api/v1/uplodas");
    }
}
