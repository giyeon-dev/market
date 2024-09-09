package com.example.market.service;

import com.example.market.dto.ItemDeleteResponseDto;
import com.example.market.dto.ItemListResponseDto;
import com.example.market.dto.ItemRequestDto;
import com.example.market.dto.ItemResponseDto;
import com.example.market.entity.Item;
import com.example.market.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = itemRequestDto.toEntity();
        Item savedItem = itemRepository.save(item);
        return ItemResponseDto.fromEntity(savedItem);

    }

    public List<ItemListResponseDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(ItemListResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        item.update(itemRequestDto.getUsername(), itemRequestDto.getTitle(), itemRequestDto.getContent(), itemRequestDto.getPrice());

        return ItemResponseDto.fromEntity(item);
    }

    @Transactional
    public ItemDeleteResponseDto deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        itemRepository.delete(item);

        return new ItemDeleteResponseDto("성공적으로 삭제되었습니다.");
    }
}
