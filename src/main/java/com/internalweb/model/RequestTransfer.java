package com.internalweb.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Request_Transfers")
public class RequestTransfer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transfer_ID")
    private Long transferId;
    
    @Column(name = "Request_ID")
    private Long requestId;
    
    @Column(name = "Transferred_By")
    private String transferredBy;
    
    @Column(name = "Received_By")
    private String receivedBy;
    
    @Column(name = "Transfer_Date")
    private Date transferDate;
    
    @Column(name = "Notes")
    private String notes;

	public RequestTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public RequestTransfer(Long transferId, Long requestId, String transferredBy, String receivedBy,
			Date transferDate, String notes) {
		super();
		this.transferId = transferId;
		this.requestId = requestId;
		this.transferredBy = transferredBy;
		this.receivedBy = receivedBy;
		this.transferDate = transferDate;
		this.notes = notes;
	}




	public Long getRequestId() {
		return requestId;
	}




	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}




	public Long getTransferId() {
		return transferId;
	}

	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}

	public String getTransferredBy() {
		return transferredBy;
	}

	public void setTransferredBy(String transferredBy) {
		this.transferredBy = transferredBy;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    
}

