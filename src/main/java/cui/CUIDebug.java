package cui;

import cui.config.CUIConfiguration;
import cui.util.ConsoleLogFormatter;
import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CUIDebug
{
  private static CUIDebug instance;
  private File debugFile;
  private boolean debugMode = false;
  private static final Logger logger = Logger.getLogger("CUI");

  private CUIDebug(CUIBase controller, File modFolder) {
    ConsoleLogFormatter formatter = new ConsoleLogFormatter();
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(formatter);

    logger.setUseParentHandlers(false);
    logger.addHandler(handler);
    try
    {
      this.debugFile = new File(modFolder, "WorldEditCUI-debug.txt");
      this.debugMode = controller.getConfiguration().isDebugMode();

      if (this.debugMode) {
        FileHandler newHandler = new FileHandler(this.debugFile.getAbsolutePath());
        newHandler.setFormatter(formatter);
        logger.addHandler(newHandler);
      }
    }
    catch (IOException e) {
      e.printStackTrace(System.err);
      this.debugMode = false;
    }
  }

  public void debug(String message)
  {
    if (this.debugMode)
      logger.info("WorldEditCUI Debug - " + message);
  }

  public void info(String message)
  {
    logger.info(message);
  }

  public void info(String message, Throwable e) {
    logger.log(Level.INFO, message, e);
  }

  public static CUIDebug getInstance() {
    return instance;
  }

  public static void setInstance(CUIBase controller, File modFolder) {
    if (instance == null)
      instance = new CUIDebug(controller, modFolder);
  }
}