package org.jdbc.operations;

import org.jdbc.entity.Homework;
import org.jdbc.exceptions.JdbcOperationException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class HomeworkDao {
    private DataSource dataSource;

    public HomeworkDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Homework getHomeworkByID(Long id) {
        Objects.requireNonNull(id);
        String sql = """
                SELECT id, name, description FROM homework WHERE id = ?
                """;

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            int idx = 1;
            ps.setLong(idx, id);
            Homework homework = new Homework();

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                homework.setId(resultSet.getLong("id"));
                homework.setName(resultSet.getString("name"));
                homework.setDescription(resultSet.getString("description"));
            } else {
                throw new JdbcOperationException("Homework with id = %d not found".formatted(id));
            }
            return homework;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get homework by id = %d".formatted(id));
        }
    }
}
