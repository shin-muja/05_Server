package edu.kh.todolist.controller;

import java.io.IOException;

import edu.kh.todolist.medel.service.TodoListService;
import edu.kh.todolist.medel.service.TodoListServiceImpl;
import edu.kh.todolist.model.dto.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

// Cotroller(요청을 받아 알맞은 서비스 호출, 응답을 어떻게 처리할지 결정 -> View)

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet{
	
	// a태그 요청은 GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			// 요청 받았을 때 파라미터 전달받음
			
			// 1. 전달받은 파라미터 꺼내오기
			int index = Integer.parseInt(req.getParameter("index"));
			// 0 ~ 4
			
			// 2. 상세 조회 서비스 호출
			TodoListService service = new TodoListServiceImpl();
			
			Todo todo = service.todoDetailView(index);
			// index 번째 todo 가 없으면 null
			//					  있으면 Todo 객체가 있음
			
			// index 번쨰 todo가 존재하지 않을 경우
			// -> 메인페이지(/) redirect 후
			//    "해당 index에 todo가 존재하지 않습니다"
			//     alert
			if( todo == null ) {
				
				// message -> session 에 세팅
				HttpSession session = req.getSession();
				session.setAttribute("message", "해당 index에 todo가 존재하지 않습니다");
				
				resp.sendRedirect("/");
				return;
			}
			
			// index 번째 todo가 존재하는 경우
			// detatil.jsp 로 forward 해서 응답
			
			// 요청 위임한 페이지에서
			// 서비스로부터 얻어온 todo를 사용하기 위해
			// request scope 세팅
			req.setAttribute("todo", todo);
			
			// JSP 파일 경로로 요청발송자를 통해 요청 위임
			req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
