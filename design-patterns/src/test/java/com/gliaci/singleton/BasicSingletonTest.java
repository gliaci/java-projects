package com.gliaci.singleton;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BasicSingletonTest
{
  @Test
  public void differentObjectsReferToSameInstance()
  {
    assertNotEquals(BasicSingleton.getInstance().incrementAndGetCounter(),
      BasicSingleton.getInstance().incrementAndGetCounter());
  }

  @Test
  public void hasNotThreadSafeOnInitialization()
  {
    List<SingletonInitialization> runnableList = IntStream.range(0, 100000)
                                                          .mapToObj(x -> new SingletonInitialization())
                                                          .collect(Collectors.toList());

    runnableList.parallelStream().forEach(SingletonInitialization::run);

    final List<Integer> usageNumbers = runnableList.stream()
                                                   .map(SingletonInitialization::getCounter)
                                                   .collect(Collectors.toList());
    assertEquals(usageNumbers.size(), 100000);
    assertTrue(usageNumbers.stream().filter(x -> x.compareTo(1) == 0).count() > 1);
  }

  private static class SingletonInitialization implements Runnable
  {
    private int counter;

    public void run()
    {
      counter = BasicSingleton.getInstance().incrementAndGetCounter();
    }

    public int getCounter()
    {
      return counter;
    }
  }
}