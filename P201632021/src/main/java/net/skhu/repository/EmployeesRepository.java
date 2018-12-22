package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

}
