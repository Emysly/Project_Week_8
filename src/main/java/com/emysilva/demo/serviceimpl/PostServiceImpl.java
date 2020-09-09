package com.emysilva.demo.serviceimpl;

import com.emysilva.demo.model.Post;
import com.emysilva.demo.repository.PostRepository;
import com.emysilva.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;



    @Override
    public List<Post> listAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        post.setCreatedAt(formatDateTime);
        postRepository.save(post);
    }

    @Override
    public Optional<Post> getPost(long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

//    @Override
//    public void addPost(Post post) {
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formatDateTime = now.format(format);
//
//        post.setCreatedAt(formatDateTime);
//
//        postRepository.save(post);
//    }
//
////    @Override
////    public Optional<Post> getPost(Long id) {
////        return postRepository.findById(id);
////    }
//
//
//    @Override
//    public List<Post> getAllPostByUser(Long userId) {
//        return postRepository.findAllById(Collections.singleton(userId));
//    }
//
//    @Override
//    public Post updatePost(Post post, Long postId) {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formatDateTime = now.format(format);
//        Post updatedPost = postRepository.findById(postId).get();
//        updatedPost.setTitle(post.getTitle());
//        updatedPost.setMessage(post.getMessage());
//        updatedPost.setCreatedAt(formatDateTime);
//
//        return updatedPost;
//    }
//
//    @Override
//    public void deletePost(Long postId) {
//        Post postToDelete = postRepository.findById(postId)
//                .orElseThrow(() -> new SpringFacebookException("No post with id: " + postId));
//        postRepository.delete(postToDelete);
//    }

}
