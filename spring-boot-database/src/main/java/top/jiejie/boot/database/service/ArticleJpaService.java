package top.jiejie.boot.database.service;
import top.jiejie.boot.database.entity.Article;

import java.util.List;

public interface ArticleJpaService {

    void saveArticle(Article article);

    void updateArticle(Article article);
    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticle(int id);
}