package com.example.comment.service;

import com.example.comment.model.CommentDto;

import java.util.List;

/**
 * packageName : com.example.comment.service
 * fileName : CommentService
 * author : ds
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         ds          최초 생성
 */
public interface CommentService {
    //    게시판에 insert 하는 서비스
    boolean registerBoard(CommentDto params);

    //    상세 목록을 확인하는 서비스(Select)
    CommentDto getBoardDetail(Long idx);

    //    게시판의 글 목록을 가져오는 서비스(Select : 전체 글 목록)
    public List<CommentDto> getBoardAllList();

    //    페이징 처리를 위한 서비스
    public List<CommentDto> getBoardList(CommentDto params);

    //    게시판 글을 삭제하는 서비스(Update) : Delete_Yn = 'Y'로 수정
    public boolean deleteBoard(Long idx);
}
