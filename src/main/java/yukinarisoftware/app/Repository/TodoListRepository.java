package yukinarisoftware.app.Repository;

import yukinarisoftware.app.Entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();

    void add(TodoList todoList);

    boolean remove(Integer number);
}
