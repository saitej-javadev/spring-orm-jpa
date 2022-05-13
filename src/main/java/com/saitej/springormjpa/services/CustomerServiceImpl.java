package com.saitej.springormjpa.services;

import com.saitej.springormjpa.dto.CustomerDTO;
import com.saitej.springormjpa.entities.Customer;
import com.saitej.springormjpa.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void insert(CustomerDTO customer) {
        customerRepository.insert(CustomerDTO.prepareCustomerEntity(customer));
    }
    @Override
    public int remove(Long phoneNo) {
        return  customerRepository.remove(phoneNo);

    }
    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> custList = new ArrayList<>();
        List <Customer> custEntityList = customerRepository.getAll();
        for (Customer customerEntity : custEntityList) {
            CustomerDTO custDTO = Customer.prepareDTO(customerEntity);
            custList.add(custDTO);
        }

        return custList;

    }
    @Override
    public void update(Long phoneNo, String address) {
        customerRepository.update(phoneNo, address);

    }

}
