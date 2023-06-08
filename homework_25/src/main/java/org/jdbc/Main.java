package org.jdbc;

import org.jdbc.entity.Homework;
import org.jdbc.entity.Lesson;
import org.jdbc.operations.LessonDaoOperations;
import org.jdbc.operations.impl.LessonDao;
import org.jdbc.utils.DataBaseConnection;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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
        LOGGER.info(String.valueOf(insertLesson));

        Lesson lessonByID = lessonDao.findLessonByID(2L);
        LOGGER.info(String.valueOf(lessonByID));

        boolean isDeleted = lessonDao.deleteLesson(1L);
        LOGGER.info(String.valueOf(isDeleted));
    }
}