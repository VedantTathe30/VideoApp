package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String videoname;

    private String link;

    private String websitelink;

    private String githublink;

//    @ManyToOne
//    @JoinColumn(name = "userid", nullable = false)  // Ensuring it's a foreign key reference
//    private User user;

    // If you need the `userId` separately, add this but prevent duplication
    @Column(name = "userid", insertable = false, updatable = false)
    private Long userId;

    // Constructors
    public Video() {}

    public Video(String videoname,Long userid, String websitelink, String githublink) {
        this.videoname = videoname;
        this.userId = userid;
        this.websitelink = websitelink;
        this.githublink = githublink;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
	public String getWebsitelink() {
        return websitelink;
    }

    public void setWebsitelink(String websitelink) {
        this.websitelink = websitelink;
    }
    
	public String getGithublink() {
        return githublink;
    }

    public void setGithublink(String githublink) {
        this.githublink = githublink;
    }
    
    
    
}
