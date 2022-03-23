package com.qj.util;

import java.util.UUID;

public class UUIDUtils {
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
