package com.example.demo.controller;


import com.example.demo.DTO.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
public class ItemController {
    private final ItemService service;

    @Autowired
    public ItemController(ItemService itemService) {
        this.service = itemService;
    }

    @PostMapping(value = "/item")
    public ResponseEntity<?> create(@RequestBody ItemDto item) {
        service.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getListItems() {
        return new ResponseEntity<>(service.getListItems(), HttpStatus.OK);
    }
    @GetMapping(value = "/items/point")
    public ResponseEntity<?> getListItemsByRadius(Point point,double radius) {
        point = new Point(point.x,point.y);
        return new ResponseEntity<>(service.getListItemsByRadius(radius, point), HttpStatus.OK);
    }
    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        final boolean deleted = service.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
