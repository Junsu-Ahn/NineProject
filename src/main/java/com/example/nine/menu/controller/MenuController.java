package com.example.nine.menu.controller;

import com.example.nine.menu.entity.MenuItem;
import com.example.nine.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    // 모든 사용자가 접근 가능
    @GetMapping
    public String showMenuPage(Model model) {
        List<MenuItem> menuItems = menuService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "menu/menu";
    }

    @GetMapping("/{id}")
    public String getMenuItem(@PathVariable Long id, Model model) {
        menuService.getMenuItem(id).ifPresent(menuItem -> model.addAttribute("menuItem", menuItem));
        return "menu-item-detail";
    }

    // 관리자만 접근 가능
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        return "menu-item-form";
    }

    // 관리자만 접근 가능
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String saveMenuItem(@ModelAttribute MenuItem menuItem) {
        menuService.saveMenuItem(menuItem);
        return "redirect:/menu";
    }

    // 관리자만 접근 가능
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        menuService.getMenuItem(id).ifPresent(menuItem -> model.addAttribute("menuItem", menuItem));
        return "menu-item-form";
    }

    // 관리자만 접근 가능
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String updateMenuItem(@PathVariable Long id, @ModelAttribute MenuItem menuItem) {
        menuService.updateMenuItem(id, menuItem);
        return "redirect:/menu";
    }

    // 관리자만 접근 가능
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return "redirect:/menu";
    }
}