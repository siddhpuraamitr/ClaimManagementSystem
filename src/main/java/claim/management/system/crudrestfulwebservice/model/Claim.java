package claim.management.system.crudrestfulwebservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long claimId;

	@Column(name = "amount")
	private int amount;

	@Column(name = "policy_number")
	private long policyNumber;

	@Column(name = "date_created")
	private String dateCreated;

	@Column(name = "username")
	private String userName;

	
//	@Column(name = "documents")
//	private List<Docs> docs;

	@Column(name = "claim_number")
	private String claimNumber;

	public Claim() {
		super();
	}

	public Claim(long claimId, int amount, long policyNumber, String dateCreated, String userName,
			ArrayList<Docs> docs) {
		super();
		this.claimId = claimId;
		this.amount = amount;
		this.policyNumber = policyNumber;
		this.dateCreated = dateCreated;
		this.userName = userName;
//		this.docs = docs;
		this.claimNumber = "BB-" + policyNumber;
	}

	public String getClaimNumber() {
		return "BB-" +policyNumber;
	}

//	public void setClaimNumber(String claimNumber) {
//		this.claimNumber = claimNumber;
//	}

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public List<Docs> getDocs() {
//		return docs;
//	}

//	public void setDocs(List<Docs> docs) {
//		this.docs = docs;
//	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", amount=" + amount + ", policyNumber=" + policyNumber + ", dateCreated="
				+ dateCreated + ", userName=" + userName + ", docs=" + "]";
	}

}
