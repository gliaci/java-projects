package com.gliaci.builder;

import java.math.BigDecimal;

public class BuilderObject
{
  private Long mandatoryId;
  private String mandatoryString;

  private String optionalString;
  private BigDecimal optionalBigDecimal;

  private BuilderObject(Long mandatoryId, String mandatoryString)
  {
    this.mandatoryId = mandatoryId;
    this.mandatoryString = mandatoryString;
  }

  public Long getMandatoryId()
  {
    return mandatoryId;
  }

  public String getMandatoryString()
  {
    return mandatoryString;
  }

  public String getOptionalString()
  {
    return optionalString;
  }

  public void setOptionalString(String optionalString)
  {
    this.optionalString = optionalString;
  }

  public BigDecimal getOptionalBigDecimal()
  {
    return optionalBigDecimal;
  }

  public void setOptionalBigDecimal(BigDecimal optionalBigDecimal)
  {
    this.optionalBigDecimal = optionalBigDecimal;
  }

  public static class Builder
  {
    private Long mandatoryId;
    private String mandatoryString;

    private String optionalString;
    private BigDecimal optionalBigDecimal;

    public Builder(Long mandatoryId, String mandatoryString)
    {
      this.mandatoryId = mandatoryId;
      this.mandatoryString = mandatoryString;
    }

    public Builder withOptionalString(String optionalString)
    {
      this.optionalString = optionalString;
      return this;
    }

    public Builder withOptionalBigDecimal(BigDecimal optionalBigDecimal)
    {
      this.optionalBigDecimal = optionalBigDecimal;
      return this;
    }

    public BuilderObject build()
    {
      BuilderObject builderObject = new BuilderObject(mandatoryId, mandatoryString);
      builderObject.setOptionalString(optionalString);
      builderObject.setOptionalBigDecimal(optionalBigDecimal);
      return builderObject;
    }
  }
}
