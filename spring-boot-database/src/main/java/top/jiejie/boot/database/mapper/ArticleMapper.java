package top.jiejie.boot.database.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.jiejie.boot.database.entity.Article;


@Mapper
public interface ArticleMapper {
    void insertArticle(Article article);
}
