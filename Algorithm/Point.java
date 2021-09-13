package Algorithm;

class Point
{
  int x, y;
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public double dist(Point p)
  {
 
    return Math.sqrt((this.x - p.x) * (this.x - p.x)
                     + (this.y - p.y) * (this.y - p.y));
  }
}
 
