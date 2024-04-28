package com.gliaci.singleton;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicSingletonTest
{
  @Test
  public void differentObjectsReferToSameInstance()
  {
    assertThat(BasicSingleton.getInstance().incrementAndGetCounter()).isNotEqualTo(BasicSingleton.getInstance().incrementAndGetCounter());
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
    assertThat(usageNumbers).hasSize(100000);
    assertThat(usageNumbers).contains(1);
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