package com.dscribe.patient.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="patients")
public class Patient {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  private Integer age;
  private String gender;
  private String ward;
  private String department;
  private String doctor;
  private LocalDate admissionDate;
  private String status;
  public Patient() {}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public Integer getAge(){return age;} public void setAge(Integer age){this.age=age;}
  public String getGender(){return gender;} public void setGender(String gender){this.gender=gender;}
  public String getWard(){return ward;} public void setWard(String ward){this.ward=ward;}
  public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;}
  public String getDoctor(){return doctor;} public void setDoctor(String doctor){this.doctor=doctor;}
  public LocalDate getAdmissionDate(){return admissionDate;} public void setAdmissionDate(LocalDate admissionDate){this.admissionDate=admissionDate;}
  public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
}
