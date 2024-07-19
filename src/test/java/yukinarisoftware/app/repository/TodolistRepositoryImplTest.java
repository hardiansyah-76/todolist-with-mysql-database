package yukinarisoftware.app.repository;


import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yukinarisoftware.app.Entity.TodoList;
import yukinarisoftware.app.Repository.TodoListRepository;
import yukinarisoftware.app.Repository.TodoListRepositoryImpl;
import yukinarisoftware.app.Util.DatabaseUtil;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("yoasobi udin");

        todoListRepository.add(todoList);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));
    }

    @Test
    void getAll() {
        TodoList[] todoLists = todoListRepository.getAll();

        for (var result : todoLists) {
            System.out.println(result.getId() + " : " + result.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
