package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CategoryDAOIml categoryDAO = new CategoryDAOIml();
        Category category = new Category();
        if (categoryDAO.getConnection() != null) {
            System.out.println("ok");
        }
        int i = categoryDAO.addCategory(new Category(4, "ilu"));
        System.out.println(i);
        categoryDAO.closeConnection();
    }
}
