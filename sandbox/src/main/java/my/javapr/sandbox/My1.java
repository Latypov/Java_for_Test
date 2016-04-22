package my.javapr.sandbox;

public class My1 {

  public static void main(String[] args) {

    System.out.println("Hello, world!");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    double k = 7;
    System.out.println("Площадь квадрата со стороной " + k + " = " + k * k);

    Rectangle r = new Rectangle(4, 7);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));

  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }

}