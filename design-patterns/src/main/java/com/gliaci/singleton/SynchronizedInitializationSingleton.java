package com.gliaci.singleton;

public class SynchronizedInitializationSingleton
{
  private static SynchronizedInitializationSingleton instance;
  private int usageNumber;

  private SynchronizedInitializationSingleton()
  {
  }

  public static synchronized SynchronizedInitializationSingleton getInstance()
  {
    if (instance == null)
    {
      instance = new SynchronizedInitializationSingleton();
    }
    return instance;
  }

  public int getUsageNumber()
  {
    usageNumber++;
    return usageNumber;
  }
}
