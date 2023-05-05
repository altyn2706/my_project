package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.example.entity.Student;
import org.example.util.DbConnection;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private EntityManager entityManager = DbConnection.getEntityManager();

    @Override
    public void createTable() {
        entityManager.getTransaction().begin();
          entityManager.getEntityGraph("FFF");

        Query nativeQuery = entityManager.createNativeQuery("create table if not exists student(" +
                "id serial primary key ," +
                "name varchar)");

        nativeQuery.executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Override
    public void insertIntoStudent(Student s) {
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteStudentById(Long id) {
        Student studentById = getStudentById(id);
        entityManager.getTransaction().begin();
        if (studentById == null) {
            System.out.println("Student not found!");
        }
        else{
            entityManager.remove(studentById);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Student getStudentById(Long id) {
        Query query = entityManager.createQuery("SELECT s FROM Student s where s.id= ?1");
        query.setParameter(1, id);
        try{
            entityManager.getTransaction().begin();
            Student student = (Student) query.getSingleResult();
            entityManager.getTransaction().commit();
            return student;

        }catch (NoResultException e){
            return null;
        }

    }

    @Override
    public List<Student> getAllStudents() {
        entityManager.getTransaction().begin();
        List<Student> students = entityManager.createQuery("select s from Student s").getResultList();
        entityManager.getTransaction().commit();
        return students;
    }

    @Override
    public void updateStudentById(Long id) {
        Student studentById = getStudentById(id);
        entityManager.getTransaction().begin();


        if(studentById!=null){
            studentById.setName("Ulukbek19");
        }
        else{
            System.out.println("Student doesn't found!");
        }

        entityManager.merge(studentById);

        entityManager.getTransaction().commit();

    }
}
