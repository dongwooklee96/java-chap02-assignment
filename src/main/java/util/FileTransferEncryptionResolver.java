package util;

import java.io.File;

public class FileTransferEncryptionResolver implements EncryptionResolver {

    private final String path;

    public FileTransferEncryptionResolver(String path) {
        this.path = path;
    }

    @Override
    public void resolve(File encryptedFile) {
        // 객체 생성 시 전달 받은 path에 encryptedFile을 저장한다.
        System.out.println("로컬에 저장");
    }
}
