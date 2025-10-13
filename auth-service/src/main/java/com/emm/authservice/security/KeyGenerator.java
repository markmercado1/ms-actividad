package com.emm.authservice.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) {
        byte[] key = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
        System.out.println(Base64.getEncoder().encodeToString(key));
    }
}
