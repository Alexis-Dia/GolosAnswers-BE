package com.golosanswers.portal.dto.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDto {

    private final Long id;
    private final String author;
    private final String url;
    private final String tag;
    private final String parentPermlink;
    private final String link;
    private final String title;
    private final String keywords;
    private final String body;
    private final Double rating;
    private final Double comments;

    @JsonCreator
    public PostDto(@JsonProperty("id") Long id, @JsonProperty("author") String author, @JsonProperty("url") String url,
                   @JsonProperty("tag")String tag, @JsonProperty("parentPermlink") String parentPermlink, @JsonProperty("link") String link,
                   @JsonProperty("title")String title, @JsonProperty("keywords") String keywords, @JsonProperty("body") String body,
                   @JsonProperty("rating")Double rating, @JsonProperty("comments") Double comments) {
        this.id = id;
        this.author = author;
        this.url = url;
        this.tag = tag;
        this.parentPermlink = parentPermlink;
        this.link = link;
        this.title = title;
        this.keywords = keywords;
        this.body = body;
        this.rating = rating;
        this.comments = comments;
    }

    public Long getId() {
        return id;
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

    public Double getRating() {
        return rating;
    }

    public Double getComments() {
        return comments;
    }
}