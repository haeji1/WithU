package com.ssafy.spring.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
			for (int i = 0; i < dtoList.size(); ++i) {
				dtoList.get(i).setPlanNo(planNo + 1);
				System.out.println("list들 확인 >> dtoList[" + i + "] : " + dtoList.get(i));
				int res = service.Twrite(dtoList.get(i));
			}
			System.out.println("에러때문에 여기 못오겠지???");
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
}
