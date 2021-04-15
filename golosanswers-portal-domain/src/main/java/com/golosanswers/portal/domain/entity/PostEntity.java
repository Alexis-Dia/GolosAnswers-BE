package com.golosanswers.portal.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(name = "author")
    private String author;

    @Column(name = "url")
    private String url;

    @Column(name = "tag")
    private String tag;

    @Column(name = "parent_permlink")
    private String parentPermlink;

    @Column(name = "link")
    private String link;

    @Column(name = "title")
    private String title;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "body")
    private String body;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "comments")
    private Double comments;

    public PostEntity() {
    }

    public PostEntity(String author, String url, String tag, String parentPermlink, String link, String title,
                      String keywords, String body, Double rating, Double comments) {
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
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParentPermlink() {
        return parentPermlink;
    }

    public void setParentPermlink(String parent_permlink) {
        this.parentPermlink = parent_permlink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getPost_id() {
        return post_id;
    }

    public String getParent_permlink() {
        return parentPermlink;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getComments() {
        return comments;
    }

    public void setComments(Double comments) {
        this.comments = comments;
    }
}