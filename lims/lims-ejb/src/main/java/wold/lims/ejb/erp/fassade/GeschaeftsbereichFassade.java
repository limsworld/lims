 package wold.lims.ejb.erp.fassade;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.base.model.entities.Geschaeftsbereich;
import wold.lims.ejb.erp.beans.GeschaeftsbereichCreate;
import wold.lims.ejb.erp.model.constante.PartnerbeziehungstypEnum;
import wold.lims.ejb.erp.model.entities.Adresse;
import wold.lims.ejb.erp.model.entities.Kontakt;
import wold.lims.ejb.erp.model.entities.Partner;
import wold.lims.ejb.erp.model.entities.Partnerbeziehung;
import wold.lims.ejb.erp.model.entities.Partnergeschaeftsbereich;
import wold.lims.ejb.erp.model.entities.Person;

@Stateless
public class GeschaeftsbereichFassade {

	@PersistenceContext
	private EntityManager em;

	@Inject
	ErpStammdatenFassade stammdaten;
	
	public void createGeschaeftsbereich(GeschaeftsbereichCreate geschaeftsbereichCreate)
		throws ParseException {

		Geschaeftsbereich geschaeftsbereich = new Geschaeftsbereich()
			.setName(geschaeftsbereichCreate.getFirma())
			.setBezeichnung(geschaeftsbereichCreate.getFirma());
		em.persist(geschaeftsbereich);

		Partner partner = new Partner();
		em.persist(partner);

		Adresse adresse = new Adresse()
			.setPartner(partner)
			.setFirma(geschaeftsbereichCreate.getFirma())
			.setStrasse(geschaeftsbereichCreate.getStrasse())
			.setPlz(geschaeftsbereichCreate.getPlz())
			.setOrt(geschaeftsbereichCreate.getOrt());
		em.persist(adresse);
		
		Person person = new Person()
			.setNachname(geschaeftsbereichCreate.getNachname())
			.setVorname(geschaeftsbereichCreate.getVorname())
			.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse("10.10.1960"))
			.setGeschlecht(stammdaten.getGeschlecht(
				geschaeftsbereichCreate.getGeschlecht()));
		em.persist(person);

		Kontakt kontakt = new Kontakt()
			.setGeschaeftsbereich(geschaeftsbereich)
			.setAdresse(adresse)
			.setPerson(person)
			.setFunktion(geschaeftsbereichCreate.getFunktion());
		em.persist(kontakt);

		Partnergeschaeftsbereich partnerdivision = new Partnergeschaeftsbereich()
			.setGeschaeftsbereich(geschaeftsbereich)
			.setPartner(partner);
		em.persist(partnerdivision);

		Partnerbeziehung partnerbeziehung = new Partnerbeziehung()
			.setPartner(partner).setPartner2(partner)
			.setPartnerbeziehungstyp(
				stammdaten.getPartnerbeziehungstyp(
					PartnerbeziehungstypEnum.GESCHAEFTSBEREICH));
		em.persist(partnerbeziehung);
	}

}
