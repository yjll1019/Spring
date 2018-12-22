package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Orders;
import net.skhu.model.Pagination;

public interface OredersRepository extends JpaRepository<Orders, Integer>{
	public Page<Orders> findAll(Pageable pageable);
	 public Page<Orders> findByEmployeesId(int employeesId, Pageable pageable);
	   
	public default List<Orders> findAll(Pagination pagination){
		Pageable pageable =  PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                new Sort(Sort.Direction.ASC, "id"));
	     Page<Orders> page = findAll(pageable);
	        pagination.setRecordCount((int)page.getTotalElements());
	        return page.getContent();        		
	}
	
	   public default List<Orders> findByDepartmentId(Pagination pagination) {
	        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
	                                           new Sort(Sort.Direction.ASC, "id"));
	        Page<Orders> page = findByEmployeesId(pagination.getDi(), pageable);
	        pagination.setRecordCount((int)page.getTotalElements());
	        return page.getContent();
	    }
	
}
