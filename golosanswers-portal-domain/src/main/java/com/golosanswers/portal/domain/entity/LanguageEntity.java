package com.golosanswers.portal.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class LanguageEntity {

	public static final String FR = "fr";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private LanguageEntity() {

	}

	public LanguageEntity(String name) {

		this.name = name;
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
}
