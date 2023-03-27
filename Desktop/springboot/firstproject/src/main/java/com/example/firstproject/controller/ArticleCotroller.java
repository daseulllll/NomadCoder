package com.example.firstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleCotroller {

	@Autowired //스프링부트가 미리 생성해놓은 객체를 가져다가 자동연결!
	private ArticleRepository articleRepository;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("articles/new")
	public String newArticleForm() {
		return "articles/new";
	}

	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
//		System.out.println(form.toString()); ==>성능에도 좋지않음, 실제 서버에서는 사용하지 말 것!, 로깅대체
		log.info(form.toString());

		//1.DTO를 변환! Entity
		Article article = form.toEntity();
//		System.out.println(article.toString());
		log.info(article.toString());
		 
		//2.Repository에게 Entity를 DB안에 저장하게 함
		Article saved = articleRepository.save(article);
//		System.out.println(saved.toString());
		log.info(saved.toString());
		
		return "redirect:/articles/"+saved.getId();
	}
	
	@GetMapping("/articles/{id}") //@PathVariable = path로부터 입력이 된다.
	public String show(@PathVariable Long id, Model model) {
		log.info("id = "+id);
		
		//1: id로 데이터를 가져옴
		Article articleEntity = articleRepository.findById(id).orElse(null);
		List<CommentDto> commentDtos = commentService.comments(id);
		
		//2: 가져온 데이터를 모델에 등록!
		model.addAttribute("article",articleEntity);
		model.addAttribute("commentDtos",commentDtos);
		
		//3: 보여줄 페이지를 설정!
		return "articles/show";
	}
	
	
	@GetMapping("/articles")
	public String index(Model model) {
		
		//1. 모든 article을 가져온다
		List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
	
		//2. 가져온 article 묶음을 뷰로 전달
		model.addAttribute("articleList",articleEntityList);
		
		//3. 뷰페이지를 설정
		
		return "articles/index"; //articles/index.mustache
	}
	
	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		//수정할 데이터를 가져오기!
		Article articleEntity = articleRepository.findById(id).orElse(null);
		
		//모델에 데이터를 등록
		model.addAttribute("article",articleEntity);
		
		//뷰페이지 설정
		return "articles/edit";
	}
	
	@PostMapping("/articles/update")
	public String update(ArticleForm form) {
		
		//1.DTO >> Entity로 변환
		Article articleEntity = form.toEntity();
		log.info(form.toString());
		
		//2.Entity >> DB로 저장
		
		//2-1: DB레서 기존 데이터를 가져온다
		
		Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
		
		//2-2:기존 데이터에 값을 갱신한다
		if(target != null) {
			articleRepository.save(articleEntity);
		}
		//localhost:8080/h2-console로 확인(돌리고 있는 주소 붙이기)
		
		//3.수정 결과 페이지로 리다이렉트 한다!
		
		return "redirect:/articles/"+articleEntity.getId();
	}
	
	@GetMapping("/articles/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes rttr){
		
		//1.삭제대상을 가져온다
		Article target = articleRepository.findById(id).orElse(null);
		log.info(target.toString());
		
		//2.대상을 삭제
		if(target != null) {
			articleRepository.delete(target);
				//휘발성, 일회용, 휘발성 데이터
			rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
		}
		
		//3.결과데이터를 리다이렉트한다
		return "redirect:/articles";
	}
}
 