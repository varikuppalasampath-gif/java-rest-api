package com.sampath.restapi.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="employees")
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank(message="Name is required") @Size(max=100) @Column(nullable=false,length=100) private String name;
 @NotBlank(message="Email is required") @Email(message="Enter a valid email address") @Column(nullable=false,unique=true,length=150) private String email;
 @NotBlank(message="Department is required") @Size(max=100) @Column(nullable=false,length=100) private String department;
 @NotBlank(message="Designation is required") @Size(max=100) @Column(nullable=false,length=100) private String designation;
 public Employee(){} public Employee(String name,String email,String department,String designation){this.name=name;this.email=email;this.department=department;this.designation=designation;}
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public String getDesignation(){return designation;} public void setDesignation(String v){designation=v;}
}
