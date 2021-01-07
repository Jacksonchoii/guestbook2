package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@WebServlet("/gbc")
public class GuestController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러 테스트
		System.out.println("controller");
		
		//기능
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("addList".equals(action)) {
			System.out.println("리스트 처리");
			//리스트 출력 처리
			GuestDao guestDao = new GuestDao();
			List<GuestVo> guestList = guestDao.getGuestList();
			
			//html쓰기 복잡 --> jsp생성
			
			//데이터 전달
			request.setAttribute("gList", guestList); //내가 정한 별명, 실제 전송할 데이터
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addList.jsp");
			rd.forward(request, response);
			
		} else if("add".equals(action)) {
			System.out.println("등록");
			
			//guest값
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			GuestVo guestVo = new GuestVo(name, password, content);
			
			GuestDao guestDao = new GuestDao();
			guestDao.guestInsert(guestVo);
			
			response.sendRedirect("/guestbook2/gbc?action=addList");
			
		} else if("dform".equals(action)) {
			System.out.println("삭제 폼 처리");
			
			//guest 데이터 받기
			int no = Integer.parseInt(request.getParameter("no"));
			
			GuestDao guestDao = new GuestDao();
			GuestVo guestVo = guestDao.getGuest(no);
			
			//데이터 전달
			request.setAttribute("Delete", guestVo);
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deleteForm.jsp");
			rd.forward(request, response);
			
		} else if("delete".equals(action)) {
			System.out.println("삭제");
			
			//guest값
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
			
			GuestVo guestVo = new GuestVo(no, password);
			
			GuestDao guestDao = new GuestDao();
			guestDao.guestDelete(guestVo);
			
			response.sendRedirect("/guestbook2/gbc?action=addList");
			
		}
		//하나씩 확인해보면서 오류->해결 
		//중간에 계속 꼬이고 헷갈림 로직이 코딩이 머릿속에서 계속 섞임
		//--> 머릿속에서 섞이니까 수업시간에 했던 phonebook2 계속 리딩하게됨
		//--> 리딩하고 코딩하면 뭔가 그대로 입력하는 느낌 --> 내 것이 안되는 느낌
		//--> 더 공부하고 몇번 더 만들어보기 계속 연습해야 될 것 같음
		
		//비밀번호가 다를 때 삭제 안됨 구현실패 생각해보기 
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
