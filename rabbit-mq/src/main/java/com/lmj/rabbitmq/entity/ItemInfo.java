package com.lmj.rabbitmq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ItemInfo implements Serializable {

    private Long itemId;

    private Long channelId;

    private Integer storeId;

    private Byte sourceType;

    private Long channelCategoryId;

    private Long sellerItemId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Long createAcctId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modTime;

    private Long modAcctId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public Long getChannelCategoryId() {
        return channelCategoryId;
    }

    public void setChannelCategoryId(Long channelCategoryId) {
        this.channelCategoryId = channelCategoryId;
    }

    public Long getSellerItemId() {
        return sellerItemId;
    }

    public void setSellerItemId(Long sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateAcctId() {
        return createAcctId;
    }

    public void setCreateAcctId(Long createAcctId) {
        this.createAcctId = createAcctId;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public Long getModAcctId() {
        return modAcctId;
    }

    public void setModAcctId(Long modAcctId) {
        this.modAcctId = modAcctId;
    }
}
