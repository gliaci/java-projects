package com.gliaci.singleton;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SynchronizedGetInstanceSingletonTest
{
  @Test
  public void hasThreadSafeInitialization()
  {
    List<SingletonInitialization> runnableList = IntStream.range(0, 1000)
                                                          .mapToObj(x -> new SingletonInitialization())
                                                          .collect(Collectors.toList());

    runnableList.parallelStream().forEach(SingletonInitialization::run);

    final List<Integer> usageNumbers = runnableList.stream()
                                                   .map(SingletonInitialization::getUsageNumber)
                                                   .collect(Collectors.toList());
    assertEquals(usageNumbers.size(), 1000);
    assertEquals(usageNumbers.stream().filter(x -> x.compareTo(1) == 0).count(), 1);
  }

  private static class SingletonInitialization implements Runnable
  {
    private int usageNumber;

    public void run()
    {
      usageNumber = SynchronizedGetInstanceSingleton.getInstance().incrementAndGetCounter();
    }

    public int getUsageNumber()
    {
      return usageNumber;
    }
  }
}
