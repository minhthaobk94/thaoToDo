package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOIml implements CategoryDAO, DataSource {
    private Connection connection;

    public CategoryDAOIml() {
        connection = getConnection();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = null;
        Category category;
        CallableStatement call;
        try {
            call = connection.prepareCall("{ call sp_getAllCategory() }");
            ResultSet rs = call.executeQuery();
            categoryList = new ArrayList<>();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setTitle(rs.getString(2));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }

    @Override
    public Category getCategory(int id) {
        Category category = null;
        try {
            CallableStatement call = connection.prepareCall("{ call sp_getCategory(?) }");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setTitle(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public int addCategory(Category category) {
        int numOfAffectedRows = 0;
        try {
            CallableStatement call = connection.prepareCall("{ call sp_addCategory(?) }");
            call.setString(1, category.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int updateCategory(Category category) {
        int numOfAffectedRows = 0;
        try {
            CallableStatement call = connection.prepareCall("{ call sp_updateCategory(?, ?) }");
            call.setInt(1, category.getId());
            call.setString(2, category.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int deleteCategory(Category category) {
        int numOfAffectedRows = 0;
        try {
            CallableStatement call = connection.prepareCall("{ call sp_deleteCategory(?) }");
            call.setInt(1, category.getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/thaotodo?user=root&password=123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
