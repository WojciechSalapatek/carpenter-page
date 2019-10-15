package com.wsa.bedrest.category;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private CategoryRepository repository;

    private static void errLog(Throwable e) {
        log.error("Error while running query caused by: ", e);
    }

    public Category getCategory(long id) {
        Category category = null;
        try {
            category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category with this id doesn't exist"));
        } catch (Throwable e) {
            errLog(e);
        }
        return category;
    }

    public List<Category> getAll() {
        List<Category> categories = null;
        try {
            categories = repository.findAll();
        } catch (Throwable e) {
            errLog(e);
        }
        return categories;
    }

    public void updateOrSave(Category category) {
        try {
            repository.save(category);
        } catch (Throwable e) {
            errLog(e);
        }
    }
}
