package com.springmvc.springmvcrestclient.service;

import com.springmvc.springmvcrestclient.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ConsumerRESTService {
    private static RestTemplate restTemplate = new RestTemplate();
    static final String URL_EMPLOYEES = "http://localhost:8081/employee/";

    public void addEmployee(@RequestBody Employee employee){
        restTemplate.postForLocation(URL_EMPLOYEES, employee);
    }

    public List<Employee> getAllEmployees(){
        return Arrays.asList(restTemplate.getForObject(URL_EMPLOYEES + "all", Employee[].class));
    }

    public Employee getEmployeeById(int id){
        return restTemplate.getForObject(URL_EMPLOYEES + id, Employee.class);
    }

    public void updateEmployee(@RequestBody Employee employee){
        restTemplate.put(URL_EMPLOYEES, employee);
    }

    public void deleteEmployeeById(int id){
        restTemplate.delete(URL_EMPLOYEES + id);
    }
}
