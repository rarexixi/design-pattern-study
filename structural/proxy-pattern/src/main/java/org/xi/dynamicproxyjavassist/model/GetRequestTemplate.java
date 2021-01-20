package org.xi.dynamicproxyjavassist.model;

import java.io.Serializable;
import java.util.List;

public class GetRequestTemplate implements Serializable {

    private String url;
    private List<String> params;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
