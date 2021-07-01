package com.lmw.dubbo.write.framework.register;

/**
 * 自定义URL类
 *
 * @author liumingwei
 * @date 2021/6/13
 */
public class URL {
    private String hostName;
    private Integer post;

    public URL(String hostName, Integer post) {
        this.hostName = hostName;
        this.post = post;
    }


    public String getHostName() {
        return hostName;
    }

    public Integer getPost() {
        return post;
    }
}
