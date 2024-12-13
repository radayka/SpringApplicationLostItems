package com.example.demo.repository;

import com.example.demo.entity.Item;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, Long> {
    void deleteById(@NonNull Long id);
}
