package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class Specification {
    private BigDecimal specId;

    private String name;

    public BigDecimal getSpecId() {
        return specId;
    }

    public void setSpecId(BigDecimal specId) {
        this.specId = specId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}