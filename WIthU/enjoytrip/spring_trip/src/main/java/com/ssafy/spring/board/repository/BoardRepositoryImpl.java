package com.ssafy.spring.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.board.dto.CommentDto;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
	
	SqlSession session;
	
	public BoardRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}

	String ns = "com.ssafy.spring.board.repository.BoardRepository.";

	@Override
	public List<BoardDto> list() {		
		return session.selectList(ns + "list");
	}

	@Override
	public int write(BoardDto dto) {
		System.out.println(dto.getUserId());
		return session.insert(ns + "write", dto);
	}

	@Override
	public BoardDto view(String articleNo) {		
		return session.selectOne(ns+"view", articleNo);
	}

	@Override
	public List<CommentDto> getComment(String articleNo) {
		return session.selectList(ns + "getComment", articleNo);
	}

	@Override
	public int insertComment(CommentDto dto) {
		System.out.println(dto.getUserId());
		System.out.println(dto.getArticleNo());
		return session.insert(ns + "insertComment", dto);
	}

	@Override
	public int deleteComment(String articleNo) {
		return session.delete(ns + "deleteComment", articleNo);
	}

}
