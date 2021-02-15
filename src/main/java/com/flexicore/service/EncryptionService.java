package com.flexicore.service;

import com.flexicore.interfaces.FlexiCoreService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface EncryptionService extends FlexiCoreService {
    /**
     * encrypt data
     * @param plaintext data to encrypt
     * @param associatedData salt
     * @return encrypted data
     * @throws GeneralSecurityException
     */
    byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException;

    /**
     * decrypt data
     * @param ciphertext encrypted data
     * @param associatedData salt used when encrypted
     * @return decrypted data
     * @throws GeneralSecurityException
     */
    byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException;

    byte[] getEncryptingKey();

    EncryptingKey parseKey(byte[] encryptingKey) throws IOException,GeneralSecurityException;


    interface EncryptingKey {
        byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException;

        byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException;
    }
}
