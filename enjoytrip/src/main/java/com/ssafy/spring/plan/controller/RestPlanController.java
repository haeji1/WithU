package com.ssafy.spring.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.spring.plan.dto.PlanDto;
import com.ssafy.spring.plan.dto.TravelDto;
import com.ssafy.spring.plan.service.PlanService;

@CrossOrigin("*")
@Controller
@RequestMapping("/plan")
public class RestPlanController {
	private PlanService service;
	
	@Autowired	
	public RestPlanController(PlanService service) {
		super();
		this.service = service;
	}

	@PostMapping("/write/plan")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> PlanWrite(@RequestBody PlanDto dto) {
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
	
	@PostMapping("/write/travel")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> PlanWrite(@RequestBody List<TravelDto> dtoList) {
		Map<String, Object> map = new HashMap<>();
		try {
			int planNo = service.getPlanNo();
			System.out.println("가져온 planNo : " + planNo);
			System.out.println("dotoList개수: " + dtoList.size());
			for (int i = 0; i < dtoList.size(); ++i) {
				TravelDto tmp = new TravelDto();
				tmp.setAddress_name(dtoList.get(i).getAddress_name());
				tmp.setPhone(dtoList.get(i).getPhone());
				tmp.setPlace_name(dtoList.get(i).getPlace_name());
				tmp.setX(dtoList.get(i).getX());
				tmp.setY(dtoList.get(i).getY());
				tmp.setPlace_url(dtoList.get(i).getPlace_url());
				tmp.setPlanNo(planNo);
				dtoList.get(i).setPlanNo(planNo + 1);
				System.out.println("list들 확인 >> dtoList[" + i + "] : " + dtoList.get(i));
				System.out.println(tmp);
				int res = service.Twrite(tmp);
				if (res == 0) {
					System.out.println("service.Twrite(tmp)가 0을 리턴하는데??");
				}
			}
			System.out.println("성공 했다 ㅋㅋ");
			map.put("resmsg", "입력 성공");
//			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/plan-list")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> PlanList() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<PlanDto> res = service.list();
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
	public ResponseEntity<Map<String, Object>> PlanView(int articleNo){
		Map<String, Object> map = new HashMap<>();
		try {
//			service.updateHit(articleNo);
			PlanDto res = service.view(articleNo);
//			List<CommentDto> comment = service.getComment(articleNo);
			map.put("resmsg", "출력 성공");
//			map.put("rescomment", comment);
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
