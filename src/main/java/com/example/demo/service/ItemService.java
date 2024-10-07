package com.example.demo.service;



import com.example.demo.DTO.ItemDto;
import com.example.demo.model.Item;

import java.util.List;

public interface ItemService {
    void create(ItemDto item);
    List<Item> getListItems();
    boolean delete(int id);
}
