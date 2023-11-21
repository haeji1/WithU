package com.ssafy.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.board.dto.CommentDto;
import com.ssafy.spring.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardRepository repo;
	
	@Autowired	
	public BoardServiceImpl(BoardRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<BoardDto> list() {
		return repo.list();
	}

	@Override
	public int write(BoardDto dto) {
		return repo.write(dto);
	}

	@Override
	public BoardDto view(String articleNo) {
		return repo.view(articleNo);
	}

	@Override
	public List<CommentDto> getComment(String articleNo) {
		return repo.getComment(articleNo);
	}

	@Override
	public int insertComment(CommentDto dto) {
		return repo.insertComment(dto);
	}

	@Override
	public int deleteComment(String commentNo) {
		return repo.deleteComment(commentNo);
	}

	@Override
	public int delete(int articleNo) {
		return repo.delete(articleNo);
	}

	@Override
	public int modify(BoardDto dto) {
		return repo.modify(dto);
	}

	@Override
	public List<BoardDto> followingboard(String followId) {
		return repo.followingboard(followId);
	}

}
