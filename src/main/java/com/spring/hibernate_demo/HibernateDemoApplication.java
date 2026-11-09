package com.spring.hibernate_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;


@SpringBootApplication
public class HibernateDemoApplication {


  public static void main(String[] args) {
    SpringApplication.run(HibernateDemoApplication.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(StudentDao studentDao) {
    return runner -> {
      createStudent(studentDao);
      // readStudent(studentDao);
      // queryStudents(studentDao);
      // queryStudentLastName(studentDao, "Yagami");
      // updateStudent(studentDao);
      // deleteStudent(studentDao);
      // deleteAllStudent(studentDao);

    };
  }


  private void createStudent(StudentDao studentDao) {
    System.out.println("Creating student information...");
    Student student = new Student("Jhqq Phyrr",
                                    "Avellana",
                                      "jhqq.avellana@example.com");

    System.out.println("Saving student information...");
    studentDao.save(student);

    System.out.println("Saved student. Generated id: " + student.getId());
  }


  private void readStudent(StudentDao studentDao) {
    System.out.println("Retrieving student information...");
    Student student = studentDao.findById(1);

    System.out.println("Retrieved student: " + student);
  }

    private void queryStudents(StudentDao studentDao) {
      List<Student> students = studentDao.findAll();

      for (Student s:students){
        System.out.println(s);
      }
}

  private void queryStudentLastName(StudentDao studentDao, String lastName) {
    List<Student> students = studentDao.findByLastName(lastName);

    for (Student s:students){
      System.out.println(s);
    }
  }

  private void updateStudent(StudentDao studentDao) {
    int id = 1;
    System.out.println("Student ID: " + id );
    Student student = studentDao.findById(id);

    System.out.println("Updating student information...");
    student.setFirstName("Dark");

    studentDao.update(student);
    System.out.println("Updated student: " + student);
  }

  private void deleteStudent(StudentDao studentDao) {
    int id = 4;
    System.out.println("Deleting student ID: " + id );
    studentDao.delete(id);
  }

  private void deleteAllStudent(StudentDao studentDao){
    System.out.println("Deleting all students...");
    int RowsDeleted = studentDao.deleteAll();
    System.out.println("Deleted row count: " + RowsDeleted);
  }




}