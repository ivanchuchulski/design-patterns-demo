package com.example.tricky.inheritance.composition;

import java.util.Objects;

public class InheritanceCompositionDemo {
    public void demo() {
        Component triangle = new Triangle();
        triangle.render();

        Square square = new Square();
        square.render();

        if (triangle instanceof Component) {
            System.out.println("yes");
        }

    }
}

class Component {
    public void render() {

    }
}

class Triangle extends Component {

}

class Square {
    private Component component;

    public Square() {
        component = new Component();
    }

    public void render() {
        component.render();
    }
}

