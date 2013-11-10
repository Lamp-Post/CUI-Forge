package cui.util.vector;

public class Vector2m extends Vector2
{
  public Vector2m()
  {
  }

  public Vector2m(Double x, Double y)
  {
    super(x, y);
  }

  public Vector2m(float x, float y) {
    super(x, y);
  }

  public Vector2m(Vector2 original) {
    super(original);
  }

  public void setX(float x)
  {
    this.x = x;
  }

  public void setY(float y)
  {
    this.z = y;
  }

  public Vector2 add(Vector2 that)
  {
    this.x += that.x;
    this.z += that.z;
    return this;
  }

  public Vector2 subtract(Vector2 that)
  {
    this.x -= that.x;
    this.z -= that.z;
    return this;
  }

  public Vector2 scale(float scale)
  {
    this.x *= scale;
    this.z *= scale;
    return this;
  }

  public Vector2 cross(Vector2 that) {
    float tmp = this.z;
    this.z = (-this.x);
    this.x = tmp;
    return this;
  }

  public Vector2 ceil()
  {
    this.x = ((float)Math.ceil(this.x));
    this.z = ((float)Math.ceil(this.z));
    return this;
  }

  public Vector2 floor()
  {
    this.x = ((float)Math.floor(this.x));
    this.z = ((float)Math.floor(this.z));
    return this;
  }

  public Vector2 round()
  {
    this.x = Math.round(this.x);
    this.z = Math.round(this.z);
    return this;
  }

  public Vector2 abs()
  {
    this.x = Math.abs(this.x);
    this.z = Math.abs(this.z);
    return this;
  }

  public Vector2 normalize()
  {
    float length = length();
    this.x *= 1.0F / length;
    this.z *= 1.0F / length;
    return this;
  }
}