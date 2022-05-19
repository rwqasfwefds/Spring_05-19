package com.example.comment.dao;

import com.example.comment.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.comment.dao
 * fileName : CommentDao
 * author : ds
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         ds          최초 생성
 */
@Mapper
public interface CommentDao {
    //    insert sql문을 위한 메소드
    int insertBoard(CommentDto params);

    //    게시판 목록 조회하는 메소드 (select sql문)
    List<CommentDto> selectBoardAllList();

    //    게시판 페이징 처리를 위한 메소드
    List<CommentDto> selectBoardList(CommentDto params);

    //    게시판 상세 목록 조히하는 메소드 (매개변수가 게시판 번호인 select sql문)
    CommentDto selectBoardDetail(Long idx);

    //    게시물의 총 건수를 가져오는 메소드 (select : 1건)
    int selectBoardTotalCount(CommentDto params);

    //    게시판 글 수정 메소드
    int updateBoard(CommentDto params);

    //    게시판 글 삭제 메소드
    int deleteBoard(Long idx);
}
