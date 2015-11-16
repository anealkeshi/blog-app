package com.anilkc.blog.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@SecondaryTables({ @SecondaryTable(name = "user_profiles", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "id") }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String displayName;
	private Boolean isDeleted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "user_profiles")
	private String profile;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastActiveOn;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "credentialId")
	private Credential credential;

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

}
