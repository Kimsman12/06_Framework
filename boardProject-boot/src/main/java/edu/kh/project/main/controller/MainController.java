package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/") // "/" 요청 매핑
	public String mainPage() {
		
		// 접두사 접미사 제외
		// 접두사 : classpath:/templates/
		// 접미사 : .html
		return "common/main";
	}
}
