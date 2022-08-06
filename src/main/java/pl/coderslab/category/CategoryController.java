package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    @GetMapping("/list")
    public String findAllCategories(Model model) {
        List<Category> all = categoryDao.findAll();
        model.addAttribute("categories", all);
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryDao.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long categoryId) {
        Category byId = categoryDao.findById(categoryId);
        categoryDao.remove(byId);
        return "redirect:/category/list";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("id") Long categoryId,
                           Model model) {
        Category byId = categoryDao.findById(categoryId);
        model.addAttribute("category", byId);
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category) {
        categoryDao.update(category);
        return "redirect:/category/list";
    }
}
