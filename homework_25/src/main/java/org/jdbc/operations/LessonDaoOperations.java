package org.jdbc.operations;

import org.jdbc.entity.Lesson;

import java.util.List;

public interface LessonDaoOperations<T, ID> {
    Lesson insertLesson(T lesson);

    boolean deleteLesson(ID id);

    List<T> getAllLessons();

    T findLessonByID(ID id);
}
