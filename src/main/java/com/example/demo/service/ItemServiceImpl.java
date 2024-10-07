package com.example.demo.service;

import com.example.demo.DTO.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

import java.util.*;

@org.springframework.stereotype.Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

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
        return itemRepository.findAll();
    }

    @Override
    public boolean delete(UUID itemId) {
        try {
            itemRepository.deleteById(itemId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}