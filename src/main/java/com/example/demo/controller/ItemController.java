package com.example.demo.controller;


import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestBody ItemDto item) {
        service.create(item);
    }

    @GetMapping(value = "/items")
    public List<Item> getListItems() {
        return service.getListItems();
    }

    @GetMapping(value = "/items/point")
    public List<Item> getListItemsByRadius(@RequestParam double x, @RequestParam double y, @RequestParam double radius) {
        return service.getListItemsByRadius(radius, x, y);
    }

    @DeleteMapping(value = "/item/{id}")
    public boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
