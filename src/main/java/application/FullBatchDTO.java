package application;

import domain.Batch;

import java.util.Arrays;
import java.util.Objects;

public class FullBatchDTO {

    private long id;

    private String name;

    private long year;

    private String yeast;

    private String fruit;

    private String[] originCoordinates;

    private String originDescription;

    private String productionDate;

    private String comment;

    public FullBatchDTO () {}

    public FullBatchDTO(Batch batch) {
        this.id = batch.getId();
        this.name = batch.getName();
        this.year = batch.getYear();
        this.yeast = batch.getYeast();
        this.fruit = batch.getFruit();
        this.originCoordinates = batch.getOriginCoordinates();
        this.originDescription = batch.getOriginDescription();
        this.productionDate = batch.getProductionDate().toString();
        this.comment = batch.getComment();
    }

    public FullBatchDTO(final long id, final String name, final long year, final String yeast, final String fruit, final String[] originCoordinates, final String originDescription, final String productionDate, final String comment) {
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

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(final long year) {
        this.year = year;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(final String yeast) {
        this.yeast = yeast;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(final String fruit) {
        this.fruit = fruit;
    }

    public String[] getOriginCoordinates() {
        return originCoordinates;
    }

    public void setOriginCoordinates(final String[] originCoordinates) {
        this.originCoordinates = originCoordinates;
    }

    public String getOriginDescription() {
        return originDescription;
    }

    public void setOriginDescription(final String originDescription) {
        this.originDescription = originDescription;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(final String productionDate) {
        this.productionDate = productionDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FullBatchDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", yeast='" + yeast + '\'' +
                ", fruit='" + fruit + '\'' +
                ", originCoordinates=" + Arrays.toString(originCoordinates) +
                ", originDescription='" + originDescription + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullBatchDTO that = (FullBatchDTO) o;
        return id == that.id &&
                year == that.year &&
                Objects.equals(name, that.name) &&
                Objects.equals(yeast, that.yeast) &&
                Objects.equals(fruit, that.fruit) &&
                Arrays.equals(originCoordinates, that.originCoordinates) &&
                Objects.equals(originDescription, that.originDescription) &&
                Objects.equals(productionDate, that.productionDate) &&
                Objects.equals(comment, that.comment);
    }

}
