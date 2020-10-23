package iga.springBoot.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2,max=20)
    private String name;
    private String contact;
    @OneToMany(mappedBy = "laboratory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Student> students;
}