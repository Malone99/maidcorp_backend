package com.fmc.maidcorp.domain;

import com.fmc.maidcorp.domain.maidservices.RegularCleaning;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private List<Address> address = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_regular_cleaning_id")
    private RegularCleaning regularCleaning;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_spring_cleaning_id")
    @Nullable
    private SpringCleaning springCleaning;



}
