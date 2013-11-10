package cui;

public abstract interface IRenderer
{
  public abstract void startDrawing(int paramInt);

  public abstract void addVertex(double paramDouble1, double paramDouble2, double paramDouble3);

  public abstract void finishDrawing();

  public abstract void disableLighting();

  public abstract void enableLighting();
}