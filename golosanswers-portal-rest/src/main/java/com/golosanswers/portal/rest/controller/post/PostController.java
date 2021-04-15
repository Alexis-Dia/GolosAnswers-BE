package com.golosanswers.portal.rest.controller.post;

import com.golosanswers.portal.RestNavigation;
import com.golosanswers.portal.dto.post.PostDto;
import com.golosanswers.portal.filter.PostFilter;
import com.golosanswers.portal.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestNavigation.POST)
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {

        this.service = service;
    }

    @PostMapping(RestNavigation.LOAD)
    public Page<PostDto> getAlarms(@RequestBody PostFilter filter) {

        return service.getProductPage(filter);
    }

    @PostMapping(RestNavigation.NEW)
    public PostDto addDevice(@RequestBody PostDto device) {

        return service.addPost(device);
    }
}
