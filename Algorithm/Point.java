package Algorithm;

// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323

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
  
  @Override
  public String toString(){
      return "(" + x + ", " + y + ")";
  }
}
 
