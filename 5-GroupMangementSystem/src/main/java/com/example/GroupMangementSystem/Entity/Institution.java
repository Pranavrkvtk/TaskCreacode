package com.example.GroupMangementSystem.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "institutiontable")
public class Institution extends BaseEntity {

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<College> colleges;

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }
}
