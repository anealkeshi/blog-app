package com.anilkc.blog.domain;

public enum UserRoleType {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_BLOGGER("ROLE_BLOGGER"), ROLE_READER("ROLE_READER");

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

	public UserRoleType getValue(UserRoleType value) {
		for (UserRoleType e : UserRoleType.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}

}
