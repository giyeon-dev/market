package com.example.market.dto;

import com.example.market.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    private String title;
    private String content;
    private int price;
    private String username;

    public Item toEntity() {
        return Item.builder()
                .title(title)
                .content(content)
                .price(price)
                .username(username)
                .build();
    }

}
