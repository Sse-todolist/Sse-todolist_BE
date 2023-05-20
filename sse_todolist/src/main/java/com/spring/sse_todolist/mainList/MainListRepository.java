package com.spring.sse_todolist.mainList;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainListRepository extends JpaRepository<MainList , Long> {

    List<MainList> findAll();

}
