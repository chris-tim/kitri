package kr.re.kitri.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.common.dao.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
}
