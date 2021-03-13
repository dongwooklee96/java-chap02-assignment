package service;

import java.io.File;

public class Saving implements SaveLocalable, Uploadable {
    @Override
    public void saveFileToLocal(String path, File file) {
        // 암호화 결과를 /usr/tmp에 저장한다.
        System.out.println("암호화된 결과를 " + path + " 에 저장한다.");
    }

    @Override
    public void uploadFileToServer(String path, File file) {
        // 암호화 결과를 https://client.io/api/v1/uploads 서버에 저장한다.
        System.out.println("암호화된 결과를 " + path + " 에 저장한다.");
    }
}
