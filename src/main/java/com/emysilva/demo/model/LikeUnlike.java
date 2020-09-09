package com.emysilva.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeUnlike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long likeUnlikeId;
	private LikeUnlikeType likeUnlikeType;

}
