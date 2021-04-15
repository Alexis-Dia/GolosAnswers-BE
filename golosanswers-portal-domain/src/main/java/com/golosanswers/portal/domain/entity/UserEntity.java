package com.golosanswers.portal.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "consumer")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private String username;

	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@JoinColumn(name = "security_level_id")
	@ManyToOne
	private SecurityLevelEntity securityLevel;

	@JoinColumn(name = "language_id")
	@ManyToOne
	private LanguageEntity language;

	public UserEntity() {

	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
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

	public SecurityLevelEntity getSecurityLevel() {

		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevelEntity securityLevel) {

		this.securityLevel = securityLevel;
	}

	public LanguageEntity getLanguage() {

		return language;
	}

	public void setLanguage(LanguageEntity language) {

		this.language = language;
	}
}
