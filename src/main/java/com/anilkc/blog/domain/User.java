package com.anilkc.blog.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@SecondaryTables({ @SecondaryTable(name = "user_profiles", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "id") }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String lastName;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(min = 4, max = 50)
	private String displayName;
	private Boolean isDeleted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "user_profiles")
	@NotEmpty
	private String profile;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastActiveOn;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "credentialId")
	@Valid
	private Credential credential;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "subscriptions", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "tagId", referencedColumnName = "id") })
	private Set<Tag> tags = new HashSet<Tag>(0);

	@Transient
	private MultipartFile userImage;

	public User() {

	}

	public User(String firstName, String lastName, String email, String displayName, String profile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.displayName = displayName;
		this.profile = profile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getLastActiveOn() {
		return lastActiveOn;
	}

	public void setLastActiveOn(Date lastActiveOn) {
		this.lastActiveOn = lastActiveOn;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public MultipartFile getUserImage() {
		return userImage;
	}

	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		if (this.credential.isEnabled() == true) {
			return "Active";
		} else {
			return "Not ACtive";
		}
	}

	@Transient
	private String status;

}
