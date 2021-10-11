package com.policybazaar.refund.refunddashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policybazaar.refund.refunddashboard.DTO.RefundRequestCountAndTxAmountDTO;
import com.policybazaar.refund.refunddashboard.entity.RefundRequest;

@Repository
public interface RefundRequestRepository extends JpaRepository<RefundRequest, Long> {
	
	
	@Query(value = "SELECT m1 FROM RefundRequest m1 LEFT JOIN RefundRequest m2 ON "
			+ "(m1.itemId = m2.itemId and m1.orderNo =m2.orderNo AND m1.id < m2.id)" + " WHERE m2.id IS NULL")
	public List<RefundRequest> getAllRefundRequestList();
	
	@Query(value = "SELECT m1 FROM RefundRequest m1 LEFT JOIN RefundRequest m2 ON "
			+ "(m1.itemId = m2.itemId and m1.orderNo =m2.orderNo AND m1.id < m2.id)" + " WHERE m2.id IS NULL ORDER BY m1.itemId DESC")
	public List<RefundRequest> getSortAllRefundRequestList();

	@Query(value = "SELECT m1 FROM RefundRequest m1 LEFT JOIN RefundRequest m2 ON "
			+ "(m1.itemId = m2.itemId and m1.orderNo =m2.orderNo AND m1.id < m2.id)"
			+ " WHERE m2.id IS NULL and m1.statusCode in(:statusCode)")
	public List<RefundRequest> getStatusWiseRefundRequestList(List<Integer> statusCode);
	
	@Query(value = "SELECT m1 FROM RefundRequest m1 LEFT JOIN RefundRequest m2 ON "
			+ "(m1.itemId = m2.itemId and m1.orderNo =m2.orderNo AND m1.id < m2.id)"
			+ " WHERE m2.id IS NULL and m1.statusCode in(:statusCode) ORDER BY m1.itemId DESC")
	public List<RefundRequest> getSortedStatusWiseRefundRequestList(List<Integer> statusCode);

	@Query(value = "SELECT COUNT(m1.statusCode) as totalCount, SUM(m1.transactionAmount) as totalTxAmount,"
			+ "CASE WHEN m1.statusCode in(:completedStatusCode) THEN sum(m1.transactionAmount) END AS complateTxAmount,"
			+ "CASE WHEN m1.statusCode in(:completedStatusCode) THEN count(m1.statusCode) END AS complateTxCount,"
			+ "CASE WHEN m1.statusCode in(:canceledStatusCode) THEN sum(m1.transactionAmount) END AS cancelTxAmount,"
			+ "CASE WHEN m1.statusCode in(:canceledStatusCode) THEN sum(m1.statusCode) END AS cancelTxCount,"
			+ "CASE WHEN m1.statusCode in(:pendingStatusCode) THEN sum(m1.transactionAmount) END AS pendingTxAmount,"
			+ "CASE WHEN m1.statusCode in(:pendingStatusCode) THEN sum(m1.statusCode) END AS pendingTxCount "
			+ "FROM RefundRequest m1 LEFT JOIN RefundRequest m2 ON "
			+ "(m1.itemId = m2.itemId and m1.orderNo =m2.orderNo AND m1.id < m2.id) WHERE m2.id IS NULL GROUP BY m1.statusCode")
	public List<RefundRequestCountAndTxAmountDTO> getStatusWiseRefundRequestCountAndTxAmount(List<Integer> completedStatusCode,
			List<Integer> canceledStatusCode, List<Integer> pendingStatusCode);
	
	
}
