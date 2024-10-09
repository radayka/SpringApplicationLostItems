package com.example.demo.service;


import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    void create(ItemDto item);

    List<Item> getListItems();

    boolean delete(UUID id);

    List<Item> getListItemsByRadius(double radius, double x, double y);
}
