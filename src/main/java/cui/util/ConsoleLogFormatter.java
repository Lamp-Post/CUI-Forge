package cui.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class ConsoleLogFormatter extends Formatter
{
  private SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public String format(LogRecord paramLogRecord) {
    StringBuilder localStringBuilder = new StringBuilder();

    localStringBuilder.append(this.a.format(Long.valueOf(paramLogRecord.getMillis())));
    Level localLevel = paramLogRecord.getLevel();
    if (localLevel == Level.FINEST)
      localStringBuilder.append(" [FINEST] ");
    else if (localLevel == Level.FINER)
      localStringBuilder.append(" [FINER] ");
    else if (localLevel == Level.FINE)
      localStringBuilder.append(" [FINE] ");
    else if (localLevel == Level.INFO)
      localStringBuilder.append(" [INFO] ");
    else if (localLevel == Level.WARNING)
      localStringBuilder.append(" [WARNING] ");
    else if (localLevel == Level.SEVERE)
      localStringBuilder.append(" [SEVERE] ");
    else if (localLevel == Level.SEVERE) {
      localStringBuilder.append(" [").append(localLevel.getLocalizedName()).append("] ");
    }

    localStringBuilder.append(paramLogRecord.getMessage());
    localStringBuilder.append('\n');

    Throwable localThrowable = paramLogRecord.getThrown();
    if (localThrowable != null) {
      StringWriter localStringWriter = new StringWriter();
      localThrowable.printStackTrace(new PrintWriter(localStringWriter));
      localStringBuilder.append(localStringWriter.toString());
    }

    return localStringBuilder.toString();
  }
}