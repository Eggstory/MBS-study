package com.K2Web.MBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.K2Web.MBS.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({ "", "/" })
	public String index(Model model,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) { // 컨트롤러에서 세션을
																											// 어떻게 찾는지?
		model.addAttribute("boards", boardService.글목록(pageable));
		return "index"; // viewResolver 작동
	}

	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		boardService.updateCount(id);
		model.addAttribute("board", boardService.글상세보기(id));

		
		return "board/detail";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.글상세보기(id));
		return "board/updateForm";
	}



	// USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/notice")
	public String notice(Model model,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable));
		return "board/category/notice";
	}
	@GetMapping("/board/qna")
	public String qna(Model model,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable));
		return "/board/category/qna";
	}
	@GetMapping("/board/data")
	public String data() {
		return "/board/category/data";
	}
	@GetMapping("/board/pictureList")
	public String pictureList() {
		return "/board/category/pictureList";
	}
	@GetMapping("/board/pictureThum")
	public String pictureThum() {
		return "/board/category/pictureThum";
	}
	@GetMapping("/board/video")
	public String video() {
		return "/board/category/video";
	}
	@GetMapping("/board/videoList")
	public String videoList() {
		return "/board/category/videoList";
	}
	
	
	
	// 실패코드 (검색기능)
	/*
	 * @GetMapping("/getSearchList")
	 * 
	 * @ResponseBody private List<BoardDto> getSearchList(@RequestParam("type")
	 * String type, @RequestParam("keyword") String keyword, Model model) throws
	 * Exception{ BoardDto boardDto = new BoardDto(); boardDto.setType(type);
	 * boardDto.setKeyword(keyword); return boardService.getSearchList(boardDto); }
	 */
	

}
