package com.anilkc.blog.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comments")
@SecondaryTables({ @SecondaryTable(name = "comment_contents", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "commentId", referencedColumnName = "id") }) })
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "comment_contents")
	private String content;

	@Enumerated(EnumType.STRING)
	private CommentStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId")
	private User author;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String content, User author) {
		super();
		this.content = content;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentStatus getStatus() {
		return status;
	}

	public void setStatus(CommentStatus status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
