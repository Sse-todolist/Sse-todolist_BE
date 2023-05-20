package com.spring.sse_todolist.mainList;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class MainListResponseDto {

    private Long id;
    private String title;
    private String delYn;
    private String checkYn;


    public MainListResponseDto(MainList mainLists){
        this.id = mainLists.getId();
        this.title = mainLists.getTitle();
        this.delYn = mainLists.getDelYn();
        this.checkYn = mainLists.getCheckYn();

    }


}
