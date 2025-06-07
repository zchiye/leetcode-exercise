package io.zchiye.utils;

public class CharUtils {

    public static boolean isAlphanumeric(char r) {
        return (r >= '0' && r <= '9')
                || (r >= 'a' && r <= 'z')
                || (r >= 'A' && r <= 'Z');
    }

}
