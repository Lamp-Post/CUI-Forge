package cui.util.vector;

public class Vector3m extends Vector3
{
  public Vector3m(float x, float y, float z)
  {
    super(x, y, z);
  }

  public Vector3m(Double x, Double y, Double z) {
    super(x, y, z);
  }

  public Vector3m(Vector3 vector) {
    super(vector);
  }

  public Vector3m() {
  }

  public void setZ(float z) {
    this.z = z;
  }

  public void setY(float y) {
    this.y = y;
  }

  public void setX(float x) {
    this.x = x;
  }

  public Vector3 add(Vector3 that)
  {
    this.x += that.x;
    this.y += that.y;
    this.z += that.z;
    return this;
  }

  public Vector3 subtract(Vector3 that)
  {
    this.x -= that.x;
    this.y -= that.y;
    this.z -= that.z;
    return this;
  }

  public Vector3 scale(float scale)
  {
    this.x *= scale;
    this.y *= scale;
    this.z *= scale;
    return this;
  }

  public Vector3 cross(Vector3 that)
  {
    this.x = (getY() * that.getZ() - getZ() * that.getY());
    this.y = (getZ() * that.getX() - getX() * that.getZ());
    this.z = (getX() * that.getY() - getY() * that.getX());

    return this;
  }

  public Vector3 ceil()
  {
    this.x = ((float)Math.ceil(this.x));
    this.y = ((float)Math.ceil(this.y));
    this.z = ((float)Math.ceil(this.z));
    return this;
  }

  public Vector3 floor()
  {
    this.x = ((float)Math.floor(this.x));
    this.y = ((float)Math.floor(this.y));
    this.z = ((float)Math.floor(this.z));
    return this;
  }

  public Vector3 round()
  {
    this.x = Math.round(this.x);
    this.y = Math.round(this.y);
    this.z = Math.round(this.z);
    return this;
  }

  public Vector3 abs()
  {
    this.x = Math.abs(this.x);
    this.y = Math.abs(this.y);
    this.z = Math.abs(this.z);
    return this;
  }

  public Vector3 normalize()
  {
    float length = length();
    this.x *= 1.0F / length;
    this.y *= 1.0F / length;
    this.z *= 1.0F / length;
    return this;
  }
}