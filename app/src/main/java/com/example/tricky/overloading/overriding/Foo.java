package com.example.tricky.overloading.overriding;

public class Foo {
    public int calcMin(int a, int b) {
        return a < b ? a : b;
    }

    public int calcMin(int a, int b, int c) {
        int firstMin = calcMin(a, b);
        return c < firstMin ? c : firstMin;
    }
}


