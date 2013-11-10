package cui.mods.forge;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import cui.mods.forge.CUICommonProxy;
import cui.mods.modloader.WireEntity;
import cui.mods.modloader.WireRenderer;

public class CUIClientProxy extends CUICommonProxy {
        
        @Override
        public void registerRenderers() {
        	RenderingRegistry.registerEntityRenderingHandler(WireEntity.class, new WireRenderer());
        }
        
}