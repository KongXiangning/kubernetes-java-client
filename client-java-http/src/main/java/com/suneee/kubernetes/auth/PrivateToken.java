package com.suneee.kubernetes.auth;

import com.suneee.kubernetes.http.Pair;
import okhttp3.Credentials;

import java.util.List;
import java.util.Map;

public class PrivateToken implements Authentication{

    private String tokenName;
    private String tokenValue;

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
        if (tokenName == null && tokenValue == null) {
            return;
        }
        headerParams.put(tokenName, tokenValue);
    }
}
