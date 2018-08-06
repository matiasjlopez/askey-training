package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StudentService;

import javax.inject.Inject;
import java.util.Date;
import java.util.UUID;

public class StudentController extends Controller {

    private StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public Result test() {
        return ok("Hello World!");
    }

    public Result save() {
        Student student = request().body().as(Student.class);
        if(student == null) {
            return badRequest("Student is null");
        } else {
            studentService.save(student);
            return ok();
        }
    }

    public Result delete(String id) {
        Student student = studentService.findById(UUID.fromString(id));
        if (student == null) {
            return notFound("Student with ID: " + id + " not found.");
        } else {
            studentService.delete(UUID.fromString(id));
            return ok();
        }
    }

    public Result find(String id) {
        Student student = studentService.findById(UUID.fromString(id));
        if (student == null) {
            return notFound("Student with ID: " + id + " not found.");
        } else {
            return ok(Json.toJson(student));
        }
    }

    public Result findAll() {
        return ok(Json.toJson(studentService.findAll()));
    }

    public Result authenticate() {
        JsonNode jsonNode = request().body().asJson();
        if (studentService.authenticate(jsonNode.asText("user"), jsonNode.asText("password"))) {
            return ok();
        } else {
            return unauthorized();
        }
    }
}
