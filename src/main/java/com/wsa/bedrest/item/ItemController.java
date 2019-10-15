package com.wsa.bedrest.item;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class ItemController {

    private ItemService itemService;

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable long id) {
        return itemService.get(id);
    }

    @GetMapping("/items")
    public List<Item> getItems(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return itemService.getAll();
    }

    @PostMapping("/items")
    @ResponseStatus(CREATED)
    public void addItem(@RequestBody Item item) {
        itemService.updateOrSave(item);
    }

    @PutMapping("/items/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateItem(@RequestBody Item item, @PathVariable long id) {
        itemService.updateOrSave(item);
    }

    @GetMapping("/categories/{id}/items")
    public List<Item> getFromCategory(@PathVariable long id) {
        return itemService.getFromCategory(id);
    }

}
