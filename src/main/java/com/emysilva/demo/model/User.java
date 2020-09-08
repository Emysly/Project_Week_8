package com.emysilva.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "Firstname is mandatory")
	private String firstname;
	@NotBlank(message = "Lastname is mandatory")
	private String lastname;
	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 3, max = 30)
	private String password;
	@NotBlank(message = "Confirm password is mandatory")
	@Column(name = "conf_password")
	@Size(min = 3, max = 30)
	private String confPassword;

	private String contact;

//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String createdAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;


}
