package com.anilkc.blog.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "posts")
@SecondaryTables({ @SecondaryTable(name = "post_contents", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "postId", referencedColumnName = "id") }) })
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(length = 500)
	private String title;

	@NotEmpty
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "post_contents")
	private String content;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "posts_tags", joinColumns = {
			@JoinColumn(name = "postId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "tagId", referencedColumnName = "id") })
	private Set<Tag> tags;

	@Enumerated(EnumType.STRING)
	private PostStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId")
	private User author;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;

	public Post() {
		tags = new HashSet<Tag>();
		comments = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Post(String title, String content, User author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		tags = new HashSet<Tag>();
		comments = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public PostStatus getStatus() {
		return status;
	}

	public void setStatus(PostStatus status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void addComment(Comment comment){
		this.comments.add(comment);
	}

	public void removeComment(Comment comment){
		this.comments.remove(comment);
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", tags=" + tags + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", author=" + author + "]";
	}
	
	

}
