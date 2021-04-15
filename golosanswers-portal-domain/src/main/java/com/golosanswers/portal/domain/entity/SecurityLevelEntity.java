package com.golosanswers.portal.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "security_level")
public class SecurityLevelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private int level;


	public SecurityLevelEntity() {

	}

	public SecurityLevelEntity(String name, int level) {

		this.name = name;
		this.level = level;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getLevel() {

		return level;
	}

	public void setLevel(int level) {

		this.level = level;
	}
}
