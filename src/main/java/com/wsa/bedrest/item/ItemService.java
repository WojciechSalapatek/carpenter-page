package com.wsa.bedrest.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemService {

    private ItemRepository repository;

    private static void errLog(Throwable e){
        log.error("Error while running query caused by: ", e);
    }

    public Item get(long id){
        Item item = null;
        try {
            item = repository.findById(id).orElseThrow(() -> new RuntimeException("Could not find item with such id: " + id));
        } catch (Throwable e){
            errLog(e);
        }
        return item;
    }

    public List<Item> getAll(){
        List<Item> items = null;
        try {
            items = repository.findAll();
        } catch (Throwable e){
            errLog(e);
        }
        return items;
    }

    public List<Item> getFromCategory(long id){
        List<Item> items = null;
        try {
            items = repository.findByCategoryId(id);
        } catch (Throwable e){
            errLog(e);
        }
        return items;
    }

    public void updateOrSave(Item item){
        try {
            repository.save(item);
        } catch (Throwable e){
            errLog(e);
        }
    }

    public void delete(long id){
        try {
            repository.deleteById(id);
        } catch (Throwable e){
            errLog(e);
        }
    }



}
