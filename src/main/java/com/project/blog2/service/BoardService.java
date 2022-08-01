package com.project.blog2.service;

import com.project.blog2.domain.Board;
import com.project.blog2.dto.board.BoardRequestDto;
import com.project.blog2.dto.board.BoardResponseDto;
import com.project.blog2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardRequestDto boardSaveDto) {
        return boardRepository.save(boardSaveDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public BoardResponseDto findBoardById(Long id) {
        return new BoardResponseDto(boardRepository.findById(id).get());
    }



    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
}
