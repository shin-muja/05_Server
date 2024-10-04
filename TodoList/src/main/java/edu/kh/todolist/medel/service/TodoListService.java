package edu.kh.todolist.medel.service;

import java.util.List;

import edu.kh.todolist.model.dto.Todo;

public interface TodoListService {
	// public abstract를 명시하지 않아도 interface내 method는
	// 묵시적으로 public abstract가 붙는다

	/** 할 일 목록 반환 서비스
	 * @return todoList
	 */
	/*public abstract*/List<Todo> todoListFullView();

	/** 전달 받은 title, detail 이용하여 할 일 추가 서비스
	 * @param title
	 * @param detail
	 * @return 추가됨 index 번호 or -1 반환
	 * @throws Exception 
	 */
	int todoAdd(String title, String detail) throws Exception;

}
