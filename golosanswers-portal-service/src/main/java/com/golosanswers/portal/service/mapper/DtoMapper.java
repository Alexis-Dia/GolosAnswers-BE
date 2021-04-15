package com.golosanswers.portal.service.mapper;

import com.golosanswers.portal.domain.entity.LanguageEntity;
import com.golosanswers.portal.domain.entity.PostEntity;
import com.golosanswers.portal.domain.entity.ProductEntity;
import com.golosanswers.portal.domain.entity.UserEntity;
import com.golosanswers.portal.dto.alarm.ProductDto;
import com.golosanswers.portal.dto.post.PostDto;
import com.golosanswers.portal.dto.user.Role;
import com.golosanswers.portal.dto.user.UserDto;
import com.golosanswers.portal.exceptions.NonInstanceException;

import java.util.Objects;
import java.util.Optional;

public final class DtoMapper {

	private DtoMapper() {

		throw new NonInstanceException(DtoMapper.class);
	}

	public static ProductDto toProductDto(ProductEntity entity) {

		if (Objects.isNull(entity)) {
			return null;
		}

		return new ProductDto(entity.getId(), entity.getBrand(), entity.getModel(), entity.getDescription(), entity.getDateEntree(),
				entity.getSelectedOptions(), entity.getProductType(), entity.getPrice(), entity.getRating(), entity.getStockStatus());
	}

	public static PostDto toPostDto(PostEntity entity) {

		if (Objects.isNull(entity)) {
			return null;
		}

		return new PostDto(entity.getId(), entity.getAuthor(), entity.getUrl(), entity.getTag(), entity.getParentPermlink(),
				entity.getLink(), entity.getTitle(), entity.getKeywords(), entity.getBody(), entity.getRating(), entity.getComments());
	}

	public static UserDto toUserDto(UserEntity entity) {

		String text = entity.getSecurityLevel().getName();
		Role role = Role.byText(text);
		String language = Optional.ofNullable(entity.getLanguage()).map(LanguageEntity::getName).orElse(LanguageEntity.FR);

		return new UserDto(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getFirstName(), entity.getLastName(), role, language);
	}

}
