package com.saitej.springormjpa.dto;

import com.saitej.springormjpa.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    public static Customer prepareCustomerEntity(CustomerDTO customerDTO)
    {
        Customer customerEntity = new Customer();
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPlanId(customerDTO.getPlanId());
        return customerEntity;

    }

}
