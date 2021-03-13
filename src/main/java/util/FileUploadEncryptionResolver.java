package util;

import java.io.File;

public class FileUploadEncryptionResolver implements EncryptionResolver {

    private final String URL;
    private final String accessToken;


    public FileUploadEncryptionResolver(String URL, String accessToken) {
        this.URL = URL;
        this.accessToken = accessToken;
    }

    @Override
    public void resolve(File encryptedFile) {
        // 객체 생성 시 전달 받은 URL에 accesstoken을 통해서 encryptedFile을 업로드 한다.
        System.out.println("파일 업로드");
    }
}
