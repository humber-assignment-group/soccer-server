package com.github.humbergroup.soccer;

public class Helper {

    public static void notNullRequired(Object obj, String message) {
        assert obj != null : message;
    }
}
