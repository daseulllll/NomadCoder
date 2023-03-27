package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //DB가 해당 객체를 인식 가능!
@NoArgsConstructor //디폴트 생성자를 추가!
@Getter
public class Article {
	
	@Id	//대표값을 지정! like a 주민등록번호
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //DB가 id를 자동 생성 어노테이션!
	private Long id;

	@Column //DB에서 관리되는 table과 연결되게
	private String title;
	
	@Column
	private String content;

	public Article(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	public void patch(Article article) {
		if(article.title != null) 
			this.title = article.title;
		if(article.content != null)
			this.content = article.content;
	}

//	@Getter와 이하동일
//	public Long getId() {
//		return id;
//	}
	
	
}
