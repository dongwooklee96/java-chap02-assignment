package service;

import java.io.File;

public interface Uploadable {
    void uploadFileToServer(String path, File file);
}
