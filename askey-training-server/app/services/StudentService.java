package services;

import models.Student;
import repositories.StudentRepository;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.UUID;

public class StudentService {

    private StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(UUID id) {
        return studentRepository.findById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(UUID id) {
        studentRepository.delete(id);
    }

    public boolean authenticate(String user, String password) {
        Student student = studentRepository.findByUserAndPassword(user, password);
        return student != null;
    }
}
