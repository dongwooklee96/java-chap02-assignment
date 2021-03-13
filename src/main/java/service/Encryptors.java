package service;

import java.io.File;

import util.Crypto;

public class Encryptors {
    File file;
    Crypto crypto;
    Saving saving;

    public Encryptors(Crypto crypto, Saving saving) {
        this.crypto = crypto;
        this.saving = saving;
    }

    public Encryptors encryption(File file, String type) {

        this.file = file;

        if ("AES".equals(type)) {
            crypto.aes256(this.file);
        }

        if ("BCRYPT".equals(type)) {
            crypto.bcrypt(this.file);
        }
        return this;
    }

    public void saveFileToLocal(String path) {
        saving.saveFileToLocal(path, this.file);
    }

    public void uploadFileToServer(String path) {
        saving.uploadFileToServer(path, this.file);
    }
}
