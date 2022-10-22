package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public interface StudentDao {

    void createTable();

    void insertIntoStudent(Student s);

    void deleteStudentById(Long id);

    Object getStudentById(Long id);

    List<Student> getAllStudents();

    void updateStudentById(Long id);
}
