package cui.util.vector;

public class Vector2
  implements Comparable<Vector2>
{
  public static final Vector2 ZERO = new Vector2(0.0F, 0.0F);

  public static final Vector2 UNIT_X = new Vector2(1.0F, 0.0F);

  public static final Vector2 UNIT_Y = new Vector2(0.0F, 1.0F);

  public static Vector2 ONE = new Vector2(1.0F, 1.0F);
  protected float x;
  protected float z;

  public Vector2(float x, float y)
  {
    this.x = x;
    this.z = y;
  }

  public Vector2(Double x, Double y)
  {
    this(x.floatValue(), y.floatValue());
  }

  public Vector2()
  {
    this(0.0F, 0.0F);
  }

  public Vector2(Vector2 original)
  {
    this(original.x, original.z);
  }

  public float getX()
  {
    return this.x;
  }

  public float getY()
  {
    return this.z;
  }

  public Vector2 add(Vector2 that)
  {
    return add(this, that);
  }

  public Vector2 subtract(Vector2 that)
  {
    return subtract(this, that);
  }

  public Vector2 scale(float scale)
  {
    return scale(this, scale);
  }

  public float dot(Vector2 that)
  {
    return dot(this, that);
  }

  public Vector3 toVector3()
  {
    return toVector3(this);
  }

  public Vector3m toVector3m()
  {
    return toVector3m(this);
  }

  public Vector3 toVector3(float y)
  {
    return toVector3(this, y);
  }

  public Vector3m toVector3m(float y)
  {
    return toVector3m(this, y);
  }

  public Vector2 cross()
  {
    return new Vector2(this.z, -this.x);
  }

  public Vector2 ceil()
  {
    return new Vector2(Double.valueOf(Math.ceil(this.x)), Double.valueOf(Math.ceil(this.z)));
  }

  public Vector2 floor()
  {
    return new Vector2(Double.valueOf(Math.floor(this.x)), Double.valueOf(Math.floor(this.z)));
  }

  public Vector2 round()
  {
    return new Vector2(Math.round(this.x), Math.round(this.z));
  }

  public Vector2 abs()
  {
    return new Vector2(Math.abs(this.x), Math.abs(this.z));
  }

  public double distance(Vector2 a)
  {
    return distance(a, this);
  }

  public Vector2 pow(double power)
  {
    return pow(this, power);
  }

  public float lengthSquared()
  {
    return lengthSquared(this);
  }

  public float length()
  {
    return length(this);
  }

  public Vector2 normalize()
  {
    return normalize(this);
  }

  public float[] toArray()
  {
    return toArray(this);
  }

  public int compareTo(Vector2 o)
  {
    return compareTo(this, o);
  }

  public boolean equals(Object o)
  {
    return equals(this, o);
  }

  public static float length(Vector2 a)
  {
    return (float)Math.sqrt(lengthSquared(a));
  }

  public static float lengthSquared(Vector2 a)
  {
    return dot(a, a);
  }

  public static Vector2 normalize(Vector2 a)
  {
    return scale(a, 1.0F / a.length());
  }

  public static Vector2 subtract(Vector2 a, Vector2 b)
  {
    return new Vector2(a.getX() - b.getX(), a.getY() - b.getY());
  }

  public static Vector2 add(Vector2 a, Vector2 b)
  {
    return new Vector2(a.getX() + b.getX(), a.getY() + b.getY());
  }

  public static Vector2 scale(Vector2 a, float b)
  {
    return new Vector2(a.getX() * b, a.getY() * b);
  }

  public static float dot(Vector2 a, Vector2 b)
  {
    return a.getX() * b.getX() + a.getY() * b.getY();
  }

  public static Vector3 toVector3(Vector2 o)
  {
    return new Vector3(o.x, 0.0F, o.z);
  }

  public static Vector3m toVector3m(Vector2 o)
  {
    return new Vector3m(o.x, 0.0F, o.z);
  }

  public static Vector3 toVector3(Vector2 o, float y)
  {
    return new Vector3(o.x, y, o.z);
  }

  public static Vector3m toVector3m(Vector2 o, float y)
  {
    return new Vector3m(o.x, y, o.z);
  }

  public static Vector2 ceil(Vector2 o)
  {
    return new Vector2(Double.valueOf(Math.ceil(o.x)), Double.valueOf(Math.ceil(o.z)));
  }

  public static Vector2 floor(Vector2 o)
  {
    return new Vector2(Double.valueOf(Math.floor(o.x)), Double.valueOf(Math.floor(o.z)));
  }

  public static Vector2 round(Vector2 o)
  {
    return new Vector2(Math.round(o.x), Math.round(o.z));
  }

  public static Vector2 abs(Vector2 o)
  {
    return new Vector2(Math.abs(o.x), Math.abs(o.z));
  }

  public static Vector2 min(Vector2 o1, Vector2 o2)
  {
    return new Vector2(Math.min(o1.x, o2.x), Math.min(o1.z, o2.z));
  }

  public static Vector2 max(Vector2 o1, Vector2 o2)
  {
    return new Vector2(Math.max(o1.x, o2.x), Math.max(o1.z, o2.z));
  }

  public static Vector2 rand()
  {
    return new Vector2(Double.valueOf(Math.random()), Double.valueOf(Math.random()));
  }

  public static float[] toArray(Vector2 a)
  {
    return new float[] { a.getX(), a.getY() };
  }

  public static int compareTo(Vector2 a, Vector2 b)
  {
    return (int)a.lengthSquared() - (int)b.lengthSquared();
  }

  public static double distance(Vector2 a, Vector2 b)
  {
    Vector2 tempVector = pow(subtract(a, b), 2.0D);
    return Math.sqrt(tempVector.x + tempVector.z);
  }

  public static Vector2 pow(Vector2 o, double power)
  {
    return new Vector2(Double.valueOf(Math.pow(o.x, power)), Double.valueOf(Math.pow(o.z, power)));
  }

  public static boolean equals(Object a, Object b)
  {
    if ((!(a instanceof Vector2)) || (!(b instanceof Vector2))) {
      return false;
    }
    if (a == b) {
      return true;
    }
    return compareTo((Vector2)a, (Vector2)b) == 0;
  }

  public String toString()
  {
    return "(" + this.x + ", " + this.z + ")";
  }
}