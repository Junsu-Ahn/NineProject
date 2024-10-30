package com.example.nine.menu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nine.menu.entity.MenuItem;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}