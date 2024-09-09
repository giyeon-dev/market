package com.example.market.dto;

import com.example.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemListResponseDto {

    private Long id;
    private String username;
    private String title;
    private int price;

    public static ItemListResponseDto fromEntity(Item item) {
        return new ItemListResponseDto(item.getId(), item.getUsername(), item.getTitle(), item.getPrice());
    }
}
