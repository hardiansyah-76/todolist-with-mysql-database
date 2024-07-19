package yukinarisoftware.app.Entity;

public class TodoList {
    private Integer id;

    private String todo;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public TodoList(String todo) {
        this.todo = todo;
    }

    public TodoList() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
