package com.project.blog2.service;

import com.project.blog2.config.auth.PrincipalDetails;
import com.project.blog2.domain.Board;
import com.project.blog2.dto.board.BoardRequestDto;
import com.project.blog2.exception.BusinessLogicException;
import com.project.blog2.exception.ExceptionCode;
import com.project.blog2.repository.BoardRepository;
import com.project.blog2.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    //게시글 저장
//    public Long createBoard(BoardRequest boardRequest, User loginUser) {
//        Board board = boardRepository.save(boardRequest.toBoardWithLoginUser(loginUser));
//        return board.getId();
//
//    }

    public Board writeBoard(BoardRequestDto boardRequestDto, PrincipalDetails principalDetails) {
//        User user = userRepository.findById(userId).orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        Board board = boardRequestDto.toEntity();
        board.setUser(principalDetails.getUser());

        return boardRepository.save(board);
    }


//    public Board createBoard(Board board) {
//        Board savedBoard = saveBoard(board);
//        return savedBoard;
//    }
//    @Transactional
//    public Long create(BoardPostDto boardSaveDto, MultipartHttpServletRequest multiRequest) throws Exception {
////        Board result = boardRepository.save(boardSaveDto.toEntity());
//        return boardRepository.save(boardSaveDto.toEntity()).getId();
//    }

    //게시글 목록 페이징 조회
    @Transactional(readOnly = true)
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    //게시글 ID로 조회
    @Transactional(readOnly = true)
    public Board findBoardById(Long id) {
        return findVerifiedBoard(id);
    }

    //게시글 수정
//    @Transactional
//    public Long update(Long id, BoardUpdateDto requestDto) {
//        Board updateBoard = boardRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
//
//        updateBoard.update(requestDto.getTitle(), requestDto.getContent());
//        return id;
//    }

    //트랜잭션 기본 옵션. 부모 트랜잭션이 존재하면 합류하고 아니면 새로 만듦. 중간에 자식/부모에서 rollback 발생하면 모두 rollback함
    @Transactional
    public Board updateBoard(Board board) {
        Board findBoard = findVerifiedBoard(board.getId());

        Optional.ofNullable(board.getTitle())
//                .ifPresent(findBoard::setTitle); //람다식 변경후
        .ifPresent(boardTitle -> findBoard.setTitle(boardTitle));
        Optional.ofNullable(board.getContent())
//                .ifPresent(findBoard::setContent);
        .ifPresent(boardContent -> findBoard.setContent(boardContent));
        return boardRepository.save(findBoard);
    }

    //게시글 하나 삭제
    public void deleteBoard(Long id) {
        Board findBoard = findVerifiedBoard(id);
        boardRepository.delete(findBoard);
    }

//    public int updateBoard(BoardPostDto boardPostDto) {
//        int result = boardRepository.updateBoard(boardPostDto);
//        return boardRepository.updateBoard(boardPostDto);
//    }

//    public Board saveBoard(Board board) {
//        return boardRepository.save(board);
//    }

@Transactional(readOnly = true) //글이 있는지 조회
    private Board findVerifiedBoard(long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        Board findBoard =
                optionalBoard.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
        return findBoard;
    }
}
