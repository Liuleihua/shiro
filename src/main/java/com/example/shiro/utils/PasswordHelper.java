package com.example.shiro.utils;

import com.example.shiro.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {

    private static final String algorithmName = "md5";
    private static final int hashIterations = 2;

    public static void encryptPassword(User user) {
        String newPassword = new SimpleHash(
                algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), hashIterations
        ).toHex();
        user.setPassword(newPassword);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.randomSalt();
        encryptPassword(user);
        System.out.println(user);
    }
}
