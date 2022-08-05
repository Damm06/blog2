package com.project.blog2.controller;

import com.project.blog2.domain.Board;
import com.project.blog2.dto.MultiResponseDto;
import com.project.blog2.dto.SingleResponseDto;
import com.project.blog2.dto.board.BoardPostDto;
import com.project.blog2.dto.board.BoardUpdateDto;
import com.project.blog2.mapper.BoardMapper;
import com.project.blog2.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/board")
@Validated
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper mapper;
//    private final UserService userService;

    public BoardController(BoardService boardService,
                           BoardMapper mapper) {
        this.boardService = boardService;
        this.mapper = mapper;
    }

    //글 작성
    @PostMapping
    public ResponseEntity postBoard(@Valid @RequestBody BoardPostDto boardPostDto) {
        Board board = boardService.createBoard(mapper.boardPostDtoToBoard(boardPostDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.CREATED);
    }

    //글 수정
    @PutMapping("/{id}")
    public ResponseEntity putBoard(@PathVariable long id,
                                   @RequestBody BoardUpdateDto boardUpdateDto) {

        Board board = boardService.updateBoard(mapper.boardUpdateDtoToBoard(boardUpdateDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.OK);
    }

    //특정 글 id로 조회
    @GetMapping("/{id}")
    public ResponseEntity getBoard(@PathVariable long id) {
        Board board = boardService.findBoardById(id);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.OK);
    }

    //글 목록 조회
    @GetMapping
    public ResponseEntity getBoards(@RequestParam int page,
                                    @RequestParam int size) {
        Page<Board> pagedBoards = boardService.findBoardList(PageRequest.of(page -1, size, Sort.by("id").descending()));
        List<Board> boards = pagedBoards.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.boardsToBoardResponseDto(boards),
                        pagedBoards),
                HttpStatus.OK);
    }

    //글 삭제
    @DeleteMapping("/{id}")
   public ResponseEntity deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
