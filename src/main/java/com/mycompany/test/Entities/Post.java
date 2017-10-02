package com.mycompany.test.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Post {

	@Id
	@Column(name="Post_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postId; //Auto generated. Does not need setter.
	
	@Column(name="Title", length=30, nullable=true)
	private String title;
	
	@Lob
	@NotEmpty(message="Message cannot be empty.")
	@NotBlank(message="Message cannot be blank.")
	@Column(name="MESSAGE", length=2000, nullable=false)
	private String message;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Create_date", nullable=false)
	private Date created; //Auto generated. Does not need setter.

	public long getPostId() {
		return postId;
	}

//	public void setPostId(long postId) {
//		this.postId = postId;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

//	public void setCreated(Date created) {
//		this.created = created;
//	}
	
	
}
