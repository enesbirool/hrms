package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobseekers_activations")
public class JobSeekerActivation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="jobseeker_id")
    private int jobseekerId;

    @Column(name = "is_email_confirmed")
    private boolean isEmailConfirm = false;

    @Column(name = "is_mernis_valid")
    private boolean isMernis = false;


}