package dao;

import bean.Todo;

import java.util.List;

public interface TodoDAO {
    List<Todo> getTodos();
    Todo getTodo(int id);
    int addTodo(Todo todo);
    int updateTitle (Todo todo);
    int updateCatId (Todo todo);
    int deleteTodo (int id);
}
