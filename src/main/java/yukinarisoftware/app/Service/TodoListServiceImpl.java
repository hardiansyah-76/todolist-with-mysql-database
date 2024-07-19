package yukinarisoftware.app.Service;


import yukinarisoftware.app.Entity.TodoList;
import yukinarisoftware.app.Repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        System.out.println("TODO LIST");
        for (var todolist : model) {
            System.out.println(todolist.getId() + " . " + todolist.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);

        todoListRepository.add(todoList);
        System.out.println("succes add todo");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success){
            System.out.println("succes remove todo : " + number);
        } else {
            System.out.println("failed remove todo : " + number);
        }
    }
}
