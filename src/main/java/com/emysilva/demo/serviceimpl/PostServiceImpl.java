package com.emysilva.demo.serviceimpl;

import com.emysilva.demo.model.LikeUnlike;
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
    public void updatePost(Post post, long id) {
        Post postToUpdate = postRepository.findById(id).get();
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setMessage(post.getMessage());
        postRepository.save(postToUpdate);
    }

    @Override
    public Optional<Post> getPost(long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void likePost(Post post, long id) {
        Post postToLike = postRepository.findById(id).get();
        postToLike.setLikes(post.getLikes() + 1);
        postRepository.save(postToLike);
    }

    @Override
    public void unlikePost(Post post, long id) {
        Post postToUnlike = postRepository.findById(id).get();
        postToUnlike.setUnlikes(post.getUnlikes() + 1);
        postRepository.save(postToUnlike);
    }

}
