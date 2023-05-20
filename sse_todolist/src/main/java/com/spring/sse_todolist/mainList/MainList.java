package com.spring.sse_todolist.mainList;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter @NoArgsConstructor
@Table(name = "mainlist")
public class MainList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mainlist_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String delYn;

    @Column(nullable = false)
    private String checkYn;


    public MainList(String title , String delYn , String checkYn){
        this.title = title;
        this.delYn = delYn;
        this.checkYn = checkYn;
    }

}
