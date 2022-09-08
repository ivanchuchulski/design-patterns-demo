package com.example.tricky.overloading.overriding;

public class OverloadingOverridingDemo {
    public void demo() {
        Foo foo = new Foo();
        System.out.println(foo.calcMin(100, 10));
        System.out.println(foo.calcMin(100, -7, 20));

        Foo bar = new Bar();
        System.out.println(bar.calcMin(100, -1, 10));
    }
}
