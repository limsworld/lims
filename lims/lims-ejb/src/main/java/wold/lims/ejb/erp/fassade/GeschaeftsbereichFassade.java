 package wold.lims.ejb.erp.fassade;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.erp.beans.GeschaeftsbereichCreate;
import wold.lims.ejb.erp.model.constante.EinheitengruppeEnum;
import wold.lims.ejb.erp.model.constante.PartnerbeziehungstypEnum;
import wold.lims.ejb.erp.model.entities.Adresse;
import wold.lims.ejb.erp.model.entities.Geschaeftsbereich;
import wold.lims.ejb.erp.model.entities.Kontakt;
import wold.lims.ejb.erp.model.entities.Partner;
import wold.lims.ejb.erp.model.entities.Partnerbeziehung;
import wold.lims.ejb.erp.model.entities.Person;
import wold.lims.ejb.labor.model.entities.Laborkonfiguration;

@Stateless
public class GeschaeftsbereichFassade {

	@PersistenceContext
	private EntityManager em;

	@Inject
	ErpStammdatenFassade stammdaten;
	
	public Geschaeftsbereich geschaeftsbereichHinzufuegen(String name, String bereichsname, Geschaeftsbereich geschaeftsbereichUeber) {

		Geschaeftsbereich geschaeftsbereich = new Geschaeftsbereich()
			.setGeschaeftsbereich(geschaeftsbereichUeber)
			.setName(name)
			.setBezeichnung(bereichsname);
		em.persist(geschaeftsbereich);

		
		
//		Adresse adresse = new Adresse()
//		.setPartner(partner)
//		.setFirma(geschaeftsbereichCreate.getFirma())
//		.setStrasse(geschaeftsbereichCreate.getStrasse())
//		.setPlz(geschaeftsbereichCreate.getPlz())
//		.setOrt(geschaeftsbereichCreate.getOrt());
//	em.persist(adresse);

		
		
		return null;
	}
	
	
	public Geschaeftsbereich createGeschaeftsbereich(GeschaeftsbereichCreate geschaeftsbereichCreate)
		throws ParseException {

		Partner partner = new Partner();
		em.persist(partner);

		Geschaeftsbereich geschaeftsbereich = new Geschaeftsbereich()
			.setPartner(partner)
			.setName(geschaeftsbereichCreate.getName())
			.setBezeichnung(geschaeftsbereichCreate.getFirma());
		em.persist(geschaeftsbereich);
		
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

		Partnerbeziehung partnerbeziehung = new Partnerbeziehung()
			.setPartner(partner).setPartner2(partner)
			.setPartnerbeziehungstyp(
				stammdaten.getPartnerbeziehungstyp(
					PartnerbeziehungstypEnum.GESCHAEFTSBEREICH));
		em.persist(partnerbeziehung);

		if (geschaeftsbereichCreate.isLabor()) {
			Laborkonfiguration laborkonfiguration = new Laborkonfiguration()
				.setGeschaeftsbereich(geschaeftsbereich)
				.setEinheitengruppe(stammdaten.getEinheitengruppe(EinheitengruppeEnum.LABOR.name()));
			em.persist(laborkonfiguration);
		}

		return geschaeftsbereich;

	}

}
