package org.example;

import org.example.entity.Student;
import org.example.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.createTable();
//        studentService.insertIntoStudent(new Student("Aisalbek"));
//        System.out.println(studentService.getStudentById(4L));
//        studentService.deleteStudentById(5L);
        studentService.updateStudentById(1L);
    }
}