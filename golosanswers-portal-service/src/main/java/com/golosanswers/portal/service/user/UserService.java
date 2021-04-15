package com.golosanswers.portal.service.user;

import com.golosanswers.portal.dto.user.UserDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

	UserDto getUser(String username);
}
