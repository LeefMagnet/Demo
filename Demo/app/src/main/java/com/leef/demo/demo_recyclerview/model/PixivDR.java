package com.leef.demo.demo_recyclerview.model;

/**
 * Pixiv 每日排行
 */
public class PixivDR {
    private String author;      //p图作者
    private String img_url;     //每日p图(缩略图)
    private String title;       //p图标题
    private String url;         //每日p图(高清)

    public PixivDR() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PixivDR{" +
                "author='" + author + '\'' +
                ", img_url='" + img_url + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
