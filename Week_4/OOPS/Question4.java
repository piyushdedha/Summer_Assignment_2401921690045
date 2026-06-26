class Box {

    int length;
    int breadth;

    Box(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int area() {
        return length * breadth;
    }
}

class Box3D extends Box {

    int height;

    Box3D(int length, int breadth, int height) {
        super(length, breadth);
        this.height = height;
    }

    int volume() {
        return length * breadth * height;
    }
}

public class Question4 {

    public static void main(String[] args) {

        Box b = new Box(10, 5);
        System.out.println("Area = " + b.area());

        Box3D b3 = new Box3D(10, 5, 4);
        System.out.println("Area = " + b3.area());
        System.out.println("Volume = " + b3.volume());
    }
}
