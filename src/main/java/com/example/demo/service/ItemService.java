package com.example.demo.service;

import com.example.demo.model.Item;

import java.util.List;

public interface ItemService {
    void create(Item item);
    List<Item> getListItems();
    boolean delete(int id);
}
