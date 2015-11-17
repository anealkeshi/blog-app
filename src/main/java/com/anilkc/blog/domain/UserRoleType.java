package com.anilkc.blog.domain;

public enum UserRoleType {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_BLOGGER("ROLE_BLOGGER"), ROLE_READER("ROLE_BLOGGER");

	private String value;

	UserRoleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

}
