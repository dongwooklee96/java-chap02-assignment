package service;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.AES256Encryptors;
import util.BcryptEncryptors;
import util.FileTransferEncryptionResolver;
import util.FileUploadEncryptionResolver;

class FileEncryptionModuleTest {
    File file;

    @BeforeEach
    void setUp() {
        file = new File("test.txt");
    }

    @DisplayName("파일을 AES 알고리즘으로 암호화 하고, 결과를 파일을 로컬에 저장한다.")
    @Test
    void encryptAesFileAndSaveLocal() {
        new FileEncryptionModule(new AES256Encryptors(), new FileTransferEncryptionResolver("path to save")).encryption(file);
    }

    @DisplayName("파일을 Bcrypt 알고리즘으로 암호화 하고, 결과를 파일을 로컬에 저장한다.")
    @Test
    void encryptBcryptFileAndSaveLocal() {
        new FileEncryptionModule(new BcryptEncryptors(), new FileTransferEncryptionResolver("path to save")).encryption(file);
    }

    @DisplayName("파일을 AES 알고리즘으로 암호화하고, API 를 통해 업로드 합니다.")
    @Test
    void encyrptAesFileAndUpload() {
        new FileEncryptionModule(new AES256Encryptors(), new FileUploadEncryptionResolver("path to save", "token")).encryption(file);
    }

    @DisplayName("파일을 Bcrypt 알고리즘으로 암호화하고, API 를 통해 업로드 합니다.")
    @Test
    void encyrptBcryptFileAndUpload() {
        new FileEncryptionModule(new BcryptEncryptors(), new FileUploadEncryptionResolver("path to save", "token")).encryption(file);
    }
}
