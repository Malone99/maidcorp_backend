package com.fmc.maidcorp.dto;

import com.fmc.maidcorp.domain.Address;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final long id;
    private final String street;
    private final String city;
    private final String province;

    public AddressDto(long id, String street, String city, String province) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.province = province;
    }
}