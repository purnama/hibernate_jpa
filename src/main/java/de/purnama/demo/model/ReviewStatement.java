package de.purnama.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Entity
public class ReviewStatement {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(columnDefinition = "bigint default 0")
    private Long version;

    @Column(nullable = false)
    private String content;

    @Column
    private String media;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false, name = "revlike")
    private Long like = 0l;

    @Column(nullable = false)
    private Long dislike = 0l;

    @OneToOne
    @JsonIgnore
    private Review review;

    @ManyToOne
    @JsonIgnore
    private UserData user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getDislike() {
        return dislike;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
