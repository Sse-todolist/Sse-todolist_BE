package com.spring.sse_todolist.mainList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainListRepository extends JpaRepository<MainList , Long> {

    // 리스트 조건없이 조회
    List<MainList> findAll();


    // 리스트 조회
    @Modifying
    @Query("SELECT mainList.id ,mainList.title , mainList.delYn , mainList.checkYn FROM MainList mainList WHERE mainList.delYn = 'N'")
    List<MainList> findList();

    // 휴지통 조회
    @Modifying
    @Query("SELECT mainList.id ,mainList.title , mainList.delYn , mainList.checkYn FROM MainList mainList WHERE mainList.delYn = 'Y'")
    List<MainList> findTrashCanList();

    // 휴지통으로 이동
    @Modifying
    @Query("UPDATE MainList mainList SET mainList.delYn = 'Y' WHERE mainList.id = :mainListId AND mainList.delYn = 'N' ")
    void insertTrashCan(Long mainListId);

    // 휴지통에서 복구
    @Modifying
    @Query("UPDATE MainList mainList SET mainList.delYn = 'N' WHERE mainList.id = :mainListId AND mainList.delYn = 'Y' ")
    void recycleTrashCan(Long mainListId);

}
