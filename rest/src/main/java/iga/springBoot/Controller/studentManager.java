package iga.springBoot.Controller;

import iga.springBoot.Model.Laboratory;
import iga.springBoot.Model.Student;
import iga.springBoot.Repository.LaboratoryRepository;
import iga.springBoot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class studentManager {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LaboratoryRepository laboratoryRepository;
    @GetMapping("/students")
    public List<Student> students(){
        return studentRepository.findAll();
    }
    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable(name="id") Long id){
        return studentRepository.findById(id).get();
    }
    @PostMapping("/students")
    public Student save(@RequestBody Student st){
        if(st.getLaboratory().getId()==null){
            Laboratory laboratory = laboratoryRepository.save(st.getLaboratory());
            st.setLaboratory(laboratory);
        }
        return studentRepository.save(st);
    }
    @PutMapping("/students/{id}")
    public Student update(@PathVariable(name="id") Long id,@RequestBody Student st){
        st.setId(id);
        return studentRepository.save(st);
    }
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable(name="id") Long id){
        studentRepository.deleteById(id);
    }
}
