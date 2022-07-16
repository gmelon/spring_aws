package com.gmelon.spring.springandaws.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 'final인' 필드에 대해 생성자 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
