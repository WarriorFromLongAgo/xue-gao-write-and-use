package org.springframework.util;

import java.nio.charset.StandardCharsets;

public class TestDigestUtils {
    public static void main(String[] args) {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8));

    }
}
