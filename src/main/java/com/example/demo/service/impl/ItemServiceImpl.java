package com.example.demo.service.impl;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getListItemsByRadius(double radius, double x, double y) {
        GeometryFactory geometryFactory = new GeometryFactory();
        org.locationtech.jts.geom.Point centerPoint = geometryFactory.createPoint(new Coordinate(x, y));
        Geometry searchArea = centerPoint.buffer(radius);
        List<Item> allItem = itemRepository.findAll();
        List<Item> itemsInRadius = new ArrayList<>();
        for (Item item : allItem) {
            Coordinate itemCoordinate = new Coordinate(item.getLocation().getX(), item.getLocation().getY());
            org.locationtech.jts.geom.Point itemPoint = geometryFactory.createPoint(itemCoordinate);

            if (searchArea.contains(itemPoint)) {
                itemsInRadius.add(item);
            }
        }
        return itemsInRadius;
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