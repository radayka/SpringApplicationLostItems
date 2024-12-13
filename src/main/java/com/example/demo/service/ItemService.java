package com.example.demo.service;


import com.example.demo.dto.ItemCreateDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    void create(ItemCreateDto item);

    List<ItemDto> getListItems();

    boolean delete(Long id);

    List<ItemDto> getListItemsByRadius(double radius, double x, double y);
}
