package edu.kh.todolist.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todolist.medel.service.TodoListService;
import edu.kh.todolist.medel.service.TodoListServiceImpl;
import edu.kh.todolist.model.dto.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/main"요청을 매핑하여 처리하는 서블릿
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	/*
	 * "/main" 메인페이지 요청을 처리하는 서블릿을 만드는 이유
	 * 
	 * - Servlet에서 추가한 데이터를 
	 * 메인페이지에서 사용 할 수 있기 위해
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Service 객체 생성
			TodoListService service = new TodoListServiceImpl();
			// interface      - 상속 >        구현 class
			
			// 전체 할 일 목록 Service 호출해서 얻어오기
			List<Todo> todoList = service.todoListFullView();
			
			// request scope 객체 값을 추가
			req.setAttribute("todoList", todoList);
		
			// 메인 페이지 응답을 담당하는 JSP에 요총 위임
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
