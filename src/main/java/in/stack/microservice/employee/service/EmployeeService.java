package in.stack.microservice.employee.service;

import in.stack.microservice.employee.model.Employee;
import in.stack.microservice.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    // Displaying Employee Details By Employee ID
    public Optional<Employee> findById(int id) {
        log.info("Inside EmployeeService # findById() Method");
        Optional<Employee> emp = empRepo.findById(id);
        return emp;
    }
    // Displaying All Employee Details
    public List<Employee> findAll() {
        log.info("Inside EmployeeService # findAll() Method");
        return empRepo.findAll();
    }

    // Updating Employee Details (Sending Employee Details With ID Which Is already Present In Record)
    public Employee UpdateEmployee(Employee emp) {
        log.info("Inside EmployeeService # UpdateEmployee() Method");
        boolean b = empRepo.existsById(emp.getId());
        Employee employee = null;
        if (b) {
            employee = empRepo.getById(emp.getId());
            employee = empRepo.saveAndFlush(emp);
        }
        return employee;
    }
    // Deleting Employee Record BY Employee ID
    public Boolean deleteEmployee(int id){
        log.info("Inside EmployeeService # deleteEmployee() Method");
        boolean b = empRepo.existsById(id);
        if (b){
            empRepo.deleteById(id);
        }
        return b;
    }

    // Adding New Enployee Details In Record
    public Employee save(Employee employee) {
        log.info("Inside EmployeeService # save() Method");
        return empRepo.save(employee);
    }
}
