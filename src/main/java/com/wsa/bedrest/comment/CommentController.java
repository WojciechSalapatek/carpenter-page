package com.wsa.bedrest.comment;

import com.wsa.bedrest.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentController {

    private CommentService commentService;
    private ItemService itemService;

    @GetMapping("/items/{itemId}/comments")
    public List<Comment> getComments(@PathVariable long itemId) {
        return commentService.getAll(itemId);
    }

    @PostMapping("/items/{itemId}/comments")
    @ResponseStatus(CREATED)
    public void addComment(@PathVariable long itemId, @RequestBody Comment comment) {
        comment.setItem(itemService.get(itemId));
        commentService.updateOrSave(comment);
    }

}
