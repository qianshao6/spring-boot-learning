package top.jiejie.boot.database.dao;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.jiejie.boot.database.entity.Article;

import java.util.List;


@Repository //数据持久层注入注解
public class ArticleJDBCDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增文章
     * @param article
     */
    public int save(Article article){
        String sql = " INSERT INTO t_article (author,title,content) VALUES (?,?,?) ";
        return jdbcTemplate.update(sql,article.getAuthor(),article.getTitle(),article.getContent());
    }

    /**
     * 更新文章
     */
    public int updateById(Article article){
        String sql = "UPDATE t_article SET author = ? ,title = ? ,content = ? where id = ?";
        return jdbcTemplate.update(sql
                ,article.getAuthor()
                ,article.getTitle()
                ,article.getContent()
                ,article.getId());
    }

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    public Article findById(Integer id){
        String sql = "SELECT * FROM t_article where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }

    /**
     * 查询所有文章
     * @return
     */
    public List<Article> findAll(){
        String sql = "SELECT * FROM t_article ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Article.class));
    }

    /**
     * 根据id删除文章
     */
    public int deleteById(Integer id){
        return jdbcTemplate.update("DELETE FROM t_article where id = ?",id);
    }
}

