package com.github.tianjing.wcpt.webthirdapi.bo;


/**
 * @author 田径
 * @Title
 * @Description
 * @date 11:48
 */

public class AppMessageBO  {

    public static int CONTENT_TYPE_TEXT=1;

    private Integer contentType;
    private String content;
    /**
     * 接收者
     */
    private String revicer;
    private String appId;

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer pContentType) {
        contentType = pContentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String pContent) {
        content = pContent;
    }

    public String getRevicer() {
        return revicer;
    }

    public void setRevicer(String pRevicer) {
        revicer = pRevicer;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String pAppId) {
        appId = pAppId;
    }
}
