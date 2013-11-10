package cui.events;

import cui.CUIBase;
import cui.IMod;
import cui.fevents.Listener;
import java.nio.charset.Charset;

public class WorldConnectEventListener
  implements Listener<WorldConnectEvent>
{
  private CUIBase controller;

  public WorldConnectEventListener(CUIBase controller)
  {
    this.controller = controller;
  }

  public void onEvent(WorldConnectEvent event)
  {
	if(controller.isCalled == false){
    Charset charset = Charset.forName("UTF-8");
    byte[] weBuffer = "v|2".getBytes(charset);
    this.controller.getMod().sendPacket("WECUI", weBuffer.length, weBuffer);

    byte[] lbBuffer = "v|1".getBytes(charset);
    this.controller.getMod().sendPacket("LBCUI", lbBuffer.length, lbBuffer);
    
    controller.isCalled = true;
	}
  }
}