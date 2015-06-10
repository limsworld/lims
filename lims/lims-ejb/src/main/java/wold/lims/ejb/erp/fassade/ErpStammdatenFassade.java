 package wold.lims.ejb.erp.fassade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.erp.model.constante.PartnerbeziehungstypEnum;
import wold.lims.ejb.erp.model.entities.Geschlecht;
import wold.lims.ejb.erp.model.entities.Partnerbeziehungstyp;
import wold.lims.ejb.erp.model.entities.Vorgangsstatus;
import wold.lims.ejb.erp.model.entities.Vorgangstyp;

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

	public Geschlecht getGeschlecht(String geschlecht) {
		return em.createNamedQuery(Geschlecht.class
			.getSimpleName(), Geschlecht.class)
			.setParameter("name", geschlecht).getSingleResult();
	}

	public Vorgangsstatus getVorgangsstatus(String vorgangsstatus) {
		return em.createNamedQuery(Vorgangsstatus.class
			.getSimpleName(), Vorgangsstatus.class)
			.setParameter("name", vorgangsstatus).getSingleResult();
	}

	public Vorgangstyp getVorgangstyp(String vorgangstyp) {
		return em.createNamedQuery(Vorgangstyp.class
			.getSimpleName(), Vorgangstyp.class)
			.setParameter("name", vorgangstyp).getSingleResult();
	}

}
