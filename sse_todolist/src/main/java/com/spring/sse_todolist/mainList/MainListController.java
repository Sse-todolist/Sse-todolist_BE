package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        System.out.println("여기는옴???????????????????????????????????????????????????????");
        return mainListService.getList();
    }


    // 휴지통 조회
    @GetMapping("/api/trashCanList")
    public MainMapListResponseDto getTrashCanList(){

        return mainListService.getTrashCanList();
    }


    // 리스트 등록
    @PostMapping("/api/insMainList")
    public ResponseEntity<ApiResponseMessage> insertMainList(@RequestBody MainListRequestDto mainListRequestDto) {
        System.out.println("여기는옴???????????????????????????????????????????????????????");
        System.out.println("mainListRequestDto = " + mainListRequestDto);
        mainListService.insMainList(mainListRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "등록이 완료되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

    // 리스트 내용 수정
    @PutMapping("/api/setMainList/{mainListId}")
    public ResponseEntity<ApiResponseMessage> updateMainList(@PathVariable Long mainListId , @RequestBody MainListRequestDto mainListRequestDto) {
        mainListService.setMainList(mainListId, mainListRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "수정이 완료되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

    // 휴지통으로 이동
    @PutMapping("/api/setTrashCan/{mainListId}")
    public ResponseEntity<ApiResponseMessage> setTrashCanMainList(@PathVariable Long mainListId )  {
        mainListService.setTrashCanMainList(mainListId);
        ApiResponseMessage message = new ApiResponseMessage("Success", "휴지통으로 이동되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

    // 휴지통에서 빼주기
    @PutMapping("/api/setRecycle/{mainListId}")
    public ResponseEntity<ApiResponseMessage> setRecycleMainList(@PathVariable Long mainListId ) {
        mainListService.setRecycleMainList(mainListId);
        ApiResponseMessage message = new ApiResponseMessage("Success", "휴지통에서 제거되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

    // 리스트 체크 클릭시 checkYn 변경
    @PutMapping("/api/updateCheckYn/{mainListId}")
    public ResponseEntity<ApiResponseMessage> setCheckYn(@PathVariable Long mainListId ) {
        mainListService.setUpdateCheckYn(mainListId);
        ApiResponseMessage message = new ApiResponseMessage("Success", "체크되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

    // delete 삭제
    @DeleteMapping("/api/delMainList/{mainListId}")
    public ResponseEntity<ApiResponseMessage> delMainList(@PathVariable Long mainListId ) {
        mainListService.delMainList(mainListId);
        ApiResponseMessage message = new ApiResponseMessage("Success", "삭제가 완료되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

}
