package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
public class ArticleForm {

	private Long id;//id 필드 추가!
	private String title;
	private String content;

	public Article toEntity() {
						//필드추가로 null -> id로 변경
		return new Article(id,title,content);
	}
}
