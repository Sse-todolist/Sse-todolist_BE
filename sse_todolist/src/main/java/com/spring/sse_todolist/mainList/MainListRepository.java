package com.spring.sse_todolist.mainList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainListRepository extends JpaRepository<MainList , Long> {

    List<MainList> findAll();


    // 휴지통으로 이동
    @Modifying
    @Query("UPDATE MainList mainList SET mainList.delYn = 'Y' WHERE mainList.id = :mainListId AND mainList.delYn = 'N' ")
    void insertTrashCan(Long mainListId);

    // 휴지통에서 복구
    @Modifying
    @Query("UPDATE MainList mainList SET mainList.delYn = 'N' WHERE mainList.id = :mainListId AND mainList.delYn = 'Y' ")
    void recycleTrashCan(Long mainListId);

}
