package my.javapr.sandbox;

/**
 * Created by allan on 2/23/2016.
 */
public class RunPoint {
  public static void main(String[] args) {
    Point p1 = new Point();
    p1.x = 0;
    p1.y = 0;
    Point p2 = new Point();
    p2.x = 3;
    p2.y = 4;
    System.out.println("Distance between two Points: p1(" + p1.x + "," + p1.y + ") and p2(" + p2.x + "," +
            p2.y + ") = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    double dx = p2.x - p1.x;
    double dy = p2.y - p1.y;
    return Math.sqrt(dx*dx + dy*dy);
  }
}