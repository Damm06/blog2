package com.project.blog2.mapper;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import com.project.blog2.dto.board.BoardPostDto;
import com.project.blog2.dto.board.BoardResponseDto;
import com.project.blog2.dto.board.BoardUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
//    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
//    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
//    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
//    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);

/*    Member memberPostToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.response memberToMemberResponse(Member member);
    List<MemberDto.response> membersToMemberResponses(List<Member> members);*/

default Board boardPostDtoToBoard(BoardPostDto boardPostDto) {
    User user = new User();
    Board board = new Board();
    board.setAuthor(boardPostDto.getUserName());
    //수정 필요 (List 추가 예정)
    return board;
}

Board boardUpdateDtoToBoard(BoardUpdateDto boardUpdateDto);
default BoardResponseDto boardToBoardResponseDto(Board board) {
    BoardResponseDto boardResponseDto = new BoardResponseDto();
    boardResponseDto.setId(board.getId());
    boardResponseDto.setTitle(board.getTitle());
    boardResponseDto.setContent(board.getContent());
    boardResponseDto.setAuthor(board.getAuthor());
    boardResponseDto.setCount(board.getCount());
    boardResponseDto.setRegisterTime(board.getCreatedAt());

    return boardResponseDto;
}

List<BoardResponseDto> boardsToBoardResponseDto(List<Board> boards);
//BoardResponseDto boardToBoardResponse(Board board);

}
