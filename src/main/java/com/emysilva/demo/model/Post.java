package com.emysilva.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postId;

	@NotBlank(message = "Title is mandatory")
	private String title;

	@NotBlank(message = "Message is mandatory")
	private String message;

	private String createdAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY)
	private List<LikeUnlike> likeUnlikes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;


}
