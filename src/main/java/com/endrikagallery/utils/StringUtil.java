package com.endrikagallery.utils;

public final class StringUtil {
    public static final String EMPTY = "";

    private StringUtil() {
    }

    public static String toKey(String str) {
        if (isEmpty(str)) {
            return EMPTY;
        }
        return str.strip().toLowerCase();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
