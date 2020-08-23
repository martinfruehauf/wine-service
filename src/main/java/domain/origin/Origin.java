package domain.origin;

import domain.batch.Batch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tab_origin")
public class Origin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    private long id;

    @ManyToOne
    private Batch batch;

    @Column(name = "col_coord")
    private String coordinates;

    @Column(name = "col_description")
    private String description;

    public Origin() {

    }

    // weitere constructors


    public Origin(final long id, final Batch batch, final String coordinates, final String description) {
        this.id = id;
        this.batch = batch;
        this.coordinates = coordinates;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(final Batch batch) {
        this.batch = batch;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(final String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "id=" + id +
                ", batch=" + batch +
                ", coordinates='" + coordinates + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origin origin = (Origin) o;
        return id == origin.id &&
                Objects.equals(batch, origin.batch) &&
                Objects.equals(coordinates, origin.coordinates) &&
                Objects.equals(description, origin.description);
    }

}
