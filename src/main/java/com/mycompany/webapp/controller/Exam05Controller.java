package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.BoardsService;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);
	

	@Autowired
	private BoardsService boardsService;
	
	@RequestMapping("/content")
	public String content() {
		return "exam05/content";
	}	
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		int totalRows = boardsService.getTotalRows();
		Pager pager = new Pager(10, 5, totalRows, pageNo);
		List<Board> list = boardsService.getBoardList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		return "exam05/boardlist";
	}
	
	@GetMapping("/read")
	public String read(int bno, Model model) {
		boardsService.addHitcount(bno);
		Board board = boardsService.getBoard(bno);
		model.addAttribute("board", board);
		return "/exam05/read";
	}
	
	@GetMapping("/downloadAttach")
	public void downloadAttach(int bno, HttpServletResponse response) {
		try {
			Board board = boardsService.getBoard(bno);
			
			// 응답 http 헤더에 저장될 바디의 타입을 싣는다 (어떤 타입인지 실어서 보냄)
			//html은 이 타입을 먼저 보고 분석함 '아 어떤 타입이 오는구나'
			response.setContentType(board.getBattachtype());
			
			//---------------------이게 없으면 이미지를 한번 더 눌렀을때 큰 사진이 나옴------------------------------------
			//응답 HTTP 헤더에 다운로드 할 수 있도록 파일 이름을 지정
			String originalName = board.getBattachoname();
			//이유: 한글 파일일 경우, 깨짐 현상을 방지
			originalName = new String(originalName.getBytes("UTF-8"), "ISO-8859-1");
			//파일로 다운로드 하게 해줌
			response.setHeader("Content-Disposition", "attachment; filename=\""+originalName+"\";");
			//--------------------------------------------------------------------------
			
			//응답 HTTP 바디로 이미지 데이터를 출력
			InputStream is = new FileInputStream("D:/Study/Users/Team5Projects/uploadfiles/"+ board.getBattachsname());
			//데이터를 통해서 파일을 넣고 싶으면 출력 스트림이 필요
			OutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			//이렇게 주면 파일 카피가 됨
			os.flush();
			is.close();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@GetMapping("/updateForm")
	public String updateForm(int bno, Model model) {
		Board board = boardsService.getBoard(bno);
		model.addAttribute("board", board);
		return "exam05/updateForm";
	}
	
	@PostMapping(value="/update", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateBoard(Board board) {
		boardsService.updateBoard(board);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		return jsonObject.toString();
	    //ajax는 redirect 못 씀. 무조건 응답을 줘야 함!
	}
	
	
	@GetMapping(value="/delete", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteBoard(int bno) {
		boardsService.deleteBoard(bno);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		return jsonObject.toString();
	    //ajax는 redirect 못 씀. 무조건 응답을 줘야 함!
	}
	
	@GetMapping("/createForm")
	public String createFormWithAttach() {
		return "exam05/createForm";
	}

	@PostMapping(value="/create", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String createWithAttach(Board board) {
		MultipartFile battach = board.getBattach();
		if(battach != null && !battach.isEmpty()) {//첨부가 있을경우
			board.setBattachoname(battach.getOriginalFilename());
			board.setBattachtype(battach.getContentType());
			String saveName = new Date().getTime()+"-"+board.getBattachoname();
			board.setBattachsname(saveName);
			
			File file = new File("D:/Study/Users/Team5Projects/uploadfiles/"+board.getBattachsname());
			try {
				battach.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
//		logger.info(board.getBtitle());
//		logger.info(board.getBcontent());
//		logger.info(board.getBattachoname());
//		logger.info(board.getBattachsname());
//		logger.info(board.getBattachtype());
		
		board.setBwriter("user1");
		
		boardsService.saveBoard(board);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		return jsonObject.toString();
	}
}
