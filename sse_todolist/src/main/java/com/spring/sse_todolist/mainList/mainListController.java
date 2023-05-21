package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController @RequiredArgsConstructor
public class mainListController {

    private final MainListService mainListService;

    @GetMapping("/api/mainList")
    public MainMapListResponseDto getList(){
        return mainListService.getAllList();
    }

    @PostMapping("/api/insMainList")
    public String insertMainList(@RequestBody MainListRequestDto mainListRequestDto) throws InterruptedException {
        mainListService.insMainList(mainListRequestDto);
        return "등록이 완료 되었습니다";
    }

    @PutMapping("/api/setMainList/{mainListId}")
    public String updateMainList(@PathVariable Long mainListId , @RequestBody MainListRequestDto mainListRequestDto) throws InterruptedException {
        mainListService.setMainList(mainListId, mainListRequestDto);
        return "수정이 완료 되었습니다";
    }

}
