package com.example.firstproject.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.controller.ArticleCotroller;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@RestController //RestApi용 컨트롤러! 데이터를 반환
@Slf4j
public class ArticleApiController {
	
//	20. 서비스계층과 transaction
	@Autowired //DI, 생성 객체를 가져와 연결!
	private ArticleService articleService;

	//GET
	@GetMapping("/api/articles")
	public List<Article> index(){
		return articleService.index();
	}
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable Long id){
		return articleService.show(id);
	}
	
	//POST
	@PostMapping("/api/articles")
	public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
		Article created = articleService.create(dto);
		return (created != null) ? 
				ResponseEntity.status(HttpStatus.OK).body(created):
					ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//PATCH
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable Long id,
						@RequestBody ArticleForm dto){
		Article updated = articleService.update(id,dto);
		return (updated != null) ? 
				ResponseEntity.status(HttpStatus.OK).body(updated) :
					ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//DELETE
	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable Long id){
		Article deleted = articleService.delete(id);
		return (deleted != null) ? 
				ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
					ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//transaction => fail => rollback!
	@PostMapping("/api/transaction-test")
	public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
		List<Article> createdList = articleService.createArticles(dtos);
		return (createdList != null) ? 
				ResponseEntity.status(HttpStatus.OK).body(createdList) : 
					ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	
//	19.HTTP & RestController
//	@Autowired //DI
//	private ArticleRepository articleRepository;
//	//GET
//	@GetMapping("/api/articles")
//	public List<Article> index(){
//		return articleRepository.findAll();
//	}
//	@GetMapping("/api/articles/{id}")
//	public Article index(@PathVariable Long id){
//		return articleRepository.findById(id).orElse(null);
//	}
//	
//	//POST
//	@PostMapping("/api/articles")
//	public Article create(@RequestBody ArticleForm dto){
//		Article article = dto.toEntity();
//		return articleRepository.save(article);
//	}
//	//PATCH
//	@PatchMapping("/api/articles/{id}")
//	public ResponseEntity<Article> update(@PathVariable Long id,
//						@RequestBody ArticleForm dto){
//		//1.수정용 Entity 생성
//		Article article = dto.toEntity();
//		log.info("id:{},article:{}",id,article.toString());
//		
//		//2.대상 Entity 조회
//		Article target = articleRepository.findById(id).orElse(null);
//		
//		//3.잘못된 요청 처리(대상이 없거나, id가 다른 경우)
//		if(target == null || id != article.getId()) {
//			
//			//400, 잘못된 요청 응답!
//			log.info("잘못된 요청! id:{}, article:{}",id,article.toString());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//		
//		//4.업데이트 및 정상 응답(200)
//		target.patch(article);
//		Article updated = articleRepository.save(target);
//												//정상데이터 ==> body에 실어보냄
//		return ResponseEntity.status(HttpStatus.OK).body(updated);
//	}
//	
//	//DELETE
//	@DeleteMapping("/api/articles/{id}")
//	public ResponseEntity<Article> delete(@PathVariable Long id){
//		//1.대상 찾기
//		Article target = articleRepository.findById(id).orElse(null);
//		
//		//2.잘못된 요청 처리 (대상 없는 경우)
//		if(target == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//		
//		//대상 삭제
//		articleRepository.delete(target);
//		
//		//데이터 반환
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//	}
}
