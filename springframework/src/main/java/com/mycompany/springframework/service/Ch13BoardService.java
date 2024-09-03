package com.mycompany.springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13BoardDao;
import com.mycompany.springframework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch13BoardService {
	
	@Autowired
	private Ch13BoardDao boardDao;//mybatis가 생성
	
	public List<Ch13Board> getBoardList(){
		
		return null;
	}
	
	public Ch13Board getBoard(int bno) {
		return null;
	}
	
	public void writeBoard(Ch13Board board) {
		log.info("실행");
		boardDao.insert(board);
	}
	
	public void updateBoard(Ch13Board board) {
		
	}
	
	public void deleteBoard(int bno) {
		
	}
}
