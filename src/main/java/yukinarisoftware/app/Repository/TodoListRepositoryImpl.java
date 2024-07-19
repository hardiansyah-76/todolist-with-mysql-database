package yukinarisoftware.app.Repository;

import yukinarisoftware.app.Entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        String sql = "SELECT * FROM todolist";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {

                    List<TodoList> lists = new ArrayList<>();

                    while (resultSet.next()) {
                        TodoList todoList = new TodoList();
                        todoList.setId(resultSet.getInt("id"));
                        todoList.setTodo(resultSet.getString("todo"));
                        lists.add(todoList);
                    }

                    return lists.toArray(new TodoList[] {});
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todolist (todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection()) {

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, todoList.getTodo());
                statement.executeUpdate();
            }

        } catch (SQLException exception) {
            throw new RuntimeException();
        }
    }

    /*
     * logic untuk menghapus data todolist
     *
     */

    public boolean isExist(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection()) {

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, number);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (isExist(number)) {
            String sql = "DELETE FROM todolist WHERE ID = ?";

            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, number);
                    statement.executeUpdate();
                }

                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }
}
