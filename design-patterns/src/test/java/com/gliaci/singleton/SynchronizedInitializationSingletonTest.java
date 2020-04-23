package com.gliaci.singleton;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SynchronizedInitializationSingletonTest
{
  @Test
  public void hasThreadSafeInitialization()
  {
    List<SynchronizedInitializationSingletonInitialization> runnableList = IntStream.range(0, 100)
                                                                                  .mapToObj(x -> new SynchronizedInitializationSingletonInitialization())
                                                                                  .collect(Collectors.toList());

    runnableList.parallelStream().forEach(SynchronizedInitializationSingletonInitialization::run);

    final List<Integer> usageNumbers = runnableList.stream().map(x -> x.getUsageNumber()).collect(Collectors.toList());
    assertEquals(usageNumbers.size(), 100);
    assertEquals(usageNumbers.stream().filter(x -> x.compareTo(1) == 0).count(), 1);
  }

  private class SynchronizedInitializationSingletonInitialization implements Runnable
  {
    private int usageNumber;

    public void run()
    {
      usageNumber = SynchronizedInitializationSingleton.getInstance().getUsageNumber();
    }

    public int getUsageNumber()
    {
      return usageNumber;
    }
  }
}
