package pl.coderslab.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.article.Article;
import pl.coderslab.article.ArticleDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    private final ArticleDao articleDao;

    @RequestMapping("/")
    public String home(Model model) {
        List<Article> fiveTheNewestArticles = articleDao.findFiveTheNewestArticles();
        model.addAttribute("articleList", fiveTheNewestArticles);
        return "article/list";
    }
}
