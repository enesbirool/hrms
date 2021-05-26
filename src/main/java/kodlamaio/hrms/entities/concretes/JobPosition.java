package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_positions" , uniqueConstraints = {@UniqueConstraint(columnNames = {"job_title"})})
public class JobPosition {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name="job_title")
    @NotNull
    private String jobTitle;

}
