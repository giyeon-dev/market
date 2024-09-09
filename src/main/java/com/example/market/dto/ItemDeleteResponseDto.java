package com.example.market.dto;

import lombok.Getter;

@Getter
public class ItemDeleteResponseDto {
    private String msg;

    public ItemDeleteResponseDto(String msg) {
        this.msg = msg;
    }
}
