package com.code.employee.repository;
//used for CRUD operations
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Department;
import com.code.employee.entity.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	//Derived query methods
	//Custom JPQL query to find a department by name
	@Query("SELECT d FROM Department d where d.name=:name")
	//SELECT should be on caps
	Department findByNamedUsingJPQL(@Param("name")String name);
	
	//Custom native SQL query to find all departments with a specific name pattern
	//by default nativeQuery=false so when we want to use SQL query native query set to true
	@Query(value="SELECT * FROM departments d WHERE d.name LIKE %:pattern%",nativeQuery=true)
	//namedquery=
	List<Department> findByNamePattern(@Param("pattern")String pattern);
}
