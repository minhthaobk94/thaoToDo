package bean;

public class Todo {
    private int id;
    private Category category;
    private String title;


    public Todo(int id, Category category, String title) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Todo() {

    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Todo(int id, Category category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", category=" + category + "]";
    }

}
