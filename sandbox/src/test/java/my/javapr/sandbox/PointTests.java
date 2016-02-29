package my.javapr.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by allan on 2/28/2016.
 */
public class PointTests {

  @Test
  public void testArea() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(distance(p1, p2), 5.0);
  }

  public static double distance(Point p1, Point p2) {
    double dx = p2.x - p1.x;
    double dy = p2.y - p1.y;
    return Math.sqrt(dx*dx + dy*dy);
  }
}
