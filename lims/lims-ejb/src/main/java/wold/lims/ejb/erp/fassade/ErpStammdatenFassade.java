 package wold.lims.ejb.erp.fassade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.erp.model.constante.PartnerbeziehungstypEnum;
import wold.lims.ejb.erp.model.entities.Geschlecht;
import wold.lims.ejb.erp.model.entities.Partnerbeziehungstyp;

@Stateless
public class ErpStammdatenFassade {

	@PersistenceContext
	private EntityManager em;

	public Partnerbeziehungstyp getPartnerbeziehungstyp(
		PartnerbeziehungstypEnum partnerbeziehungstypEnum) {
		return em.createNamedQuery(
			Partnerbeziehungstyp.class
				.getSimpleName(), Partnerbeziehungstyp.class)
				.setParameter("name", 
					partnerbeziehungstypEnum.name())
					.getSingleResult();
	}

	public Geschlecht getGeschlecht(
		String geschlecht) {
		return em.createNamedQuery(Geschlecht.class
			.getSimpleName(), Geschlecht.class)
			.setParameter("name", 
					geschlecht)
			.getSingleResult();
		}

}
