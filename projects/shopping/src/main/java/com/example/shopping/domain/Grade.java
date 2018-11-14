//package com.example.shopping.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "grade")
//@Getter
//@Setter
//@ToString
//public class Grade {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "grade_id")
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "grade")
//    List<Member> members = new ArrayList<>();
//}
