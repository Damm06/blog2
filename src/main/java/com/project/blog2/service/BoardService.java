package com.project.blog2.service;

import com.project.blog2.domain.Board;
import com.project.blog2.dto.board.BoardRequestDto;
import com.project.blog2.dto.board.BoardResponseDto;
import com.project.blog2.dto.board.BoardUpdateRequestDto;
import com.project.blog2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //게시글 저장
    @Transactional
    public Long create(BoardRequestDto boardSaveDto, MultipartHttpServletRequest multiRequest) throws Exception {
//        Board result = boardRepository.save(boardSaveDto.toEntity());
        return boardRepository.save(boardSaveDto.toEntity()).getId();
    }

    //게시글 목록 페이징 조회
    @Transactional(readOnly = true)
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    //게시글 ID로 조회
    public BoardResponseDto findBoardById(Long id) throws Exception {
        return new BoardResponseDto(boardRepository.findById(id).get());
    }

    //게시글 수정
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        board.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    //게시글 삭제
    public void deleteBoardById(Long id) throws Exception {
        boardRepository.deleteById(id);
    }


    public int updateBoard(BoardRequestDto boardRequestDto, MultipartHttpServletRequest multiRequest) throws Exception {
        int result = boardRepository.updateBoard(boardRequestDto);
        return boardRepository.updateBoard(boardRequestDto);
    }

    public boolean save(BoardRequestDto boardRequestDto, MultipartHttpServletRequest multiRequest) {
        return true;
    }

    public void deleteAll(Long[] deleteIdList) throws Exception {
        //boardRepository.deleteBoard(deleteIdList);
    }
}
