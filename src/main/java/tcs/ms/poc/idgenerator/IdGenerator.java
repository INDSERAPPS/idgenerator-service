package tcs.ms.poc.idgenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.annotation.Nullable;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "IDGENERATOR")
@NamedQuery(name = "IdGenerator.findById", query = "select i from IdGenerator i where i.uniqueId=:id")
public class IdGenerator extends BaseEntity {
	
	@Id
	@Column(name = "UNIQUE_ID")
	private String uniqueId ;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	@Nullable
	public static IdGenerator findById(String id)
	{
		return em().find(IdGenerator.class, id);
	}

}
