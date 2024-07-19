package yukinarisoftware.app;

import yukinarisoftware.app.Repository.TodoListRepository;
import yukinarisoftware.app.Repository.TodoListRepositoryImpl;
import yukinarisoftware.app.Service.TodoListService;
import yukinarisoftware.app.Service.TodoListServiceImpl;
import yukinarisoftware.app.Util.DatabaseUtil;
import yukinarisoftware.app.View.TodoListView;

import javax.sql.DataSource;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {

        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();

    }
}
