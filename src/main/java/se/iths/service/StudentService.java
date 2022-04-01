package se.iths.service;


import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {
    @PersistenceContext
    EntityManager manager;

    public void create(Student student){
        manager.persist(student);
    }


    public Student getByMail(String email){
        return manager.find(Student.class, email);
    }

    public void update(Student student){
        manager.merge(student);
    }

    public void delete(Student foundStudent){
        String email = foundStudent.getEmail();
        manager.remove(manager.find(Student.class, email));

    }

    public List<Student> getAll(){
        return manager.createQuery("SELECT x FROM Student x ORDER BY x.lastName", Student.class).getResultList();
    }


    public List<Student> getByLastName(String lastName){
        return manager.createQuery("SELECT x FROM Student x WHERE x.lastName='" + lastName + "'", Student.class).getResultList();
    }
}

