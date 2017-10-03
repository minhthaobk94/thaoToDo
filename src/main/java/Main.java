import bean.Category;
import bean.Todo;
import dao.iml.TodoDAOIml;

public class Main {
    public static void main(String[] args) {
        TodoDAOIml todoDAOIml = new TodoDAOIml();
        Category category = new Category(11, "try it");
        Todo todo = new Todo(1, category);
        if (todoDAOIml.getConnection() != null) {
            System.out.println("ok");
        }
        System.out.println(todoDAOIml.deleteTodo(6));
    }
}
