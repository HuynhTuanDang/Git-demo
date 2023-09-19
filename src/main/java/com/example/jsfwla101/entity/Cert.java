package com.example.jsfwla101.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cert {
    @Id
    private String certId;

    private String certName;

    private float cost;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @Override
    public String toString() {
        return "Cert{" +
                "certId='" + certId + '\'' +
                ", certName='" + certName + '\'' +
                ", cost=" + cost +
                ", category=" + category +
                '}';
    }
}
