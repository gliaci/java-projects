package com.gliaci.singleton;

public class BasicSingleton
{
  private static BasicSingleton instance;
  private int counter;

  private BasicSingleton()
  {
  }

  public static BasicSingleton getInstance()
  {
    if (instance == null)
    {
      instance = new BasicSingleton();
    }
    return instance;
  }

  public int incrementAndGetCounter()
  {
    counter++;
    return counter;
  }
}
