package yukinarisoftware.app.View;


import yukinarisoftware.app.Service.TodoListService;
import yukinarisoftware.app.Util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

   public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add todo");
            System.out.println("2. Remove todo");
            System.out.println("x. Exit App");

            var input = InputUtil.input("Choose");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

   public void addTodoList() {
       System.out.println("Add TodoList");
       var todo = InputUtil.input("todo : (x for cancel)");

       if (todo.equals("x")) {
           // stop
       } else {
           todoListService.addTodoList(todo);
       }
    }

   public void removeTodoList() {

       var number = InputUtil.input("Number to delete : (x for cancel)");
       if (number.equals("x")) {
           // cancel
       } else {
           todoListService.removeTodoList(Integer.valueOf(number));
       }

    }
}
