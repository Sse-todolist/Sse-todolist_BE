package com.spring.sse_todolist.mainList;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter @NoArgsConstructor
public class MainMapListResponseDto {


    private List<MainListResponseDto> result;

    public MainMapListResponseDto(List<MainListResponseDto> result) {
        this.result = result;
    }

}
