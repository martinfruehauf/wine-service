package application;

import java.util.Arrays;
import java.util.Objects;

public class BaseBatchDTO {

    private String name;

    private long year;

    private String yeast;

    private String fruit;

    private String[] originCoordinates;

    private String originDescription;

    private String productionDate;

    private String comment;

    BaseBatchDTO() {}

    public BaseBatchDTO(final String name, final long year, final String yeast, final String fruit, final String[] originCoordinates, final String originDescription, final String productionDate, final String comment) {
        this.name = name;
        this.year = year;
        this.yeast = yeast;
        this.fruit = fruit;
        this.originCoordinates = originCoordinates;
        this.originDescription = originDescription;
        this.productionDate = productionDate;
        this.comment = comment;
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

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
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
        return "BaseBatchDTO{" +
                "name='" + name + '\'' +
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
        BaseBatchDTO that = (BaseBatchDTO) o;
        return year == that.year &&
                Objects.equals(name, that.name) &&
                Objects.equals(yeast, that.yeast) &&
                Objects.equals(fruit, that.fruit) &&
                Arrays.equals(originCoordinates, that.originCoordinates) &&
                Objects.equals(originDescription, that.originDescription) &&
                Objects.equals(productionDate, that.productionDate) &&
                Objects.equals(comment, that.comment);
    }
}
