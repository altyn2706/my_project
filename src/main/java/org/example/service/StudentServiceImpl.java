package org.example.service;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void createTable() {
        studentDao.createTable();
    }

    @Override
    public void insertIntoStudent(Student s) {
        studentDao.insertIntoStudent(s);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentDao.deleteStudentById(id);
    }

    @Override
    public Object getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void updateStudentById(Long id) {
        studentDao.updateStudentById(id);
    }
}
