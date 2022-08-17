package com.codegym.model;

import java.util.List;

public class MailBox {
    private String languages;
    private String pageSize;
    private boolean spamFillter;
    private String signature;

    public MailBox(String languages, String pageSize, boolean spamFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFillter = spamFillter;
        this.signature = signature;
    }

    public MailBox() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFillter() {
        return spamFillter;
    }

    public void setSpamFillter(boolean spamFillter) {
        this.spamFillter = spamFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
