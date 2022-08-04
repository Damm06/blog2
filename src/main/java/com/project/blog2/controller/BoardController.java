package com.project.blog2.controller;

import com.project.blog2.domain.User;
import com.project.blog2.dto.board.BoardPostDto;
import com.project.blog2.mapper.BoardMapper;
import com.project.blog2.service.BoardService;
import com.project.blog2.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//@RestController
//@RequestMapping("/board")
//@Validated
public class BoardController {
//
//    private final BoardService boardService;
//    private final BoardMapper mapper;
////    private final UserService userService;
//
//    public BoardController(BoardService boardService,
//                           BoardMapper mapper) {
//        this.boardService = boardService;
//        this.mapper = mapper;
//    }
//
//    //게시글 목록 조회 페이지 매핑
//    @GetMapping("/list")
//    public String getBoardList(@PageableDefault Pageable pageable, Model model) {
//        model.addAttribute("boardList", boardService.findBoardList(pageable));
//        return "/board/list";
//    }
//
//    //글 작성 페이지 매핑
//    @GetMapping("/write")
//    public String writeBoard(Model model, BoardPostDto boardPostDto) {
//        return "/board/write";
//    }
//
//     //글 상세조회 페이지 매핑
//    @GetMapping("/view")
//    public String viewBoard(Model model , BoardPostDto boardPostDto) throws Exception {
//        try {
//            if (boardPostDto.getId() != null) {
//                model.addAttribute("info", boardService.findBoardById(boardPostDto.getId()));
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return "/board/view";
//    }
//
//    //글 작성하고 등록 액션 메서드
//    @PostMapping("/write/action")
//    public String writeBoardAction(Model model, BoardPostDto boardPostDto, MultipartHttpServletRequest multiRequest) throws  Exception {
//        try {
//            if (!boardService.save(boardPostDto, multiRequest)) {
//                throw new Exception("#Exception boardWriteAction!");
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return "redirect:/board/list";
//    }
//
//    @PostMapping("/view/action")
//    public String boardViewAction(Model model, BoardPostDto boardPostDto, MultipartHttpServletRequest multiRequest) throws Exception {
////        try {
////            //boolean result = boardService.updateBoard(boardRequestDto, multiRequest);
////            if(!result) {
////                throw new Exception("#Exception boardViewAction!");
////            }
////        } catch (Exception e) {
////            throw new Exception(e.getMessage());
////        }
//        return "redirect:/board/list";
//    }
//
//    @PostMapping("/view/delete")
//    public String boardViewDelete(Model model, @RequestParam() long id) throws Exception {
//        try {
//            boardService.deleteBoardById(id);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return "redirect:/board/list";
//    }
//
//    @PostMapping("/delete")
//    public String boardDeleteAction(Model model, @RequestParam() Long[] deleteId) throws Exception {
//        try {
//            boardService.deleteAll(deleteId);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return "redirect:/board/list";
//    }
}
