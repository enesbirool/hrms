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
    @Column(name="id")
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

    @Column(name="university")
    private String university;

    @Column(name="starting_year_of_university")
    private LocalDate startingYearOfUniversity;

    @Column(name="graduation_year_of_university")
    private LocalDate graduationYearOfUniversity;

    @Column(name="job_experience")
    private String jobExperience;

    @Column(name="experience_starting_date")
    private LocalDate experienceStartingDate;

    @Column(name="experience_end_date")
    private LocalDate experienceEndDate;

    @Column(name="known_language")
    private String knownLanguage;

    @Column(name="image_name")
    private String imageName;

    @Column(name="github_link")
    private String githubLink;

    @Column(name="linkedin_link")
    private String linkedInLink;

    @Column(name="cover_letter")
    private String coverLetter;

    @Column(name="known_technology")
    private String knownTechnology;

    @OneToMany(mappedBy = "jobseeker")
    private List<Image> images;

}