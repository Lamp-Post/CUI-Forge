package cui.util.vector;

public class CUIBlock
{
  private Vector3 pos;
  private int id;

  public CUIBlock(Vector3 pos, int id)
  {
    this.pos = pos;
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Vector3 getPos() {
    return this.pos;
  }

  public void setPos(Vector3 pos) {
    this.pos = pos;
  }
}