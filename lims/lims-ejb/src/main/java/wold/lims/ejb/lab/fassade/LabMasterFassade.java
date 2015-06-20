 package wold.lims.ejb.lab.fassade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.lab.model.entities.AnalysisRequestState;

@Stateless
public class LabMasterFassade {

	@PersistenceContext
	private EntityManager em;

	public AnalysisRequestState getAnalysisRequestState(String analysisRequestState) {
		return em.createNamedQuery(AnalysisRequestState.class
			.getSimpleName(), AnalysisRequestState.class)
				.setParameter("name", analysisRequestState).getSingleResult();
	}

}
