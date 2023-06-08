package org.jdbc.operations;

import org.jdbc.entity.Lesson;

import java.util.List;

public interface LessonDaoOperations<Lesson, Long> {
    Lesson insertLesson(Lesson lesson);

    boolean deleteLesson(Long id);

    List<Lesson> getAllLessons();

    Lesson findLessonByID(Long id);
}
