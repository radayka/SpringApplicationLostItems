package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import com.example.demo.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService service;
    private final ItemServiceImpl itemServiceImpl;

    @Autowired
    public ItemController(ItemService itemService, ItemServiceImpl itemServiceImpl) {
        this.service = itemService;
        this.itemServiceImpl = itemServiceImpl;
    }

    @PostMapping(value = "/item")
    public ResponseEntity<?> create(@RequestBody Item item) {
        service.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getListItems() {
        final List<Item> items = itemServiceImpl.getListItems();
        return !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        final boolean deleted = itemServiceImpl.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
