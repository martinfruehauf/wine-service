package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "tab_batch")
public class Batch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    private long id;

    @Column(name = "col_name")
    private String name;

    @Column(name = "col_year")
    private long year;

    @Column(name = "col_yeast")
    private String yeast;

    @Column(name = "col_fruit")
    private String fruit;

    @Column(name = "col_coord")
    private String[] originCoordinates;

    @Column(name = "col_odesc")
    private String originDescription;

    @Column(name = "col_productdate")
    private LocalDateTime productionDate;

    @Column(name = "col_comment")
    private String comment;

    public Batch () {}

    public Batch(final long id, final String name, final long year, final String yeast, final String fruit, final String[] originCoordinates, final String originDescription, final LocalDateTime productionDate, final String comment) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.yeast = yeast;
        this.fruit = fruit;
        this.originCoordinates = originCoordinates;
        this.originDescription = originDescription;
        this.productionDate = productionDate;
        this.comment = comment;
    }

    //mit baseBatchDTO

    //mit id und baseBatchDTO


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String[] getOriginCoordinates() {
        return originCoordinates;
    }

    public void setOriginCoordinates(String[] originCoordinates) {
        this.originCoordinates = originCoordinates;
    }

    public String getOriginDescription() {
        return originDescription;
    }

    public void setOriginDescription(String originDescription) {
        this.originDescription = originDescription;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", yeast='" + yeast + '\'' +
                ", fruit='" + fruit + '\'' +
                ", originCoordinates=" + Arrays.toString(originCoordinates) +
                ", originDescription='" + originDescription + '\'' +
                ", productionDate=" + productionDate +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return id == batch.id &&
                year == batch.year &&
                Objects.equals(name, batch.name) &&
                Objects.equals(yeast, batch.yeast) &&
                Objects.equals(fruit, batch.fruit) &&
                Arrays.equals(originCoordinates, batch.originCoordinates) &&
                Objects.equals(originDescription, batch.originDescription) &&
                Objects.equals(productionDate, batch.productionDate) &&
                Objects.equals(comment, batch.comment);
    }

}
