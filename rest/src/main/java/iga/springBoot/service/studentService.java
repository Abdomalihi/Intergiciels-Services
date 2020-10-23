package iga.springBoot.service;

import iga.springBoot.Model.Student;
import iga.springBoot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(name = "studentWS")
public class studentService {
    @Autowired
    private StudentRepository studentRepository;
    @WebMethod(operationName = "getStudent")
    public Student getOne(@PathVariable(name="id") Long id){
        return studentRepository.findById(id).get();
    }
}