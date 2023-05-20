package com.spring.sse_todolist.mainList;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class MainListRequestDto {
    private Long id;
    private String title;
    private String delYn;
    private String checkYn;
}
