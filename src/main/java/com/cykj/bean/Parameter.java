package com.cykj.bean;

import java.math.BigDecimal;

//参数类
public class Parameter {
    private BigDecimal parameterId;
    private BigDecimal parameterValue;//类型值
    private String parameterName;//值名称
    private String parameterType;//类型名称

    public Parameter() {
    }

    public BigDecimal getParameterId() {
        return parameterId;
    }

    public void setParameterId(BigDecimal parameterId) {
        this.parameterId = parameterId;
    }

    public BigDecimal getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(BigDecimal parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }
}
