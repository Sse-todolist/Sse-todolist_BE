package com.spring.sse_todolist.mainList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
