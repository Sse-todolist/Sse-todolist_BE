package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class MainListService {

    private final MainListRepository mainListRepository;


    // 조건 없이 전체 조회
    public MainMapListResponseDto getAllList() {
        List<MainList> mainLists = mainListRepository.findAll();
        List<MainListResponseDto> result = mainLists.stream()
                .map(MainListResponseDto::new)
                .collect(Collectors.toList());

        return new MainMapListResponseDto(result);
    }

    // 리스트 조회
    public MainMapListResponseDto getList() {
        List<MainList> mainLists = mainListRepository.findMainListsByDelYn("N");
        List<MainListResponseDto> result = mainLists.stream()
                .map(MainListResponseDto::new)
                .collect(Collectors.toList());
        System.out.println("result = " + result);
        System.out.println(" GetService 여기는옴 ??????? " );
        return new MainMapListResponseDto(result);
    }


    // 휴지통 조회
    public MainMapListResponseDto getTrashCanList() {
        List<MainList> TrashCanLists = mainListRepository.findMainListsByDelYn("Y");
        List<MainListResponseDto> result = TrashCanLists.stream()
                .map(MainListResponseDto::new)
                .collect(Collectors.toList());

        return new MainMapListResponseDto(result);
    }

    // 리스트 내용 등록
    @Transactional
    public void insMainList(MainListRequestDto mainListRequestDto){
        String title = mainListRequestDto.getTitle();
        String delYn = mainListRequestDto.getDelYn();
        String checkYn = mainListRequestDto.getCheckYn();

        System.out.println("title = " + title);
        System.out.println("delYn = " + delYn);
        System.out.println("checkYn = " + checkYn);
        //        // 회원 ID 중복 확인
        //        Optional<User> found = userRepository.findByUsername(username);
        //        if (found.isPresent()) {
        //            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        //        }

        MainList mainList = new MainList(title, delYn, checkYn);
        System.out.println("mainList = " + mainList);
        
        mainListRepository.save(mainList);

    }

    //리스트 내용 수정
    @Transactional
    public void setMainList(Long mainListId , MainListRequestDto mainListRequestDto){
        String title = mainListRequestDto.getTitle();

        MainList mainList = mainListRepository.findById(mainListId).orElseThrow(NoSuchElementException::new);

        mainList.updateMainList(mainListRequestDto.getTitle());
    }

    // 휴지통으로 이동
    @Transactional
    public void setTrashCanMainList(Long mainListId){
        MainList mainList = mainListRepository.findById(mainListId).orElseThrow(NoSuchElementException::new);

        mainListRepository.insertTrashCan(mainListId);
    }

    // 휴지통에서 복구
    @Transactional
    public void setRecycleMainList(Long mainListId){
        MainList mainList = mainListRepository.findById(mainListId).orElseThrow(NoSuchElementException::new);

        mainListRepository.recycleTrashCan(mainListId);
    }

    // 리스트 체크 클릭시 checkYn 변경
    @Transactional
    public void setUpdateCheckYn(Long mainListId){
        MainList mainList = mainListRepository.findById(mainListId).orElseThrow(NoSuchElementException::new);

        // checkYn이 Y일경우
        if(mainList.getCheckYn().equals("Y") ) {
            // N 로 바꿔준다.
            mainListRepository.setCheckN(mainListId);
        // checkYn이 N일경우
        } else if (mainList.getCheckYn().equals("N")){
            // Y 로 바꿔준다.
            mainListRepository.setCheckY(mainListId);
        }
    }

    // delete 삭제
    public void delMainList(Long mainListId){
        MainList mainList = mainListRepository.findById(mainListId).orElseThrow(NoSuchElementException::new);

        mainListRepository.deleteById(mainListId);
    }



}
