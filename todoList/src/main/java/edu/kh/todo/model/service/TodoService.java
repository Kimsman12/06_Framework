package edu.kh.todo.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.todo.model.dto.Todo;

public interface TodoService {

	/** (TEST) todoNo 가 1인 할 일 제목 조회
	 * @return title
	 */
	String testTitle();

	
	/** 할 일 목록 + 완료된 할 일 객수 조회
	 * @return map
	 */
	Map<String, Object> selectAll();


	/** 할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 */
	int addTodo(String todoTitle, String todoContent);


	/** 할 일 상세 조회
	 * @param todoNo
	 * @return todo
	 */
	Todo todoDetail(int todoNo);


	/** 완료 여부 변경
	 * @param todo
	 * @return result
	 */
	int changeComplete(Todo todo);


	int todoUpdate(Todo todo);


	int todoDelete(int todoNo);


	Todo updateSearch(int todoNo);


	/** 전체 할 일 개수 조회
	 * @return 
	 */
	int getTotalCount();


	/** 완료된 할 일 개수 조회
	 * @return
	 */
	int getCompleteCount2();


	/** 할 일 목록 조회
	 * @return
	 */
	List<Todo> selectList();


	




	
	





	

}
