package top.jiejie.boot.database.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.jiejie.boot.database.entity.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleJpaServiceTest {
    @Resource
    private  ArticleJpaService articleJpaService;
    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("hhj")
                .title("SPRING")
                .content("sp")
                .build();
        articleJpaService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder()
                .id(1)
                .author("hhj")
                .title("SPRING")
                .content("sp")
                .build();
        articleJpaService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleJpaService.getArticleById(1);
        System.out.println(article);
    }

    @Test
    void findAll() {
        List<Article> all = articleJpaService.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void deleteArticleById() {
        articleJpaService.deleteArticle(1);
    }
}