package com.springmvc.springmvcrestclient;

import com.springmvc.springmvcrestclient.entities.Employee;
import com.springmvc.springmvcrestclient.service.ConsumerRESTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpServerErrorException;

@SpringBootApplication
public class SpringMvcRestClientApplication {
    static Logger logger = LoggerFactory.getLogger(SpringMvcRestClientApplication.class);


    public static void main(String[] args) {
        ConsumerRESTService consumerRESTService = SpringApplication.run(SpringMvcRestClientApplication.class, args)
                .getBean(ConsumerRESTService.class);
        try {
            logger.info("All employees");
            logger.info(consumerRESTService.getAllEmployees().toString());

            logger.info("Get employee by id = 1");
            logger.info(consumerRESTService.getEmployeeById(1).toString());

            logger.info("Delete employee by id = 1");
            consumerRESTService.deleteEmployeeById(1);

            Employee employee = new Employee(1, "Name", "Surname", 123);
            consumerRESTService.addEmployee(employee);
            logger.info("Added new employee:" + employee.toString());

            logger.info("Get employee by id = 1");
            logger.info(consumerRESTService.getEmployeeById(1).toString());


            logger.info("Overall employees");
            logger.info(consumerRESTService.getAllEmployees().toString());
        } catch (HttpServerErrorException e) {
            logger.error(e.getMessage());
        }


    }
}
