package com.saitej.springormjpa.entities;


import com.saitej.springormjpa.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @Column(name = "phone_no")
    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    @Column(name = "plan_id")
    private Integer planId;


    public static CustomerDTO prepareDTO(Customer customerEntity)
    {
        CustomerDTO custDTO = new CustomerDTO();
        custDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        custDTO.setName(customerEntity.getName());
        custDTO.setGender(customerEntity.getGender());
        custDTO.setAge(customerEntity.getAge());
        custDTO.setAddress(customerEntity.getAddress());
        custDTO.setPlanId(customerEntity.getPlanId());
        return custDTO;

    }
}


