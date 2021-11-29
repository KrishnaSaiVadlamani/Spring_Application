package com.springapplication.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "course")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Course {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     @NotEmpty(message = "is required")
     @Column(name = "title")
     private String title;


     @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
             CascadeType.PERSIST,CascadeType.REFRESH})
     @JoinTable(
             name="course_student",
             joinColumns=@JoinColumn(name="course_id",referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "id")
     )
     private List<Student> students;


     public Course(String title) {
          this.title = title;
     }

     public Course(int id, String title) {
          this.id = id;
          this.title = title;
     }



}
