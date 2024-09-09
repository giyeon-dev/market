package com.example.market.dto;

import com.example.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public static ItemResponseDto fromEntity(Item item) {
        return new ItemResponseDto(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice());
    }


}
