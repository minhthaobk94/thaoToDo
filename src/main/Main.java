package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void printToDo(Category category, List<Todo> listToDo) {
		for (Todo todo : listToDo) {
			if (todo.getCatelogy().equals(category)) {
				System.out.println(todo);
			}
		}
	}

	public static void main(String[] args) {
		Category catelogy1 = new Category(1, "cate1");
		Category catelogy2 = new Category(2, "cate2");
		Category catelogy3 = new Category(3, "cate3");
		Todo todo1 = new Todo(1, "todo1", catelogy1);
		Todo todo2 = new Todo(2, "todo2", catelogy1);
		Todo todo3 = new Todo(3, "todo3", catelogy2);
		Todo todo4 = new Todo(4, "todo4", catelogy2);
		Todo todo5 = new Todo(5, "todo5", catelogy3);
		Todo todo6 = new Todo(6, "todo6", catelogy3);
		Todo todo7 = new Todo(7, "todo7", catelogy3);

		List<Todo> listToDo = new ArrayList<>();
		listToDo.add(todo1);
		listToDo.add(todo2);
		listToDo.add(todo3);
		listToDo.add(todo4);
		listToDo.add(todo5);
		listToDo.add(todo6);
		listToDo.add(todo7);

		printToDo(catelogy3, listToDo);
	}

}
