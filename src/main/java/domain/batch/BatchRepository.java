package domain.batch;


import infrastructure.stereotypes.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BatchRepository {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    private static final Logger LOG = LoggerFactory.getLogger(BatchRepository.class);

    public List<Batch> getBatches() {
        LOG.info("Get all batches");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Batch> cq = cb.createQuery(Batch.class);
        Root<Batch> root = cq.from(Batch.class);
        CriteriaQuery<Batch> all = cq.select(root);
        TypedQuery<Batch> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Batch getBatchById(final long batchId) {
        LOG.info("Get batch by id: {}", batchId);
        return em.find(Batch.class, batchId);
    }

    public long addBatch(final Batch batch) {
        LOG.info("Add batch");
        em.persist(batch);
        return batch.getId();
    }

    public void updateBatch(final Batch batch) {
        LOG.info("Update batch");
        em.merge(batch);
    }

    public void deleteBatch(final long batchId) {
        LOG.info("Delete batch by id: {}", batchId);
        Batch batch = em.find(Batch.class, batchId);
        em.remove(batch);
    }
}
