package com.emysilva.demo.service;

import com.emysilva.demo.model.Post;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface PostService {

    List<Post> listAllPost();

    void savePost(Post post);

    void updatePost(Post post, long id);

    Optional<Post> getPost(long id);

    void deletePost(long id);

    void likePost(Post post, long id);

    void unlikePost(Post post, long id);
//    void addPost(Post post);
//    List<Post> getAllPostByUser(Long userId);
//    Post updatePost(Post post, Long postId);
//    void deletePost(Long postId);
}
