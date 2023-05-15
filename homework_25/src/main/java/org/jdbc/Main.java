package org.jdbc;

import org.jdbc.entity.Homework;
import org.jdbc.entity.Lesson;
import org.jdbc.operations.LessonDaoOperations;
import org.jdbc.operations.impl.LessonDao;
import org.jdbc.utils.DataBaseConnection;

public class Main {
    public static void main(String[] args) {
        LessonDaoOperations<Lesson, Long> lessonDao = new LessonDao(DataBaseConnection.initDataSource());

        Homework homework = new Homework();
        homework.setId(2L);
        homework.setName("Exercises");
        homework.setDescription("Exercise 20-25");

        Lesson lesson = new Lesson();
        lesson.setName("Math");
        lesson.setHomework(homework);

        Lesson insertLesson = lessonDao.insertLesson(lesson);
        System.out.println(insertLesson);

        Lesson lessonByID = lessonDao.findLessonByID(2L);
        System.out.println(lessonByID);

        boolean isDeleted = lessonDao.deleteLesson(1L);
        System.out.println(isDeleted);
    }
}