package org.jdbc.operations.impl;

import org.jdbc.entity.Homework;
import org.jdbc.entity.Lesson;
import org.jdbc.exceptions.JdbcOperationException;
import org.jdbc.operations.HomeworkDao;
import org.jdbc.operations.LessonDaoOperations;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LessonDao implements LessonDaoOperations<Lesson, Long> {
    private static final String INSERT_INTO_LESSON = """
            INSERT INTO lesson (name, homework_id) VALUES (?, ?)
            """;
    private static final String DELETE_LESSON = """
            DELETE FROM lesson WHERE id = ?
            """;

    private static final String SELECT_LESSON = """
            SELECT l.id, l.name, h.id, h.name, h.description
            FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id;
            """;
    private static final String SELECT_BY_ID_LESSON = """
            SELECT id, name, homework_id FROM lesson WHERE id = ?
            """;
    private final HomeworkDao homeworkDao = new HomeworkDao(this.dataSource);
    private DataSource dataSource;

    public LessonDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Lesson insertLesson(final Lesson lesson) {
        Objects.requireNonNull(lesson);
        if (lesson.getId() != null) {
            throw new JdbcOperationException("ID mustn`t be provided during the insert operation!");
        }

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_INTO_LESSON, Statement.RETURN_GENERATED_KEYS)) {
            int idx = 1;
            prepStatement.setString(idx++, lesson.getName());
            prepStatement.setLong(idx, lesson.getHomework().getId());

            int rowsInserted = prepStatement.executeUpdate();
            if (rowsInserted < 1) {
                throw new JdbcOperationException("No rows were added into database, input lesson = %s".formatted(lesson));
            }
            ResultSet generatedKeys = prepStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedKeysIndex = 1;
                Long id = generatedKeys.getLong(generatedKeysIndex);
                lesson.setId(id);
            }
            return lesson;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to add lesson = %s".formatted(lesson), e);
        }
    }

    @Override
    public boolean deleteLesson(final Long id) {
        Objects.requireNonNull(id);

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LESSON)) {
            int index = 1;
            preparedStatement.setLong(index, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted < 1) {
                throw new JdbcOperationException("Rows were not deleted!");
            }
            return true;
        } catch (SQLException e) {
            throw new JdbcOperationException("");
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LESSON)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Homework homework = homeworkDao.getHomeworkByID(resultSet.getLong("homework_id"));

                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getLong("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setUpdatedAt(resultSet.getTimestamp("updatedAt").toLocalDateTime());
                lesson.setHomework(homework);

                lessons.add(lesson);
            }
            return lessons;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get all lessons!");
        }
    }

    @Override
    public Lesson findLessonByID(final Long id) {
        Objects.requireNonNull(id);

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_LESSON)) {
            int index = 1;
            preparedStatement.setLong(index, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getLong("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setUpdatedAt(resultSet.getTimestamp("updatedAt").toLocalDateTime());

                Homework homework = homeworkDao.getHomeworkByID(resultSet.getLong("homework_id"));

                lesson.setHomework(homework);
                return lesson;
            } else {
                throw new JdbcOperationException("Lesson by id = %d wasn`t found!".formatted(id));
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to find lesson by id = %d".formatted(id), e);
        }
    }
}
