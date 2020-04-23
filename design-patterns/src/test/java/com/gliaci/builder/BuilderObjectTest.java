package com.gliaci.builder;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BuilderObjectTest
{
  @Test
  public void withoutOptionalFields()
  {
    BuilderObject builtObject = new BuilderObject.Builder(1L, "test").build();

    assertEquals(builtObject.getMandatoryId(), Long.valueOf(1L));
    assertEquals(builtObject.getMandatoryString(), "test");
    assertNull(builtObject.getOptionalString());
    assertNull(builtObject.getOptionalBigDecimal());
  }

  @Test
  public void withOptionalFields()
  {
    BuilderObject builtObject = new BuilderObject.Builder(1L, "test")
      .withOptionalString("optionalString")
      .withOptionalBigDecimal(BigDecimal.ONE).build();

    assertEquals(builtObject.getMandatoryId(), Long.valueOf(1L));
    assertEquals(builtObject.getMandatoryString(), "test");
    assertEquals(builtObject.getOptionalString(), "optionalString");
    assertEquals(builtObject.getOptionalBigDecimal(), BigDecimal.ONE);
  }
}