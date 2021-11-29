package com.SpringApplication.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Pattern(regexp = "^[a-zA-Z]*",message = "Only alphabets are allowed")
    @NotEmpty(message = "is required")
    @Column(name="first_name")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]*",message = "Only alphabets are allowed")
    @NotEmpty(message = "is required")
    @Column(name="last_name")
    private String lastName;

    @Email(message = "Enter a valid email address")
    @NotEmpty(message = "is required")
    @Column(name="email")
    private String email;

    @Pattern(regexp = "^.{6,}$",message = "Password must contain  minimum 6 in length")
    @Column(name = "password")
    private String password;



    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="course_student",
            joinColumns=@JoinColumn(name="student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id")
    )
    private List<Course> courses;

    public Student(){
    }

    public Student(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Student(String firstName, String lastName, String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
