package cui;

import cui.config.CUIConfiguration;
import cui.config.ConfigurationNode;
import cui.exception.ConfigurationException;
import cui.util.ChatColor;
import cui.vendor.org.yaml.snakeyaml.Yaml;
import cui.vendor.org.yaml.snakeyaml.reader.UnicodeReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Updater extends Thread
{
  private CUIBase controller;
  private final int updaterVersion = 1;

  public Updater(CUIBase controller) {
    this.controller = controller;
  }

  public void run()
  {
    if (this.controller.getConfiguration().ignoreUpdates()) {
      return;
    }

    InputStream is = null;
    ConfigurationNode node = new ConfigurationNode(new HashMap());
    try
    {
      URL url = new URL(this.controller.getConfiguration().getUpdateFile());
      url.openConnection();
      is = url.openStream();

      Yaml yaml = new Yaml();
      Object out = yaml.load(new UnicodeReader(is));
      try
      {
        if (null != out)
          node.setRoot((Map)out);
      }
      catch (ClassCastException e) {
        throw new ConfigurationException("Root document must be an key-value structure");
      }

      getClass(); String currentVersion = node.getString("updaterVersion" + 1 + ".current");
      getClass(); List supportedVersions = node.getStringList("updaterVersion" + 1 + ".supported", new ArrayList());

      if ((currentVersion != null) && (!currentVersion.equals("1.6.4")) && (!(currentVersion + "beta").equals("1.6.4")) && 
        (supportedVersions != null) && (!supportedVersions.contains("1.6.4"))) {
        this.controller.getLastPlayer().showChatMessage(ChatColor.RED + "Your CUIBase version is out of date! ");
        this.controller.getLastPlayer().showChatMessage(ChatColor.RED + "The latest version is " + currentVersion + ". http://bit.ly/wecui");
      }

    }
    catch (Exception e)
    {
      CUIDebug.getInstance().info("Error in fetching update file!", e);
    } finally {
      if (is != null)
        try {
          is.close();
        }
        catch (IOException e)
        {
        }
    }
  }
}