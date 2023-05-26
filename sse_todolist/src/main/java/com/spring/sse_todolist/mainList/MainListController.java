package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController @RequiredArgsConstructor
public class MainListController {

    private final MainListService mainListService;

    // 조건 없이 전체 조회
    @GetMapping("/api/mainListAll")
    public MainMapListResponseDto getListAll(){
        return mainListService.getAllList();
    }

    // 메인 리스트 조회
    @GetMapping("/api/mainList")
    public MainMapListResponseDto getList(){
        return mainListService.getList();
    }


    // 휴지통 조회
    @GetMapping("/api/trashCanList")
    public MainMapListResponseDto getTrashCanList(){
        return mainListService.getTrashCanList();
    }


    // 리스트 등록
    @PostMapping("/api/insMainList")
    public String insertMainList(@RequestBody MainListRequestDto mainListRequestDto) throws InterruptedException {
        mainListService.insMainList(mainListRequestDto);
        return "등록이 완료 되었습니다";
    }

    // 리스트 내용 수정
    @PutMapping("/api/setMainList/{mainListId}")
    public String updateMainList(@PathVariable Long mainListId , @RequestBody MainListRequestDto mainListRequestDto) throws InterruptedException {
        mainListService.setMainList(mainListId, mainListRequestDto);
        return "수정이 완료 되었습니다";
    }

    // 휴지통으로 이동
    @PutMapping("/api/setTrashCan/{mainListId}")
    public String setTrashCanMainList(@PathVariable Long mainListId ) throws InterruptedException {
        mainListService.setTrashCanMainList(mainListId);
        return "휴지통으로 이동되었습니다.";
    }

    // 휴지통에서 빼주기
    @PutMapping("/api/setRecycle/{mainListId}")
    public String setRecycleMainList(@PathVariable Long mainListId ) throws InterruptedException {
        mainListService.setRecycleMainList(mainListId);
        return "휴지통으로 이동되었습니다.";
    }

    // 리스트 체크 클릭시 checkYn 변경
    @PutMapping("/api/updateCheckYn/{mainListId}")
    public String setCheckYn(@PathVariable Long mainListId ) throws InterruptedException {
        mainListService.setUpdateCheckYn(mainListId);
        return "수정이 완료 되었습니다.";
    }

    // delete 삭제
    @DeleteMapping("/api/delMainList/{mainListId}")
    public String delMainList(@PathVariable Long mainListId ) throws InterruptedException {
        mainListService.delMainList(mainListId);
        return "삭제에 성공하였습니다.";
    }

}
