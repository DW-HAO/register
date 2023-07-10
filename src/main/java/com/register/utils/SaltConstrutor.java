package com.register.utils;

import java.security.SecureRandom;

public class SaltConstrutor {

    public int nextSalt() {
        SecureRandom random = new SecureRandom();
        return  (int) (random.nextDouble() * 899999 + 100000);
    }
}
