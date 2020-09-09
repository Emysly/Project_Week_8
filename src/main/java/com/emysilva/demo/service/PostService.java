package com.emysilva.demo.service;

import com.emysilva.demo.model.Post;


import java.util.List;
import java.util.Optional;


public interface PostService {

    List<Post> listAllPost();

    void savePost(Post post);

    Optional<Post> getPost(long id);

    void deletePost(long id);
//    void addPost(Post post);
//    List<Post> getAllPostByUser(Long userId);
//    Post updatePost(Post post, Long postId);
//    void deletePost(Long postId);
}
