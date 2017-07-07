package tcs.ms.poc.idgenerator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InsertUniqueIdService {
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private void injectPersistenceContext() {
		BaseEntity.setEntityManager(entityManager);
	}
	
	public void insertUniqueId(String id)
	{
		injectPersistenceContext() ;
		IdGenerator idGen = new IdGenerator() ;
		idGen.setUniqueId(id);
		idGen.persist() ;
		
	}

	public IdGenerator findById(String uniqueId) {
		
		injectPersistenceContext() ;
		return IdGenerator.findById(uniqueId) ;
	}

}
