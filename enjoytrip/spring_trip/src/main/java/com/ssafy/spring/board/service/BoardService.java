package com.ssafy.spring.board.service;

import java.util.List;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.board.dto.CommentDto;

public interface BoardService {
	public List<BoardDto> list();
	public int write(BoardDto dto);
	public BoardDto view(String articleNo);
	public List<CommentDto> getComment(String articleNo);
	public int insertComment(CommentDto dto);
	public int deleteComment(String commentNo);
}
