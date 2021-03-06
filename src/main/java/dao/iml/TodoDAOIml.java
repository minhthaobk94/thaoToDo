package dao.iml;

import bean.Todo;
import dao.CategoryDAO;
import dao.TodoDAO;
import dao.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOIml implements TodoDAO, DataSource {
    private Connection connection;

    public TodoDAOIml() {
        connection = getConnection();
    }

    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/thaotodo?user=root&password=123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

     
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

     
    public List<Todo> getTodos() {
        CallableStatement call;
        List<Todo> todoList = null;
        Todo todo;

        try {
            call = connection.prepareCall("{ call sp_getAllTodos()}");
            ResultSet rs = call.executeQuery();
            todoList = new ArrayList<Todo>();
            while (rs.next()) {
                todo = new Todo();
                CategoryDAO categoryDAO = new CategoryDAOIml();
                todo.setId(rs.getInt(1));
                todo.setCategory(categoryDAO.getCategory(rs.getInt(2)));
                todo.setTitle(rs.getString(3));
                todoList.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

     
    public Todo getTodo(int id) {
        CallableStatement call;
        Todo todo = null;
        CategoryDAO categoryDAO;
        try {
            call = connection.prepareCall("{ call sp_getTodo(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                categoryDAO = new CategoryDAOIml();
                todo = new Todo();
                todo.setId(rs.getInt(1));
                todo.setCategory(categoryDAO.getCategory(rs.getInt(2)));
                todo.setTitle(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

     
    public int addTodo(Todo todo) {
        CategoryDAOIml categoryDAOIml = null;
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = connection.prepareCall("{ call sp_addTodo(?, ?)}");
            call.setInt(1, todo.getCategory().getId());
            call.setString(2, todo.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

     
    public int updateTitle(Todo todo) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = connection.prepareCall("{call sp_updateTodoTitle(?, ?)}");
            call.setInt(1, todo.getId());
            call.setString(2, todo.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

     
    public int updateCatId(Todo todo) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = connection.prepareCall("{call sp_updateCatId(?, ?)}");
            call.setInt(1, todo.getId());
            call.setInt(2, todo.getCategory().getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

     
    public int deleteTodo(int id) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = connection.prepareCall("{call sp_deleteTodo(?)}");
            call.setInt(1, id);
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
