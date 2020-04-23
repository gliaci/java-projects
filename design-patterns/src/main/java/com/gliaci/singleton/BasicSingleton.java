package com.gliaci.singleton;

public class BasicSingleton
{
  private static BasicSingleton instance;
  private int usageNumber;

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

  public int getUsageNumber()
  {
    usageNumber++;
    return usageNumber;
  }
}
