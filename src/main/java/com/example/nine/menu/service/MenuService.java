package com.example.nine.menu.service;

import com.example.nine.menu.entity.MenuItem;
import com.example.nine.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository; // @RequiredArgsConstructor에 의해 자동으로 주입됨

    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public Optional<MenuItem> getMenuItem(Long id) {
        return menuRepository.findById(id);
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }

    public MenuItem updateMenuItem(Long id, MenuItem newMenuItem) {
        return menuRepository.findById(id).map(menuItem -> {
            menuItem.setName(newMenuItem.getName());
            menuItem.setDescription(newMenuItem.getDescription());
            menuItem.setPrice(newMenuItem.getPrice());
            return menuRepository.save(menuItem);
        }).orElseGet(() -> menuRepository.save(newMenuItem));
    }
}