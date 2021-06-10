package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobseeker"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="image_id")
    private String imageId;

    @ManyToOne()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobseeker;

    public Image(String original_filename, String url, String imageId) {
    }
}