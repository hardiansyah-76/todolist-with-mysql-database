package yukinarisoftware.app.Util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
    @Test
    void testConnect() throws SQLException {
        HikariDataSource dataSource= DatabaseUtil.getDataSource();

        Connection connection = dataSource.getConnection();

        connection.close();

        dataSource.close();
    }
}
