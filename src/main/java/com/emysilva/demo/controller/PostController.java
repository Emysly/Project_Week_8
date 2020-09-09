package com.emysilva.demo.controller;


import com.emysilva.demo.model.Post;
import com.emysilva.demo.model.User;
import com.emysilva.demo.repository.PostRepository;
import com.emysilva.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/add-post")
    public String addPost(Post post, Model model) {
        model.addAttribute("post", post);
        return "addpost";
    }

    @GetMapping("/edit-post")
    public String editPost(Post post, Model model) {
        model.addAttribute("post", post);
        return "editpost";
    }

    @GetMapping("/list-posts")
    public String listPosts(Model model) {
        List<Post> posts = postService.listAllPost();
        System.out.println(posts.toString());
        model.addAttribute("posts", posts);
        return "dashboard";
    }

    @GetMapping("/edit/{id}")
    public String showEditPostPage(@PathVariable(name = "id") long id, Model model) {
        Post post = postService.getPost(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "editpost";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return "redirect:/list-posts";
    }

    @PostMapping("update/{id}")
    public String updatePost(@PathVariable("id") long id, @Valid Post post, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
//            post.postId = id;
            return "editpost";
        }

        postService.savePost(post);
        return "redirect:/list-posts";
    }

    @PostMapping("/add-post")
    public String savePost(@Valid Post post, BindingResult result, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";
        User user = (User) userObj;
        if (result.hasErrors()) {
            return "addpost";
        }
        post.setUser(user);
        postService.savePost(post);
        return "redirect:/list-posts";
    }

}
