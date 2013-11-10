package cui.render;

public enum LineColor
{
  CUBOIDGRID, 
  CUBOIDBOX, 
  CUBOIDPOINT1, 
  CUBOIDPOINT2, 
  POLYGRID, 
  POLYBOX, 
  POLYPOINT, 
  ELLIPSOIDGRID, 
  ELLIPSOIDCENTER, 
  CYLINDERGRID, 
  CYLINDERBOX, 
  CYLINDERCENTER;

  private LineInfo normal;
  private LineInfo hidden;

  public LineInfo getHidden() { return this.hidden; }

  public LineInfo getNormal()
  {
    return this.normal;
  }

  public LineInfo[] getColors() {
    return new LineInfo[] { this.hidden, this.normal };
  }

  public void setColor(String hex)
  {
    Integer r = Integer.valueOf(Integer.parseInt(hex.substring(1, 3), 16));
    Integer g = Integer.valueOf(Integer.parseInt(hex.substring(3, 5), 16));
    Integer b = Integer.valueOf(Integer.parseInt(hex.substring(5, 7), 16));

    float rF = r.floatValue() / 256.0F;
    float gF = g.floatValue() / 256.0F;
    float bF = b.floatValue() / 256.0F;

    this.normal = new LineInfo(3.0F, rF, gF, bF, 0.8F, 513);
    this.hidden = new LineInfo(3.0F, rF, gF, bF, 0.2F, 518);
  }
}