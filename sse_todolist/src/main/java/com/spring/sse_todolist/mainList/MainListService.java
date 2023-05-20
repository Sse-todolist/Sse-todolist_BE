package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class MainListService {

    private final MainListRepository mainListRepository;

    public MainMapListResponseDto getAllList() {
        List<MainList> mainLists = mainListRepository.findAll();
        List<MainListResponseDto> result = mainLists.stream()
                .map(MainListResponseDto::new)
                .collect(Collectors.toList());

        return new MainMapListResponseDto(result);
    }

    @Transactional
    public void insMainList(MainListRequestDto mainListRequestDto){
        String title = mainListRequestDto.getTitle();
        String delYn = mainListRequestDto.getDelYn();
        String checkYn = mainListRequestDto.getCheckYn();

        //        // 회원 ID 중복 확인
        //        Optional<User> found = userRepository.findByUsername(username);
        //        if (found.isPresent()) {
        //            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        //        }

        MainList mainList = new MainList(title, delYn, checkYn);
        mainListRepository.save(mainList);


    }


}
