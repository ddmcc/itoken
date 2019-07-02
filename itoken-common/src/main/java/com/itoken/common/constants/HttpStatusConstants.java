package com.itoken.common.constants;


public enum HttpStatusConstants {

    BAD_GATEWAY(502, "上游服务器无响应");

    int status;
    String content;

    HttpStatusConstants(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
