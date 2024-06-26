package top.jiejie.boot.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jiejie.boot.template.entity.Article;

import java.util.Arrays;
import java.util.List;

/**
 * @author JXS
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/freemarker")
    public String freemarkerIndex(Model model) {
        List<Article> articles = Arrays.asList(
                new Article(1, "miujiacheng", "Java")
                , new Article(2, "miu", "Spring")
                , new Article(3, "jiacheng", "Spring Boot")
        );
        model.addAttribute("articles", articles);
        System.out.println(articles);
        //模版名称，实际的目录为：resources/template/freemarker-demo.ftl
        return "freemarker-demo";
    }

    @GetMapping("/thymeleaf")
    public String thymeleafIndex(Model model) {
        List<Article> articles = Arrays.asList(
                new Article(1, "黄政", "Java")
                , new Article(2, "正黄", "Spring")
                , new Article(3, "黄征黄", "Spring Boot")
        );
        model.addAttribute("articles", articles);
        return "thymeleaf-demo";
    }
}