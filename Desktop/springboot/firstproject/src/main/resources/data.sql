insert into article(id,title,content) values(1,'가가가가','1111');
insert into article(id,title,content) values(2,'나나나나','2222');
insert into article(id,title,content) values(3,'다다다다','3333');

--article 더미 데이터

insert into article(id,title,content) values(4,'당신의 인생 영화는?','댓글 go');
insert into article(id,title,content) values(5,'당신의 소울 푸드는?','댓글 go go');
insert into article(id,title,content) values(6,'당신의 취미는?','댓글 go go go');

--comment 더미 데이터
----4번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values(1,4,'Park','굳 윌 헌팅');
insert into comment(id,article_id,nickname,body) values(2,4,'Kim','아이 엠 샘');
insert into comment(id,article_id,nickname,body) values(3,4,'Lee','쇼생크의 탈출');

----5번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values(4,5,'Park','치킨');
insert into comment(id,article_id,nickname,body) values(5,5,'Kim','피자');
insert into comment(id,article_id,nickname,body) values(6,5,'Lee','샤브샤브');

----6번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values(7,6,'Park','조깅');
insert into comment(id,article_id,nickname,body) values(8,6,'Kim','영화');
insert into comment(id,article_id,nickname,body) values(9,6,'Lee','독서');

