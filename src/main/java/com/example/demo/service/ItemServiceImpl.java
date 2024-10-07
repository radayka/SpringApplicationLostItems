package com.example.demo.service;

import com.example.demo.DTO.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ItemServiceImpl implements ItemService {
    private static final Map<Integer, Item> ITEM_REPOSITORY_MAP = new HashMap<>();

    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public void create(ItemDto item) {
        Item newItem = new Item();
        newItem.setContacts(item.getContacts());
        newItem.setName(item.getName());
        newItem.setDate(item.getDate());
        newItem.setLocation(item.getLocation());

        itemRepository.save(newItem);
    }

    @Override
    public List<Item> getListItems() {
        return new ArrayList<>(ITEM_REPOSITORY_MAP.values());
    }

    @Override
    public boolean delete(int itemId) {
        return ITEM_REPOSITORY_MAP.remove(itemId) != null;
    }
}