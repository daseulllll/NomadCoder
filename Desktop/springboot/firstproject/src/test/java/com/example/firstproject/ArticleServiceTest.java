package com.example.firstproject;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;

import jakarta.transaction.Transactional;

@SpringBootTest //해당 클래스는 스프링부트와 연동되서 테스팅된다.
class ArticleServiceTest {
	
	@Autowired ArticleService articleService;

	@Test
	void testIndex() {
		//예상
		Article a = new Article(1L,"가가가가","1111");
		Article b = new Article(2L,"나나나나","2222");
		Article c = new Article(3L,"다다다다","3333");
		List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
		
		//실제
		List<Article> articles = articleService.index();
		
		//비교
		assertEquals(expected.toString(), articles.toString());
	}

	@Test
	void Show_성공____존재하는_id_입력() {
		//예상
		Long id = 1L;
		Article expected = new Article(id,"가가가가","1111");
		
		//실제
		Article article = articleService.show(id);
		
		//비교
		assertEquals(expected.toString(), article.toString());
	}

	@Test
	void Show_실패____존재하지_않는_id_입력() {
		//예상
		Long id = -1L;
		Article expected = null;
		
		//실제
		Article article = articleService.show(id);
		
		//비교, null과 비교할 때는 toString() x
		assertEquals(expected, article);
	
	}

	@Test
	@Transactional //데이터 생성,변경,삭제는 rollback할 수 있게 transactional!
	void Create_성공____title과_content만_있는_dto_입력() {
		//예상
		String title = "라라라라";
		String content = "4444";
		ArticleForm dto = new ArticleForm(null,title,content);
		Article expected = new Article(5L,title,content);
		
		//실제
		Article article = articleService.create(dto);
		
		//비교
		assertEquals(expected.toString(), article.toString());
		
	}

	@Test
	@Transactional
	void Create_실패____id가_포함된_dto_입력() {
		//예상
		String title = "라라라라";
		String content = "4444";
		ArticleForm dto = new ArticleForm(null,title,content);
		Article expected = null;
		
		//실제
		Article article = articleService.create(dto);
		
		//비교
		assertEquals(expected, article);
	}
	
	@Test
	@Transactional
	void Update_성공____존재하는_id_title만_있는_dto_입력() {
		//예상
		Long id = 2L;
		String title = "나나나나";
		String content = "2222";
		ArticleForm dto = new ArticleForm(id,title,content);
		Article expected = new Article(id,title,"343434");
		
		//실제
		Article article = articleService.update(id,dto);
		
		//비교
		assertEquals(expected.toString(), article.toString());
		
	}
	
	@Test
	@Transactional
	void Update_실패____존재하지_않는_id가_포함된_dto_입력() {
		//예상
		Long id = -3L;
		ArticleForm dto = new ArticleForm(id,null,null);
		Article expected = null;
		
		//실제
		Article article = articleService.update(id,dto);
		
		//비교
		assertEquals(expected, article);
	}
	
	
	@Test
	@Transactional
	void Delete_성공____존재하는_id_입력() {
		//예상
		Long id = 1L;
		Article expected = new Article(id,"가가가가","1111");
		
		//실제
		Article article = articleService.delete(id);
		
		//비교
		assertEquals(expected.toString(), article.toString());
	}
	@Test
	@Transactional
	void Delete_실패____존재하지_않는_id_입력() {
		//예상
		Long id = -1L;
		Article expected = null;
		
		//실제
		Article article = articleService.delete(id);
		
		//비교
		assertEquals(expected, article);
	}
	

}
