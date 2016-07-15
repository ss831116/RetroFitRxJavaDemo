package com.example.bernieshi.thirdpartdemoapplication;

/**
 * Created by bernie.shi on 2016/7/13.
 */
public class MyObject {
    public int retCode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token;

    public void setIsMustUpdate(int isMustUpdate) {
        this.isMustUpdate = isMustUpdate;
    }

    public int getIsMustUpdate() {
        return isMustUpdate;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int isMustUpdate;
    public String newVersion;
    public String downloadUrl;
    public String remark;
    public String getDownloadUrl() {
        return downloadUrl;
    }
    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public int getRetCode() {
        return this.retCode;
    }
}
