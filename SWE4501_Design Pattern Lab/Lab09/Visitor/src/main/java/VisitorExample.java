// Element interface
interface Shape {
    void accept(Visitor visitor);
}

// Concrete element
class Circle implements Shape {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete element
class Square implements Shape {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface Visitor {
    void visit(Circle circle);
    void visit(Square square);
}

// Concrete visitor
class AreaVisitor implements Visitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Calculating area of circle");
    }

    @Override
    public void visit(Square square) {
        System.out.println("Calculating area of square");
    }
}

// Client part
public class VisitorExample {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        Visitor areaVisitor = new AreaVisitor();

        circle.accept(areaVisitor);
        square.accept(areaVisitor);
    }
}
