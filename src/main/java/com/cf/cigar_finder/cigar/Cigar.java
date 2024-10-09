package com.cf.cigar_finder.cigar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cigar_table")
public class Cigar {
    @Id
    @Column(name="gse", unique = true)
    private Integer gse;
    private String name;
    private String brand;
    private String size;
    private String shape;
    private String origin;
    private String wrapper;
    private String binder;
    private String filler;
    private String flavor;
    private String body;
    private String notes;
    private String pairings;
    private Integer burntime;
    private String similar_cigars;

    public Cigar() {
    }

    public Cigar(Integer gse, String name, String brand, String size, String shape, String origin, String wrapper, String binder, String filler, String flavor, String body, String notes, String pairings, Integer burntime, String similar_cigars) {
        this.gse = gse;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.shape = shape;
        this.origin = origin;
        this.wrapper = wrapper;
        this.binder = binder;
        this.filler = filler;
        this.flavor = flavor;
        this.body = body;
        this.notes = notes;
        this.pairings = pairings;
        this.burntime = burntime;
        this.similar_cigars = similar_cigars;
    }

    public Cigar(Integer gse) {
        this.gse = gse;
    }

    public Integer getGse() {
        return gse;
    }

    public void setGse(Integer gse) {
        this.gse = gse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWrapper() {
        return wrapper;
    }

    public void setWrapper(String wrapper) {
        this.wrapper = wrapper;
    }

    public String getBinder() {
        return binder;
    }

    public void setBinder(String binder) {
        this.binder = binder;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPairings() {
        return pairings;
    }

    public void setPairings(String pairings) {
        this.pairings = pairings;
    }

    public Integer getBurntime() {
        return burntime;
    }

    public void setBurntime(Integer burntime) {
        this.burntime = burntime;
    }

    public String getSimilar_cigars() {
        return similar_cigars;
    }

    public void setSimilar_cigars(String similar_cigars) {
        this.similar_cigars = similar_cigars;
    }
}
