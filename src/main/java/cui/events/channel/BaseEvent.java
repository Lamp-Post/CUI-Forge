package cui.events.channel;

import cui.CUIBase;

public abstract class BaseEvent
{
  protected CUIBase controller;
  private String[] args;

  public BaseEvent(CUIBase controller, String[] args)
  {
    this.controller = controller;
    this.args = args;
  }

  public abstract void run();

  public abstract EventType getEventType();

  public String getEventName()
  {
    String name = getEventType().name().toLowerCase();
    name = name.substring(0, 1).toUpperCase() + name.substring(1);
    return name;
  }

  public boolean isValid()
  {
    int max = getEventType().getMaxParameters();
    int min = getEventType().getMinParameters();

    if (max == min) {
      if (this.args.length != max) {
        return false;
      }
    }
    else if ((this.args.length > max) || (this.args.length < min)) {
      return false;
    }

    return true;
  }

  public final void doRun()
  {
    if ((this.controller == null) || (this.args == null)) {
      throw new RuntimeException("Controller and parameters must both be set.");
    }

    if (!isValid()) {
      String message = "Invalid number of parameters. " + getEventName() + " event requires ";
      if (getEventType().getMaxParameters() == getEventType().getMinParameters())
        message = message + getEventType().getMaxParameters() + " parameters. ";
      else {
        message = message + "between " + getEventType().getMinParameters() + " and " + getEventType().getMaxParameters() + " parameters. ";
      }

      message = message + "Received " + this.args.length + " parameters instead. ";
      for (String arg : this.args) {
        message = message + arg + " ";
      }

      throw new RuntimeException(message);
    }
    this.run();
  }

  public int getInt(int index)
  {
    return (int)Float.parseFloat(this.args[index]);
  }

  public double getDouble(int index) {
    return Double.parseDouble(this.args[index]);
  }

  public String getString(int index) {
    return this.args[index];
  }
}