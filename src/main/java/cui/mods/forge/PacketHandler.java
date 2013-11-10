package cui.mods.forge;

import java.nio.charset.Charset;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cui.events.LogBlockEvent;
import cui.events.WorldConnectEvent;
import cui.events.WorldEditEvent;
import cui.fevents.EventManager;

public class PacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager,
                        Packet250CustomPayload packet, Player playerEntity) {
            String data = new String(packet.data, Charset.forName("UTF-8"));

            String[] split = data.split("[|]");
            String type = split[0];
            String[] args = data.substring(type.length() + 1).split("[|]");
            if (packet.channel.equals("WECUI")) {
                WorldEditEvent event = new WorldEditEvent(type, args);
                EventManager.callEvent(event);
              } else if (packet.channel.equals("LBCUI")) {
                LogBlockEvent event = new LogBlockEvent(type, args);
                EventManager.callEvent(event);
              }
        }
}