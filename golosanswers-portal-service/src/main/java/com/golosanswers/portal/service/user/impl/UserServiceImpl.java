package com.golosanswers.portal.service.user.impl;

import com.golosanswers.portal.domain.entity.UserEntity;
import com.golosanswers.portal.domain.repository.UserRepository;
import com.golosanswers.portal.dto.user.UserDto;
import com.golosanswers.portal.service.mapper.DtoMapper;
import com.golosanswers.portal.service.user.UserService;
import com.golosanswers.portal.service.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {

		this.repository = repository;
	}

	@Override
	public UserDto getUser(String username) {

		UserEntity entity = repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

		return DtoMapper.toUserDto(entity);
	}
}
