package cui.mods.modloader;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cui.events.WorldRenderEvent;
import cui.fevents.EventManager;

public class WireRenderer extends Render
{
  private WorldRenderEvent event;

  public WireRenderer()
  {
    this.event = new WorldRenderEvent();
  }

  public void renderCUI(Entity entity, double x, double y, double z, float yaw, float renderTick) {
    this.event.setPartialTick(renderTick);
    EventManager.callEvent(this.event);
  }

  public void doRender(Entity entity, double x, double y, double z, float yaw, float renderTick)
  {
    renderCUI(entity, x, y, z, yaw, renderTick);
  }

@Override
protected ResourceLocation getEntityTexture(Entity entity) {
	return null;
}
}