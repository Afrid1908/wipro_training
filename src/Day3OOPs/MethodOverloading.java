package Day3OOPs;

class Shape1 {
    // Method with no parameters
    void draw() {
        System.out.println("Drawing a shape");
    }

    // Overloaded method with one parameter
    void draw(String shapeType) {
        System.out.println("Drawing a " + shapeType);
    }

    // Overloaded method with two parameters
    void draw(String shapeType, int size) {
        System.out.println("Drawing a " + shapeType + " with size " + size);
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Shape1 shape = new Shape1();

        shape.draw();                            // No-arg method
        shape.draw("Circle");                    // Single-arg method
        shape.draw("Rectangle", 10);             // Two-arg method
    }
}
