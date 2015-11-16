package com.anilkc.blog.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tagName;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "tags")
	private Set<Post> posts;

	public Tag() {
		// TODO Auto-generated constructor stub
	}

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
