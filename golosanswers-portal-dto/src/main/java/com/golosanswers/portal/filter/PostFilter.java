package com.golosanswers.portal.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostFilter implements HasOrders, HasPageable  {

    private final int page;
    private final int size;
    private final List<OrderBy> orders;

    private final String author;
    private final String url;
    private final String tag;
    private final String parentPermlink;
    private final String link;
    private final String title;
    private final String keywords;
    private final String body;
    private final Double ratingFrom;
    private final Double ratingTo;
    private final Double commentsFrom;
    private final Double commentsTo;

    @JsonCreator
    public PostFilter(@JsonProperty("page") int page, @JsonProperty("size") int size, @JsonProperty("orders") List<OrderBy> orders,
                      @JsonProperty("author") String author, @JsonProperty("url") String url, @JsonProperty("tag") String tag,
                      @JsonProperty("parentPermlink") String parentPermlink, @JsonProperty("link") String link,
                      @JsonProperty("title") String title, @JsonProperty("keywords") String keywords, @JsonProperty("body") String body,
                      @JsonProperty("ratingFrom") Double ratingFrom, @JsonProperty("ratingTo") Double ratingTo,
                      @JsonProperty("commentsFrom") Double commentsFrom, @JsonProperty("commentsTo") Double commentsTo) {
        this.page = page;
        this.size = size;
        this.orders = orders;
        this.author = author;
        this.url = url;
        this.tag = tag;
        this.parentPermlink = parentPermlink;
        this.link = link;
        this.title = title;
        this.keywords = keywords;
        this.body = body;
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
        this.commentsFrom = commentsFrom;
        this.commentsTo = commentsTo;
    }

    @Override
    public List<OrderBy> getOrders() {
        return orders;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getPage() {
        return page;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getTag() {
        return tag;
    }

    public String getParentPermlink() {
        return parentPermlink;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getBody() {
        return body;
    }

    public Double getRatingFrom() {
        return ratingFrom;
    }

    public Double getRatingTo() {
        return ratingTo;
    }

    public Double getCommentsFrom() {
        return commentsFrom;
    }

    public Double getCommentsTo() {
        return commentsTo;
    }
}
