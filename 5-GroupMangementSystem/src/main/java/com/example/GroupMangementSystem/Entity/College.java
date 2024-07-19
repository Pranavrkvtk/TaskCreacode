package com.example.GroupMangementSystem.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "collegetype")
public class College extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private Institution institution;

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
