package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequiredArgsConstructor
public class mainListController {

    private final MainListService mainListService;

    @GetMapping("/api/mainList")
    public MainMapListResponseDto getList(){
        return mainListService.getAllList();
    }


}
