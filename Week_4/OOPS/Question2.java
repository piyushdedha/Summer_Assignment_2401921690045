class Outer {

    void display() {
        System.out.println("Display of Outer Class");
    }

    class Inner {

        void display() {
            System.out.println("Display of Inner Class");
        }
    }
}

public class Question2 {

    public static void main(String[] args) {

        Outer obj1 = new Outer();
        obj1.display();

        Outer.Inner obj2 = obj1.new Inner();
        obj2.display();
    }
}
