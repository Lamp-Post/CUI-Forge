package cui.config;

import cui.CUIBase;
import cui.render.LineColor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CUIConfiguration
{
  private boolean debugMode = false;
  private boolean ignoreUpdates = false;
  private String cuboidGridColor = "#CC3333";
  private String cuboidEdgeColor = "#CC4C4C";
  private String cuboidFirstPointColor = "#33CC33";
  private String cuboidSecondPointColor = "#3333CC";
  private String polyGridColor = "#CC3333";
  private String polyEdgeColor = "#CC4C4C";
  private String polyPointColor = "#33CCCC";
  private String ellipsoidGridColor = "#CC4C4C";
  private String ellipsoidPointColor = "#CCCC33";
  private String cylinderGridColor = "#CC3333";
  private String cylinderEdgeColor = "#CC4C4C";
  private String cylinderPointColor = "#CC33CC";
  private String updateFile = "https://raw.github.com/Lamp-Post/CUI-Forge/master/updates.yml";
  private Configuration config = null;

  public CUIConfiguration(File modFolder) {
    setColors();

    File file = new File(modFolder, "CUIConfiguration.yml");
    file.getParentFile().mkdirs();

    if (!file.exists()) {
      InputStream input = CUIBase.class.getResourceAsStream("/CUIConfiguration.yml");
      if (input != null) {
        FileOutputStream output = null;
        try
        {
          output = new FileOutputStream(file);
          byte[] buf = new byte[8192];
          int length = 0;
          while ((length = input.read(buf)) > 0)
            output.write(buf, 0, length);
        }
        catch (IOException e)
        {
          e.printStackTrace();
        } finally {
          try {
            if (input != null)
              input.close();
          }
          catch (IOException e)
          {
          }
          try {
            if (output != null)
              output.close();
          }
          catch (IOException e)
          {
          }
        }
      }
    }
    this.config = new Configuration(file);
    this.config.load();

    this.debugMode = this.config.getBoolean("debug", this.debugMode);
    this.ignoreUpdates = this.config.getBoolean("ignoreUpdates", this.ignoreUpdates);

    this.cuboidGridColor = parseColor(this.config.getString("colors.cuboidGrid"), this.cuboidGridColor);
    this.cuboidEdgeColor = parseColor(this.config.getString("colors.cuboidEdge"), this.cuboidEdgeColor);
    this.cuboidFirstPointColor = parseColor(this.config.getString("colors.cuboidFirstPoint"), this.cuboidFirstPointColor);
    this.cuboidSecondPointColor = parseColor(this.config.getString("colors.cuboidSecondPoint"), this.cuboidSecondPointColor);
    this.polyGridColor = parseColor(this.config.getString("colors.polyGrid"), this.polyGridColor);
    this.polyEdgeColor = parseColor(this.config.getString("colors.polyEdge"), this.polyEdgeColor);
    this.polyPointColor = parseColor(this.config.getString("colors.polyPoint"), this.polyPointColor);
    this.ellipsoidGridColor = parseColor(this.config.getString("colors.ellipsoidGrid"), this.ellipsoidGridColor);
    this.ellipsoidPointColor = parseColor(this.config.getString("colors.ellipsoidPoint"), this.ellipsoidPointColor);
    this.cylinderGridColor = parseColor(this.config.getString("colors.cylinderGrid"), this.cylinderGridColor);
    this.cylinderEdgeColor = parseColor(this.config.getString("colors.cylinderEdge"), this.cylinderEdgeColor);
    this.cylinderPointColor = parseColor(this.config.getString("colors.cylinderPoint"), this.cylinderPointColor);

    setColors();

    this.updateFile = this.config.getString("updateFile", this.updateFile);
  }

  private void setColors() {
    LineColor.CUBOIDBOX.setColor(this.cuboidEdgeColor);
    LineColor.CUBOIDGRID.setColor(this.cuboidGridColor);
    LineColor.CUBOIDPOINT1.setColor(this.cuboidFirstPointColor);
    LineColor.CUBOIDPOINT2.setColor(this.cuboidSecondPointColor);
    LineColor.POLYGRID.setColor(this.polyGridColor);
    LineColor.POLYBOX.setColor(this.polyEdgeColor);
    LineColor.POLYPOINT.setColor(this.polyPointColor);
    LineColor.ELLIPSOIDGRID.setColor(this.ellipsoidGridColor);
    LineColor.ELLIPSOIDCENTER.setColor(this.ellipsoidPointColor);
    LineColor.CYLINDERGRID.setColor(this.cylinderGridColor);
    LineColor.CYLINDERBOX.setColor(this.cylinderEdgeColor);
    LineColor.CYLINDERCENTER.setColor(this.cylinderPointColor);
  }

  private String parseColor(String color, String def)
  {
    if (color == null)
      return def;
    if (!color.startsWith("#"))
      return def;
    if (color.length() != 7) {
      return def;
    }

    String r = color.substring(1, 3);
    String g = color.substring(3, 5);
    String b = color.substring(5, 7);
    try
    {
      int rI = Integer.parseInt(r, 16);
      int gI = Integer.parseInt(g, 16);
      int bI = Integer.parseInt(b, 16);

      return color; } catch (NumberFormatException e) {
    }
    return def;
  }

  public boolean isDebugMode()
  {
    return this.debugMode;
  }

  public boolean ignoreUpdates() {
    return this.ignoreUpdates;
  }

  public String getUpdateFile() {
    return this.updateFile;
  }
}