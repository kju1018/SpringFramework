package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.BoardsDao;
import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.Pager;

@Service
public class BoardsService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardsService.class);
	
	
	@Autowired
	private BoardsDao boardsDao;
	//DI Dependency Injection
	
	public List<Board> getBoardList() {
		List<Board> list = boardsDao.selectAll();
		
		return list;
	}
	
	public List<Board> getBoardList(Pager pager) {
		List<Board> list = boardsDao.selectByPage(pager);
		return list;
	}
	
	public void saveBoard(Board board) {
		logger.info("저장 전 bno" + board.getBno());
		boardsDao.insert(board);
		logger.info("저장 후 bno" + board.getBno());
	}

	public Board getBoard(int bno) {
		Board board = boardsDao.selectByBno(bno);
		return board;
	}

	public void updateBoard(Board board) {
		boardsDao.update(board);
		
	}
	
	public void deleteBoard(int bno) {
		boardsDao.delete(bno);
	}
	
	public void addHitcount(int bno) {
		boardsDao.updateBhitcount(bno);
	}

	public int getTotalRows() {
		int rows = boardsDao.count();
		return rows;
	}
}
