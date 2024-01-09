package org.spring.controller;

import java.util.List;

import org.spring.domain.Criteria;
import org.spring.domain.PageDTO;
import org.spring.domain.SaleVO;
import org.spring.service.CenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/*")
@AllArgsConstructor
@Log4j
public class HomeController {
	
	@GetMapping("/main")
	public void mainpage() {

	}
	
	

}
