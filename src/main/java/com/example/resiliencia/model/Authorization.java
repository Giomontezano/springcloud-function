package com.example.resiliencia.model;

import java.util.UUID;

public class Authorization {

    private UUID clearingId;

    private boolean indicator;

    public Authorization(UUID clearingId, boolean indicator) {
        this.clearingId = clearingId;
        this.indicator = indicator;
    }

    public UUID getClearingId() {
        return clearingId;
    }

    public void setClearingId(UUID clearingId) {
        this.clearingId = clearingId;
    }

    public boolean isIndicator() {
        return indicator;
    }

    public void setIndicator(boolean indicator) {
        this.indicator = indicator;
    }
}
