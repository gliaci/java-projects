package com.gliaci.singleton;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicSingletonTest
{
  @Test
  public void differentObjectsReferToSameInstance()
  {
    BasicSingleton basicSingleton1 = BasicSingleton.getInstance();
    BasicSingleton basicSingleton2 = BasicSingleton.getInstance();
    BasicSingleton basicSingleton3 = BasicSingleton.getInstance();

    assertEquals(basicSingleton1.getUsageNumber(), 1);
    assertEquals(basicSingleton2.getUsageNumber(), 2);
    assertEquals(basicSingleton3.getUsageNumber(), 3);
  }

  @Test
  public void notThreadSafeOnInitialization()
  {
    List<BasicSingletonInitialization> runnableList = IntStream.range(0, 100)
                                                               .mapToObj(x -> new BasicSingletonInitialization())
                                                               .collect(Collectors.toList());

    runnableList.parallelStream().forEach(BasicSingletonInitialization::run);

    final List<Integer> usageNumbers = runnableList.stream().map(BasicSingletonInitialization::getUsageNumber).collect(Collectors.toList());
    assertEquals(usageNumbers.size(), 100);
    assertTrue(usageNumbers.stream().filter(x -> x.compareTo(1) == 0).count() > 1);
  }

  private class BasicSingletonInitialization implements Runnable
  {
    private int usageNumber;

    public void run()
    {
      usageNumber = BasicSingleton.getInstance().getUsageNumber();
    }

    public int getUsageNumber()
    {
      return usageNumber;
    }
  }
}