package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class SpecificationOption {
    private BigDecimal specOptionId;

    private BigDecimal specId;

    private String sepcName;

    private String prosmallPictureUrl;

    private String probigPictureUrl;

    public BigDecimal getSpecOptionId() {
        return specOptionId;
    }

    public void setSpecOptionId(BigDecimal specOptionId) {
        this.specOptionId = specOptionId;
    }

    public BigDecimal getSpecId() {
        return specId;
    }

    public void setSpecId(BigDecimal specId) {
        this.specId = specId;
    }

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName == null ? null : sepcName.trim();
    }

    public String getProsmallPictureUrl() {
        return prosmallPictureUrl;
    }

    public void setProsmallPictureUrl(String prosmallPictureUrl) {
        this.prosmallPictureUrl = prosmallPictureUrl == null ? null : prosmallPictureUrl.trim();
    }

    public String getProbigPictureUrl() {
        return probigPictureUrl;
    }

    public void setProbigPictureUrl(String probigPictureUrl) {
        this.probigPictureUrl = probigPictureUrl == null ? null : probigPictureUrl.trim();
    }
}