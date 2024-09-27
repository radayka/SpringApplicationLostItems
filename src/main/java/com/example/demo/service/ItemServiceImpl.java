package com.example.demo.service;

import com.example.demo.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class ItemServiceImpl implements ItemService {
    private static final Map<Integer, Item> ITEM_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger ITEM_ID_HOLDER = new AtomicInteger();


    @Override
    public void create(Item item) {
        final int itemId = ITEM_ID_HOLDER.getAndIncrement();
        item.setId(itemId);
        ITEM_REPOSITORY_MAP.put(itemId, item);
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