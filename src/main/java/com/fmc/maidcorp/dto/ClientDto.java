package com.fmc.maidcorp.dto;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.maidservices.RegularCleaning;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.fmc.maidcorp.domain.Client} entity
 */
@Data
@AllArgsConstructor
public class ClientDto implements Serializable {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final List<Address> address;
    private final RegularCleaning regularCleaning;
    private final SpringCleaning springCleaning;


}