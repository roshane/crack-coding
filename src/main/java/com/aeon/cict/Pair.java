package com.aeon.cict;

/**
 * Created by roshane on 7/16/17.
 */
class Pair {
    String a, b;

    Pair(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return String.format("{%s, %s}", a, b);
    }
}
