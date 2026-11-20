package student_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import student_api.model.Student;
import student_api.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {
        student.setId(null); // force an INSERT, ignore any id sent by the client
        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ ONE (null if not found)
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE (null if not found)
    public Student updateStudent(Long id, Student updated) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        return studentRepository.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}