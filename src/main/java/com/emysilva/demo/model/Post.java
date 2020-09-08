package com.emysilva.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;

	private String title;

	private String message;

	private String email;

	private String username;

	private String createdAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY)
	private List<LikeUnlike> likeUnlikes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;


}
