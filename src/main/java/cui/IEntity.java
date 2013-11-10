package cui;

public abstract interface IEntity
{
  public abstract double getX();

  public abstract double getY();

  public abstract double getZ();

  public abstract double getXGuess(double paramDouble);

  public abstract double getYGuess(double paramDouble);

  public abstract double getZGuess(double paramDouble);

  public abstract void teleport(double paramDouble1, double paramDouble2, double paramDouble3);

  public abstract void teleport(IEntity paramIEntity);
}