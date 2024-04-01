package top.jiejie.boot.database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.jiejie.boot.database.entity.Article;

public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {

}