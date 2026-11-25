package com.dscribe.patient.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public class PatientRequest {
  @NotBlank(message="Name is required") @Pattern(regexp="^[A-Za-z]+(?:[ '-][A-Za-z]+)*$", message="Name must contain letters only")
  private String name;
  @NotNull(message="Age is required") @Min(value=0,message="Age must be between 0 and 120") @Max(value=120,message="Age must be between 0 and 120") private Integer age;
  @NotBlank(message="Gender is required") @Pattern(regexp="^(Male|Female|Other)$",message="Please select a valid gender") private String gender;
  @NotBlank(message="Ward is required") @Pattern(regexp="^(General Ward|ICU|Emergency|Private Ward|Pediatric Ward)$",message="Please select a valid ward") private String ward;
  @NotBlank(message="Department is required") @Pattern(regexp="^(Cardiology|Neurology|Orthopedics|Pediatrics|General Medicine|Oncology|Emergency Medicine)$",message="Please select a valid department") private String department;
  @NotBlank(message="Doctor is required") @Pattern(regexp="^(Dr\\. Ananya Rao|Dr\\. Vikram Shah|Dr\\. Meera Nair|Dr\\. Arjun Kumar|Dr\\. Priya Iyer|Dr\\. Rahul Menon|Dr\\. Sneha Patel)$",message="Please select a valid doctor") private String doctor;
  @NotNull(message="Admission date is required") @PastOrPresent(message="Admission date cannot be in the future") private LocalDate admissionDate;
  @NotBlank(message="Status is required") @Pattern(regexp="^(Admitted|Discharged)$",message="Status must be Admitted or Discharged") private String status;
  public String getName(){return name;} public void setName(String v){name=v;}
  public Integer getAge(){return age;} public void setAge(Integer v){age=v;}
  public String getGender(){return gender;} public void setGender(String v){gender=v;}
  public String getWard(){return ward;} public void setWard(String v){ward=v;}
  public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
  public String getDoctor(){return doctor;} public void setDoctor(String v){doctor=v;}
  public LocalDate getAdmissionDate(){return admissionDate;} public void setAdmissionDate(LocalDate v){admissionDate=v;}
  public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
