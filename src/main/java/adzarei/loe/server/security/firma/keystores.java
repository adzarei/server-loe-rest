package adzarei.loe.server.security.firma;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;

public class keystores {

    private Long id;
    @Transient
    private KeyStore keyStore;
    private String passwordForKeyStore;
    private Byte[] keyStoreAsBytes;

    @PreUpdate
    @PrePersist
    public void concertKeyStoreToBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        keyStore.store(byteArrayOutputStream, passwordForKeyStore.toCharArray());
        keyStoreAsBytes = byteArrayOutputStream.toByteArray();
    }

    @PostLoad
    public void getKeyStore() {
        if (keyStore == null && keyStoreAsBytes != null) {
            this.keyStore = KeyStore.getInstance(getKeystoreType().getType());
            this.keyStore.load(new ByteArrayInputStream(keyStoreAsBytes), this.passwordForKeyStore.toCharArray());
        }

    }
