package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Department;

//이 인터페이스를 구현한 클래스는 spring jpa가 자동으로 구현해줌.
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
