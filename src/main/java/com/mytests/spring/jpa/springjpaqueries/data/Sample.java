package com.mytests.spring.jpa.springjpaqueries.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sample", schema = "jbtests")
@NamedNativeQueries({
         @NamedNativeQuery(name = "Sample.nativeSampleByColor",
                 query = "select * from sample where color = :?")})
public class Sample {
    @Id
    @GeneratedValue
    private Long id;
    @Basic
    @Column(name = "version")
    private Integer version;
    @Basic
    @Column(name = "sample")
    private String sample;
    @Basic
    @Column(name = "color")
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample1 = (Sample) o;
        return Objects.equals(id, sample1.id) && Objects.equals(version, sample1.version) && Objects.equals(sample,
                sample1.sample) && Objects.equals(color, sample1.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, sample, color);
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", version=" + version +
                ", sample='" + sample + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
