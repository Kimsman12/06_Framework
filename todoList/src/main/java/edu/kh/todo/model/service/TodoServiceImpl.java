package edu.kh.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.mapper.TodoMapper;

// @Transactional
// - 트랜젝션 처리를 수행하라고 지시하는 어노테이션
// - 정상 코드 수행 시 COMMIT
// - 기본값 : Service 내부 코드 수행 중 RuntimeException 발생 시 rollback

// rollbackFor 속성 : 어떤 예외가 발생했을 때에 rollback 할지 지정



@Transactional(rollbackFor=Exception.class)
@Service // 비즈니스 로직(데이터 가공, 트랜잭션 처리) 역할 명시 + Bean 등록
public class TodoServiceImpl implements TodoService{

	@Autowired // TodoDAO와 같은 타입 Bean 의존성 주입(DI)
	private TodoDAO dao;
	
	@Autowired // TodoMapper 인터페이스를 상속받은 자식 객체 의존성 주입(DI)
	private TodoMapper mapper; // 자식 객체가 sqlSessionTempalte을 내부적으로 이용
	
	
	// (TEST) todoNo가 1인 할 일 제목 조회
	@Override
	public String testTitle() {
		return dao.testTitle();
	}

	
	
	/** 할 일 목록 + 완료된 할 일 갯수 조회
	 *
	 */
	@Override
	public Map<String, Object> selectAll() {
		
		// 1. 할 일 목록 조회
		List<Todo> todoList = mapper.selectAll();
		
		// 2. 완료된 할 일 개수 조회
		int completeCount = mapper.getCompleteCount();
		
		// 3. 위 두개 결과값을 map으로 묶어서 반환
		
		Map<String, Object> map = new HashMap<>();

		map.put("todoList", todoList);
		map.put("completeCount", completeCount);

		return map;
	}



	@Override
	public int addTodo(String todoTitle, String todoContent) {
		
		// 트랜잭션 제어 처리 -> @Transactinal 어노테이션
		
		
		// 마이바티스에서 SQL에 전달할 수 있는 파라미터 개수는 오직 1개
		// -> todoTitle, todoContent 를 Todo DTO 로 묶어서 전달
		
		Todo todo = new Todo();
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		
		
		
		return mapper.addTodo(todo);
	}


	
	// 할 일 상세 조회
	@Override
	public Todo todoDetail(int todoNo) {
		return mapper.todoDetail(todoNo);
	}



	@Override
	public int changeComplete(Todo todo) {
		return mapper.changeComplete(todo);
	}

	@Override
	public int todoUpdate(Todo todo) {
		
		return mapper.todoUpdate(todo);
	}




	@Override
	public int todoDelete(int todoNo) {
		return mapper.todoDelete(todoNo);
	}


	@Override
	public Todo updateSearch(int todoNo) {
		
		return mapper.updateSearch(todoNo);
	}

	// 전체 할 일 개수 조회
	@Override
	public int getTotalCount() {
		
		return mapper.getTotalCount();
	}

	@Override
	public int getCompleteCount2() {
		// TODO Auto-generated method stub
		return mapper.getCompleteCount2();
	}

	// 할 일 목록 조회
	@Override
	public List<Todo> selectList() {
		
		return mapper.selectAll();
	}
	
	
	
}
