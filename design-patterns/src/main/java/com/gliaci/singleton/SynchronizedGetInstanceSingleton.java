package com.gliaci.singleton;

public class SynchronizedGetInstanceSingleton
{
  private static SynchronizedGetInstanceSingleton instance;
  private int counter;

  private SynchronizedGetInstanceSingleton()
  {
  }

  public static synchronized SynchronizedGetInstanceSingleton getInstance()
  {
    if (instance == null)
    {
      instance = new SynchronizedGetInstanceSingleton();
    }
    return instance;
  }

  public int incrementAndGetCounter()
  {
    counter++;
    return counter;
  }
}
