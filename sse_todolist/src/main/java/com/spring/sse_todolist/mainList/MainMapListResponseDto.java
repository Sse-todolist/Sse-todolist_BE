package com.spring.sse_todolist.mainList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @NoArgsConstructor @Setter
public class MainMapListResponseDto {


    private List<MainListResponseDto> result;

    public MainMapListResponseDto(List<MainListResponseDto> result) {
        this.result = result;
    }

}
