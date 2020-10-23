package iga.springBoot;
import iga.springBoot.Model.Laboratory;
import iga.springBoot.Model.Student;
import iga.springBoot.Repository.LaboratoryRepository;
import iga.springBoot.Repository.StudentRepository;
import iga.springBoot.service.studentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.xml.ws.Endpoint;
import java.util.Date;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {

	    SpringApplication.run(Application.class, args);
        String url="http://localhost:1992/";
        Endpoint.publish(url,new studentService());
        System.out.println(url);
	}
	@Bean
	CommandLineRunner start(StudentRepository studentRepository,
                            RepositoryRestConfiguration restConfiguration,
                            LaboratoryRepository laboratoryRepository
    ){
	    return args -> {
	        restConfiguration.exposeIdsFor(Student.class);
	        Laboratory l1 = laboratoryRepository.save(new Laboratory(null,"Computer Science","contact@gmail.com",null));
	        Laboratory l2 = laboratoryRepository.save(new Laboratory(null,"Biology","contact@gmail.com",null));
            studentRepository.save(new Student(null,"hassan",new Date(),l1));
            studentRepository.save(new Student(null,"lahcen",new Date(),l2));
            studentRepository.save(new Student(null,"saida",new Date(),l2));
            studentRepository.findAll().forEach(st->{System.out.println(st.getName());});
	    };
    }
}
