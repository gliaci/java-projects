package com.gliaci.singleton;

public class SynchronizedInitializationSingleton
{
  private static SynchronizedInitializationSingleton instance;
  private int counter;

  private SynchronizedInitializationSingleton()
  {
  }

  public static SynchronizedInitializationSingleton getInstance()
  {
    if (instance == null)
    {
      synchronized (SynchronizedInitializationSingleton.class)
      {
        if (instance == null)
        {
          instance = new SynchronizedInitializationSingleton();
        }
      }

    }
    return instance;
  }

  public int incrementAndGetCounter()
  {
    counter++;
    return counter;
  }
}
