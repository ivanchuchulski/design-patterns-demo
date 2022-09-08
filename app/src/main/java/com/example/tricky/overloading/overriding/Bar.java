package com.example.tricky.overloading.overriding;

public class Bar extends Foo {
    @Override
    public int calcMin(int a, int b) {
        return a < b ? 5 : -5;
    }
}
