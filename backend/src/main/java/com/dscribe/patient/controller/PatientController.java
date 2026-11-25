package com.dscribe.patient.controller;
import com.dscribe.patient.dto.PatientRequest;
import com.dscribe.patient.model.Patient;
import com.dscribe.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/patients") @CrossOrigin(origins="http://localhost:5173")
public class PatientController {
  private final PatientService service;
  public PatientController(PatientService service){this.service=service;}
  @GetMapping public List<Patient> all(@RequestParam(required=false) String ward,@RequestParam(required=false) String department,@RequestParam(required=false) String doctor,@RequestParam(required=false) String search){return service.findAll(ward,department,doctor,search);}
  @PostMapping public Patient create(@Valid @RequestBody PatientRequest request){return service.create(request);}
  @PutMapping("/{id}") public Patient update(@PathVariable Long id,@Valid @RequestBody PatientRequest request){return service.update(id,request);}
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
  @PatchMapping("/{id}/discharge") public Patient discharge(@PathVariable Long id){return service.discharge(id);}
}
