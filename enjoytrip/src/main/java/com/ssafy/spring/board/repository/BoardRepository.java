package com.ssafy.spring.board.repository;

import java.util.List;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.board.dto.CommentDto;

public interface BoardRepository {
	public List<BoardDto> list();
	public int write(BoardDto dto);
	public BoardDto view(String articleNo);
	public List<CommentDto> getComment(String articleNo);
	public int delete(int articleNo);
	public int insertComment(CommentDto dto);
	public int deleteComment(String commentNo);
	public int modify(BoardDto dto);
}
