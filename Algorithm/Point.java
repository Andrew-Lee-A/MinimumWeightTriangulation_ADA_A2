package Algorithm;

public class Point
{
  private int x, y;
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double dist(Point p)
  {
 
    return Math.sqrt((this.x - p.x) * (this.x - p.x)
                     + (this.y - p.y) * (this.y - p.y));
  }
}
 
