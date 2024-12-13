package com.example.demo.controller;


import com.example.demo.dto.ItemCreateDto;
import com.example.demo.dto.ItemDto;
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
    public void create(@RequestBody ItemCreateDto item) {
        service.create(item);
    }

    @GetMapping(value = "/items")
    public List<ItemDto> getListItems() {
        return service.getListItems();
    }

    @GetMapping(value = "/items/point")
    public List<ItemDto> getListItemsByRadius(@RequestParam double x, @RequestParam double y, @RequestParam double radius) {
        return service.getListItemsByRadius(radius, x, y);
    }

    @DeleteMapping(value = "/item/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
