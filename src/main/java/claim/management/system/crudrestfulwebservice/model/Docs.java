package claim.management.system.crudrestfulwebservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docs")
public class Docs {

	
	@Id
	private long docId;

	@Column(name = "claim_id")
	private String claimId;
	
	@Column(name = "doc_name")
	private String docName;

	public Docs() {
		super();
	}

	public Docs(long docId, String docName) {
		super();
		this.docId = docId;
		this.docName = docName;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public String toString() {
		return "Docs [docId=" + docId + ", docName=" + docName + "]";
	}

}
