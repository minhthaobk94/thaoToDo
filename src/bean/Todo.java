package bean;

public class Todo {
    private int id;
    private Category catelogy;
    private String title;


    public Todo(int id, Category catelogy, String title) {
        this.id = id;
        this.title = title;
        this.catelogy = catelogy;
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
        this.catelogy = category;
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

    public Category getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(Category catelogy) {
        this.catelogy = catelogy;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", catelogy=" + catelogy + "]";
    }

}
