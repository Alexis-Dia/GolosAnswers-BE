package com.golosanswers.portal.service.post.impl;

import com.golosanswers.portal.domain.entity.PostEntity;
import com.golosanswers.portal.domain.repository.PostRepository;
import com.golosanswers.portal.domain.specification.PostSpecification;
import com.golosanswers.portal.dto.post.PostDto;
import com.golosanswers.portal.filter.PostFilter;
import com.golosanswers.portal.service.mapper.DtoMapper;
import com.golosanswers.portal.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public Page<PostDto> getProductPage(PostFilter filter) {

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<PostEntity> specification = new PostSpecification(filter);

        return postRepository.findAll(specification, pageable).map(DtoMapper::toPostDto);
    }

    @Override
    public PostDto addPost(PostDto device) {

        PostEntity postEntity = new PostEntity();

        postEntity.setAuthor(device.getAuthor());
        postEntity.setUrl(device.getUrl());
        postEntity.setLink(device.getLink());
        postEntity.setTitle(device.getTitle());
        postEntity.setKeywords(device.getKeywords());
        postEntity.setParentPermlink(device.getParentPermlink());
        postEntity.setTag(device.getTag());
        postEntity.setRating(device.getRating());
        postEntity.setComments(device.getComments());

        PostEntity persistance = postRepository.save(postEntity);

        return DtoMapper.toPostDto(persistance);
    }
}
