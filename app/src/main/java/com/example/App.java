package com.example;

import com.example.tricky.inheritance.composition.InheritanceCompositionDemo;
import com.example.tricky.overloading.overriding.OverloadingOverridingDemo;

public class App {
    public static void main(String[] args) {
        new OverloadingOverridingDemo().demo();
        new InheritanceCompositionDemo().demo();
    }
}
