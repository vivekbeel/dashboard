package com.policybazaar.refund.refunddashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policybazaar.refund.refunddashboard.model.RefundProperties;
/**
 * 
 * @author vivek
 *
 */
@Repository
public interface RefundPropertiesRepository extends JpaRepository<RefundProperties, Long>{

	
}
