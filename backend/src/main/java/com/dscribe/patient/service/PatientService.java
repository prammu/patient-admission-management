package com.dscribe.patient.service;
import com.dscribe.patient.dto.PatientRequest;
import com.dscribe.patient.model.Patient;
import com.dscribe.patient.repository.PatientRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service
public class PatientService {
  private final PatientRepository repo;
  public PatientService(PatientRepository repo){this.repo=repo;}
  public List<Patient> findAll(String ward,String department,String doctor,String search){
    Specification<Patient> spec=(root,q,cb)->cb.conjunction();
    if(ward!=null&&!ward.isBlank()) spec=spec.and((r,q,cb)->cb.equal(r.get("ward"),ward));
    if(department!=null&&!department.isBlank()) spec=spec.and((r,q,cb)->cb.equal(r.get("department"),department));
    if(doctor!=null&&!doctor.isBlank()) spec=spec.and((r,q,cb)->cb.equal(r.get("doctor"),doctor));
    if(search!=null&&!search.isBlank()) spec=spec.and((r,q,cb)->cb.like(cb.lower(r.get("name")),"%"+search.trim().toLowerCase()+"%"));
    return repo.findAll(spec,org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC,"id"));
  }
  public Patient create(PatientRequest req){Patient p=new Patient(); copy(req,p); return repo.save(p);}
  public Patient update(Long id,PatientRequest req){Patient p=repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found"));copy(req,p);return repo.save(p);}
  public void delete(Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found");repo.deleteById(id);}
  public Patient discharge(Long id){Patient p=repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found"));p.setStatus("Discharged");return repo.save(p);}
  private void copy(PatientRequest r,Patient p){p.setName(r.getName().trim());p.setAge(r.getAge());p.setGender(r.getGender());p.setWard(r.getWard());p.setDepartment(r.getDepartment());p.setDoctor(r.getDoctor());p.setAdmissionDate(r.getAdmissionDate());p.setStatus(r.getStatus());}
}
