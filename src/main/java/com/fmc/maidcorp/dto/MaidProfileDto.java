package com.fmc.maidcorp.dto;

import com.fmc.maidcorp.domain.Address;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.fmc.maidcorp.domain.MaidProfile} entity
 */
@Data
public class MaidProfileDto implements Serializable {
    private final long id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Date dob;
    private final Address address;

    public MaidProfileDto(long id, String firstName, String middleName, String lastName, Date dob, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }
}