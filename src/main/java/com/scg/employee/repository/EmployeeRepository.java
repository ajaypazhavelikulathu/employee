package com.scg.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scg.employee.dao.entity.Department;
import com.scg.employee.dao.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstName(String name);
	
	@Query(value="select employees.first_name,department.department_name from department inner join employees on department.department_id=employees.department_id where employees.id=?1",nativeQuery = true)
	//@Query("select r.comment from Review r inner join Employee e on r.employee=e.id  where e.id=?1")
	List<String> getDepartmentByEmployeeById(int id);

}
