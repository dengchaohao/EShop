package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class ContentCategory {
    private BigDecimal contentId;

    private String name;

    public BigDecimal getContentId() {
        return contentId;
    }

    public void setContentId(BigDecimal contentId) {
        this.contentId = contentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}