package com.example.comment.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName : com.example.comment.model
 * fileName : CommentDto
 * author : ds
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         ds          최초 생성
 */
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentDto extends CommonDto{
    private Long idx;
    private Long boardIdx;
    private String content;
    private String writer;
}
