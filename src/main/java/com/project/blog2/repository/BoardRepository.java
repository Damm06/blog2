package com.project.blog2.repository;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import com.project.blog2.dto.board.BoardRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);


    public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto);
}
