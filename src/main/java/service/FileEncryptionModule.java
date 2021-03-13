package service;

import java.io.File;

import util.EncryptionResolver;
import util.Encryptors;

public class FileEncryptionModule {

    private final Encryptors encryptors;
    private final EncryptionResolver resolver;

    public FileEncryptionModule(Encryptors encryptors, EncryptionResolver resolver) {
        this.encryptors = encryptors;
        this.resolver = resolver;
    }

    public void encryption(File file) {
        final File encryptedFile = encryptors.encryption(file);
        resolver.resolve(encryptedFile);
    }

    public void encryption(Encryptors encryptors, EncryptionResolver resolver, File file) {
        final File encryptedFile = encryptors.encryption(file);
        resolver.resolve(encryptedFile);
    }
}
