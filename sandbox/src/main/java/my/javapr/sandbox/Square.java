package my.javapr.sandbox;

/**
 * Created by allan on 2/26/2016.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }
  public double area(Square s) {
    return s.l * s.l;
  }
}
