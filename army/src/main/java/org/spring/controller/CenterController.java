package org.spring.controller;

import java.util.List;

import org.spring.domain.Criteria;
import org.spring.domain.FAQVO;
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
@RequestMapping("/center/*")
@AllArgsConstructor
@Log4j
public class CenterController {
	private final CenterService centerService;
	
	@GetMapping("/information/benefit")
	public void benefitlist(Criteria cri ,Model model) {
		log.info("benefit시작");
		int total = centerService.getTotal(cri);
		PageDTO pageResult = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageResult);
		log.info(pageResult);
	}
	
	@ResponseBody
	@RequestMapping(value="/information/getList",method = RequestMethod.POST)
	public List<SaleVO> getbenefitlist(Criteria cri){
		log.info("getbenefitlist Ajax실행");
		return centerService.searchBenefit(cri);
	}
	
	@GetMapping("/cscenter/faq")
	public void faqlist() {
		
	}
	
	@ResponseBody
	@RequestMapping(value="/cscenter/faqList",method = RequestMethod.POST)
	public List<FAQVO> getFAQlist(String category){
		log.info("getfaqlist Ajax실행");
		return centerService.FaqList(category);
	}

}
