package com.wsa.bedrest.category;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }

    @PostMapping("/categories")
    @ResponseStatus(CREATED)
    public void addCategory(@RequestBody Category category) {
        categoryService.updateOrSave(category);
    }
}
