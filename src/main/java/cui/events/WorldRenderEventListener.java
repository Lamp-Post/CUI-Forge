package cui.events;

import cui.CUIBase;
import cui.IEntity;
import cui.IMod;
import cui.IRenderer;
import cui.fevents.Listener;
import cui.render.we.region.BaseRegion;
import org.lwjgl.opengl.GL11;

public class WorldRenderEventListener
  implements Listener<WorldRenderEvent>
{
  private CUIBase controller;

  public WorldRenderEventListener(CUIBase controller)
  {
    this.controller = controller;
  }

  public void onEvent(WorldRenderEvent event)
  {
    this.controller.getMod().getRenderer().disableLighting();
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(3042);

    GL11.glDisable(3553);
    GL11.glDepthMask(false);
    GL11.glPushMatrix();
    try
    {
      double tick = event.getPartialTick();
      IEntity player = this.controller.getLastPlayer();

      GL11.glTranslated(-player.getXGuess(tick), -player.getYGuess(tick), -player.getZGuess(tick));
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      if (this.controller.getWorldEditRegion() != null)
        this.controller.getWorldEditRegion().render();
    }
    catch (Exception e)
    {
    }
    GL11.glDepthFunc(515);
    GL11.glPopMatrix();

    GL11.glDepthMask(true);
    GL11.glEnable(3553);
    GL11.glDisable(3042);

    this.controller.getMod().getRenderer().enableLighting();
  }
}