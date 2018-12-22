package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Orders;
import net.skhu.model.Option;
import net.skhu.model.Pagination2;

public interface OredersRepository2 extends JpaRepository<Orders, Integer> {
	Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "ship_name"), new Option(2, "ship_city"), new Option(3, "ship_id") };
	Option[] orderBy = { new Option(0, "최근 글"), new Option(1, "오래된 글")};

	Sort[] sort = { new Sort(Sort.Direction.DESC, "id"), new Sort(Sort.Direction.ASC, "id")};

    public default List<Orders> findAll(Pagination2 pagination) {
    	 Pageable pageable = 
                 PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
    	Page<Orders> page;
        String searchText = pagination.getSt();
        switch (pagination.getSb()) {
        case 1: page = this.findByShipNameContains(searchText, pageable); break;
        case 2: page = this.findByShipCityContains(searchText, pageable); break;
        case 3: page = this.findByShippersId(Integer.parseInt(searchText), pageable); break;
        default: page = this.findAll(pageable);
        }
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
    
    public Page<Orders> findByShipNameContains(String name, Pageable pageable);
    public Page<Orders> findByShipCityContains(String name, Pageable pageable);
    public Page<Orders> findByShippersId(int name, Pageable pageable);
    
}
