package cui.mods.notch;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import cui.IRenderer;

public class NotchRenderer
  implements IRenderer
{
  private Tessellator tess;

  public NotchRenderer()
  {
    this.tess = Tessellator.instance;
  }

  public void startDrawing(int type) {
    this.tess.startDrawing(type);
  }

  public void addVertex(double x, double y, double z)
  {
    this.tess.addVertex(x, y, z);
  }

  public void finishDrawing() {
    this.tess.draw();
  }

  public void disableLighting() {
    RenderHelper.disableStandardItemLighting();
  }

  public void enableLighting() {
    RenderHelper.enableStandardItemLighting();
  }
}