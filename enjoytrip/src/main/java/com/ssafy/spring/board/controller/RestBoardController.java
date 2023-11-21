package com.ssafy.spring.board.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.board.dto.CommentDto;
import com.ssafy.spring.board.service.BoardService;
import com.ssafy.spring.member.dto.MemberDto;

@CrossOrigin("*")
@Controller
@RequestMapping("/resboard")
public class RestBoardController {

	private BoardService service;

	@Autowired
	public RestBoardController(BoardService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> BoardList() {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<BoardDto> res = service.list();
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/clist/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> CommentList(@PathVariable("id")String articleNo) {
		Map<String, Object> map = new HashMap<>();
		try {
			List<CommentDto> res = service.getComment(articleNo);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/view")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> BoardView(String articleNo){
		Map<String, Object> map = new HashMap<>();
		try {
			BoardDto res = service.view(articleNo);
			List<CommentDto> comment = service.getComment(articleNo);
			map.put("resmsg", "출력 성공");
			map.put("rescomment", comment);
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "출력 실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@PostMapping("/write")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> BoardWrite(@RequestBody BoardDto dto) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			int res = service.write(dto);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@PostMapping("/cwrite")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> CommentWrite(@RequestBody CommentDto dto) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			int res = service.insertComment(dto);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> BoardDelete(@PathVariable("id")int articleNo) {
		Map<String,Object> map = new HashMap();
		BoardDto dto = new BoardDto();
		try {
			int res = service.delete(articleNo);
			map.put("resdata", res);
			map.put("resmsg", "삭제성공");
			
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
    @DeleteMapping("/cdelete/{commentNo}")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable String commentNo) {
        Map<String, Object> map = new HashMap<>();

        try {
            int res = service.deleteComment(commentNo);
            map.put("resmsg", "댓글 삭제 성공");
            map.put("resdata", res);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("resmsg", "댓글 삭제 실패");
            map.put("resdata", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }
    
	@PutMapping("/modify/{id}")
	public ResponseEntity<Map<String, Object>> BoardModify(@PathVariable("id")int articleNo,@RequestBody BoardDto dto){
		Map<String,Object> map = new HashMap();
		try {
			dto.setArticleNo(articleNo);
			int res = service.modify(dto);
			map.put("resdata", res);
			map.put("resmsg", "수정성공");
			
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	}
	

    @PostMapping("/incom/{id}")
    public ResponseEntity<Map<String, Object>> insertComment(@PathVariable("articleNo")int articleNo,@RequestBody CommentDto dto) {
        Map<String, Object> map = new HashMap<>();
        try {
            int res = service.insertComment(dto);
            map.put("resmsg", "댓글 등록 성공");
            map.put("resdata", res);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("resmsg", "댓글 등록 실패");
            map.put("resdata", e.getMessage());
        }
        ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
        return res;
    }
    
	@GetMapping("/followdetail/{followId}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> FollowingBoard(@PathVariable("followId")String followId) {
		Map<String, Object> map = new HashMap<>();
		try {
			List<BoardDto> res = service.followingboard(followId);
			map.put("resmsg", "성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "출력 실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	
    

    
}
