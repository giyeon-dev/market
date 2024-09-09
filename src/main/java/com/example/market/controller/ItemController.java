package com.example.market.controller;

import com.example.market.dto.ItemDeleteResponseDto;
import com.example.market.dto.ItemListResponseDto;
import com.example.market.dto.ItemRequestDto;
import com.example.market.dto.ItemResponseDto;
import com.example.market.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    @GetMapping
    public List<ItemListResponseDto> getItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/{id}")
    public ItemResponseDto updateItem(@PathVariable("id") Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ItemDeleteResponseDto deleteItem(@PathVariable("id") Long id) {
        return itemService.deleteItem(id);
    }
}
