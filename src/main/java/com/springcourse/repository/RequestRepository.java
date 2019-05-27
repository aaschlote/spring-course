package com.springcourse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{
		
	public List<Request> findAllByOwnerId(Long id);
	
	public Page<Request> findAllByOwnerId(Long id, Pageable pageable);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update request set state = ?2 where id = ?1")
	public int updateStatus(Long id, RequestState state);

}
