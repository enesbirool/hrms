package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobseekers" , uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
public class JobSeeker extends User{

    @Id
    @Column(name="jobseeker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name="first_name")
    @NotNull
    private String firstName;

    @Column(name="last_name")
    @NotNull
    private String lastName;

    @Column(name="identity_number")
    @NotNull
    private String identityNumber;

    @Column(name="birth_date")
    @NotNull
    private LocalDate birthDate;

    @Column(name="jobseeker_description")
    private String description;

    @OneToMany(mappedBy = "jobseeker")
    private List<Image> images;

}