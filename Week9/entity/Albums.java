package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "albums")
@Entity
@Data
public class Albums implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Column(name = "release_year")
    private Integer releaseYear;

    
}