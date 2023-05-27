package com.spring.sse_todolist.mainList;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor @ToString
public class MainListRequestDto {
    private Long id;
    private String title;
    private String delYn;
    private String checkYn;
}
