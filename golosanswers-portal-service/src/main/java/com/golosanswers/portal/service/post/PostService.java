package com.golosanswers.portal.service.post;

import com.golosanswers.portal.dto.post.PostDto;
import com.golosanswers.portal.filter.PostFilter;
import org.springframework.data.domain.Page;

public interface PostService {

    Page<PostDto> getProductPage(PostFilter filter);

    PostDto addPost(PostDto device);
}
