package com.project.blog2.mapper;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import com.project.blog2.dto.board.BoardRequestDto;
import com.project.blog2.dto.board.BoardResponseDto;
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

//Board boardRequestDtoToBoard(BoardRequestDto boardRequestDto);
List<BoardResponseDto> boardToBoardResponseDtos(List<Board> boards);

default Board boardRequestDtoToBoard(BoardRequestDto boardRequestDto) {
    Board board = new Board();
    User user = new User();
    board.getUser().getId();

   return board;
}
}
