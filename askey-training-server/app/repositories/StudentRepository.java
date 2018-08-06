package repositories;

import io.ebean.Finder;
import io.ebean.Query;
import models.Student;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.UUID;

public class StudentRepository {

    private static Finder<UUID, Student> find = new Finder<>(Student.class);

    public List<Student> findAll() {
        return find.all();
    }

    public Student findById(UUID id) {
        return find.byId(id);
    }

    public Student findByUserAndPassword(String user, String password) {
        return find.query().where()
                .eq("user", user)
                .eq("password", password)
                .findOne();
    }

    public void save(Student student) {
        student.save();
    }

    public void delete(UUID id) {
        find.deleteById(id);
    }
}
