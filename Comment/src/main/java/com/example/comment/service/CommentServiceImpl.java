package com.example.comment.service;

import com.example.comment.dao.CommentDao;
import com.example.comment.model.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.comment.service
 * fileName : CommentServiceImpl
 * author : ds
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         ds          최초 생성
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Override
    public boolean registerBoard(CommentDto params) {
        int queryResult = 0;

        if(params.getIdx() == null){
//            새 글 쓰기(insert 문 실행)
            queryResult = commentDao.insertBoard(params);
        } else {
//            상세 목록에서 글 수정(update 문 실행)
            queryResult = commentDao.updateBoard(params);
        }

        return (queryResult == 1 ? true : false);
    }

    @Override
    public CommentDto getBoardDetail(Long idx) {
//        글 번호(idx)에 해당하는 상세 목록 보기(Select 문 실행 : 1건)
        return commentDao.selectBoardDetail(idx);
    }

    @Override
    public List<CommentDto> getBoardAllList() {
        List<CommentDto> commentList = Collections.emptyList();

//        select(전체 게시물)문 실행
        commentList = commentDao.selectBoardAllList();

        return commentList;
    }

    @Override
    public List<CommentDto> getBoardList(CommentDto params) {
        List<CommentDto> boardDto = Collections.emptyList();

//        DB params에 해당하는 데이터가 있는지 먼저 확인
        int boardTotalCount = commentDao.selectBoardTotalCount(params);

        if(boardTotalCount > 0) {
//            페이징 처리 서비스 호출
            boardDto = commentDao.selectBoardList(params);
        }

        return boardDto;
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

//        게시물이 있는지 확인 하는 절차(Select : 1건)
        CommentDto board = commentDao.selectBoardDetail(idx);

//        Delete_Yn : "N" 일때 + board가 null이 아닐때만 삭제 진행
//        게시물이 있으면 board 는 null이 아님
        if(board != null && "N".equals(board.getDeleteYn())){
//            게시물 삭제 서비스 (킹치만 내부적으로 ㄹㅇ 삭제는 안 함 deleteYn을 "Y"로 바꿈)
            queryResult = commentDao.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }
}
