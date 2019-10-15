package com.wsa.bedrest.comment;

import com.wsa.bedrest.item.Item;
import com.wsa.bedrest.item.ItemBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentService {

    private CommentRepository repository;

    private static void errLog(Throwable e) {
        log.error("Error while running query caused by: ", e);
    }

    public Comment getComment(long id) {
        Comment comment = null;
        try {
            comment = repository.findById(id).orElseThrow(() -> new RuntimeException("Comment with this id doesn't exist"));
        } catch (Throwable e) {
            errLog(e);
        }
        return comment;
    }

    public List<Comment> getAll(long itemId) {
        List<Comment> comments = null;
        try {
            comments = repository.getAllByItemId(itemId);
        } catch (Throwable e) {
            errLog(e);
        }
        return comments;
    }

    public void updateOrSave(Comment comment) {
        try {
            repository.save(comment);
        } catch (Throwable e) {
            errLog(e);
        }
    }

}

