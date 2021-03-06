package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers_activations")
public class EmployerActivation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="employer_id")
    private int employerId;

    @Column(name="is_email_confirmed")
    private boolean isEmail = false;

    @Column(name="is_employer_activated_from_admin")
    private boolean isActiveFromAdmin = false;

}
