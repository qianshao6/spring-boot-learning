package top.jiejie.boot.database.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.jiejie.boot.database.dao.ArticleJpaDAO;
import top.jiejie.boot.database.entity.Article;
import top.jiejie.boot.database.service.ArticleJpaService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class ArticleJpaServiceImpl implements ArticleJpaService {

    @Resource
    private ArticleJpaDAO articleJpaDAO;

    @Override
    public void saveArticle(Article article) {
        articleJpaDAO.save(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleJpaDAO.save(article);
    }

    @Override
    public Article getArticleById(int id) {
        Optional<Article> articleOptional = articleJpaDAO.findById(id);
        return articleOptional.orElse(null);
    }

    @Override
    public List<Article> findAll() {
        return  articleJpaDAO.findAll();
    }

    @Override
    public void deleteArticle(int id) {
        articleJpaDAO.deleteById(id);
    }
}
