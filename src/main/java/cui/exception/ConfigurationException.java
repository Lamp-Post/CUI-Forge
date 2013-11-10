package cui.exception;

public class ConfigurationException extends Exception
{
  private static final long serialVersionUID = 38458138168L;

  public ConfigurationException(Throwable thrwbl)
  {
    super(thrwbl);
  }

  public ConfigurationException(String string, Throwable thrwbl) {
    super(string, thrwbl);
  }

  public ConfigurationException(String string) {
    super(string);
  }

  public ConfigurationException()
  {
  }
}