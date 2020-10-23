package iga.springBoot.Projection;

import iga.springBoot.Model.Laboratory;
import iga.springBoot.Model.Student;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types = Student.class)
interface StudentProjection{
    public String getBirthDate();
    public String getName();
    public Laboratory getLabotory();
}
