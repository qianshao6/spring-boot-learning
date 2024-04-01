package top.jiejie.boot.database.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jiejie.boot.database.entity.Article;


@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void insertArticle() {
        Article article = Article.builder()
                .author("lucy")
                .content("Spring Boot2")
                .title("Spring BOOt2")
                .build();
        articleMapper.insertArticle(article);
    }
}
