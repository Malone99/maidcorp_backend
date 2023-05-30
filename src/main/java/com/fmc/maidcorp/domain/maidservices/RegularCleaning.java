package com.fmc.maidcorp.domain.maidservices;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Entity
public class RegularCleaning implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String description;
    @Column
    private double fee;

    public RegularCleaning(String description, double fee) {
        this.description = description;
        this.fee = fee;
    }
}
