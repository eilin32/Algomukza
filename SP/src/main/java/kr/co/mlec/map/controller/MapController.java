package kr.co.mlec.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	@RequestMapping(value="/map")
	public String ToMap() {
		
		return "map/map";
	}
}
