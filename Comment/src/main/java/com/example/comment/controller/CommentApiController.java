package com.example.comment.controller;

import com.example.comment.model.CommentDto;
import com.example.comment.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.comment.controller
 * fileName : CommentApiController
 * author : ds
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         ds          최초 생성
 */
@RestController
@RequestMapping("/api")
public class CommentApiController {
    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/comment/write/{idx}")
    public CommentDto openBoardWrite(@PathVariable("idx") Long idx){
//        상세목록 보기 서비스를 호출(Select : 1건)
        CommentDto detail = commentService.getBoardDetail(idx);

        return detail;
    }

    @PostMapping("/comment/register")
    public List<CommentDto> registerBoard(@RequestBody CommentDto commentDto){

        try{
//            insert 문 실행
            boolean isRegistered = commentService.registerBoard(commentDto);
        } catch (DataAccessException e) {
//            DB 관련된 에러는 여기로 들어옴
//            TODO => DB 처리 과정에 문제가 발생했다는 메세지를 출력
        } catch (Exception e) {
//            그 외 에러는 다 여기로 들어옴
//            TODO => 시스템에 문제가 발생했다는 메세지를 출력
        }
//        insert 완료 후 데이터 확인을 위한 전체 조회(Select)
        return commentService.getBoardAllList();
    }

    @PutMapping(value = "/comment/delete/{idx}")
    public List<CommentDto> deleteBoard(@PathVariable("idx") Long idx){

//        삭제 서비스 호출
        boolean isDeleted = commentService.deleteBoard(idx);

//        삭제 되었는지 전체 조회 함
        return commentService.getBoardAllList();
    }

    //    페이징 처리를 위한 게시물 검색 메뉴
    @GetMapping("/comment/list/cur-page-no/{currentPageNo}/recods-per-page/{recordsPerPage}")
    public List<CommentDto> openBoardList(CommentDto params){

        return commentService.getBoardList(params);
    }

    //    페이징 처리를 위한 게시물 검색 메뉴2
    @GetMapping("/comment/list/cpage/{currentPageNo}/rpage/{recordsPerPage}/sword/{searchKeyword}/stype/{searchType}")
    public List<CommentDto> openBoardList2(CommentDto params){

        return commentService.getBoardList(params);
    }
}
