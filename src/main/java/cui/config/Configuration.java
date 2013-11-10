package cui.config;

import cui.exception.ConfigurationException;
import cui.vendor.org.yaml.snakeyaml.DumperOptions;
import cui.vendor.org.yaml.snakeyaml.DumperOptions.FlowStyle;
import cui.vendor.org.yaml.snakeyaml.Yaml;
import cui.vendor.org.yaml.snakeyaml.constructor.SafeConstructor;
import cui.vendor.org.yaml.snakeyaml.reader.UnicodeReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Configuration extends ConfigurationNode
{
  private Yaml yaml;
  private File file;
  private String header = null;

  public Configuration(File file) {
    super(new HashMap());

    DumperOptions options = new DumperOptions();

    options.setIndent(4);
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

    this.yaml = new Yaml(new SafeConstructor(), new EmptyNullRepresenter(), options);

    this.file = file;
  }

  public void load()
  {
    FileInputStream stream = null;
    try
    {
      stream = new FileInputStream(this.file);
      read(this.yaml.load(new UnicodeReader(stream)));
    } catch (IOException e) {
      this.root = new HashMap();
    } catch (ConfigurationException e) {
      this.root = new HashMap();
    } finally {
      try {
        if (stream != null)
          stream.close();
      }
      catch (IOException e)
      {
      }
    }
  }

  public void setHeader(String[] headerLines)
  {
    StringBuilder headerTemp = new StringBuilder();

    for (String line : headerLines) {
      if (headerTemp.length() > 0) {
        headerTemp.append("\r\n");
      }
      headerTemp.append(line);
    }

    setHeader(headerTemp.toString());
  }

  public void setHeader(String header)
  {
    this.header = header;
  }

  public String getHeader()
  {
    return this.header;
  }

  public boolean save()
  {
    FileOutputStream stream = null;

    File parent = this.file.getParentFile();

    if (parent != null) {
      parent.mkdirs();
    }
    try
    {
      stream = new FileOutputStream(this.file);
      OutputStreamWriter writer = new OutputStreamWriter(stream, "UTF-8");
      if (this.header != null) {
        writer.append(this.header);
        writer.append("\r\n");
      }
      this.yaml.dump(this.root, writer);
      return true;
    } catch (IOException e) {
    } finally {
      try {
        if (stream != null)
          stream.close();
      }
      catch (IOException e)
      {
      }
    }
    return false;
  }

  private void read(Object input) throws ConfigurationException
  {
    try {
      if (null == input)
        this.root = new HashMap();
      else
        this.root = ((Map)input);
    }
    catch (ClassCastException e) {
      throw new ConfigurationException("Root document must be an key-value structure");
    }
  }

  public static ConfigurationNode getEmptyNode()
  {
    return new ConfigurationNode(new HashMap());
  }
}