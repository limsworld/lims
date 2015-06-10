package wold.lims.ejb.base.util;

import java.text.ParseException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wold.lims.ejb.erp.beans.GeschaeftsbereichCreate;
import wold.lims.ejb.erp.fassade.GeschaeftsbereichFassade;
import wold.lims.ejb.erp.model.constante.EinheitEnum;
import wold.lims.ejb.erp.model.constante.EinheitengruppeEnum;
import wold.lims.ejb.erp.model.constante.GeschlechtEnum;
import wold.lims.ejb.erp.model.constante.PartnerbeziehungstypEnum;
import wold.lims.ejb.erp.model.constante.VorgangsstatusEnum;
import wold.lims.ejb.erp.model.constante.VorgangstypEnum;
import wold.lims.ejb.erp.model.entities.Einheit;
import wold.lims.ejb.erp.model.entities.Einheitengruppe;
import wold.lims.ejb.erp.model.entities.Geschlecht;
import wold.lims.ejb.erp.model.entities.Partnerbeziehungstyp;
import wold.lims.ejb.erp.model.entities.Vorgangsstatus;
import wold.lims.ejb.erp.model.entities.Vorgangstyp;

@Singleton
@Startup
public class OnStartUp {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private GeschaeftsbereichFassade geschaeftsbereichFassade;

	@PostConstruct
	private void postConstruct() throws ParseException {

		stammdaten();

		//testdaten();
		
		geschaeftsbereichFassade.createGeschaeftsbereich(new GeschaeftsbereichCreate()
			.setName("LABTECHNOLOGIE AG")
			.setFirma("Labtechnologie AG")
			.setStrasse("Zürcherstr. 555")
			.setPlz("8003")
			.setOrt("Zürich")
			.setNachname("Bussinger")
			.setVorname("Fabian")
			.setGeschlecht(GeschlechtEnum.MANN.name())
			.setGeburtstag("10.10.1960")
			.setFunktion("Geschäftsführer")
			.setEmail("fabian.bussinger@labtechnologiesag.ch")
			.setTelefon("+41 43 387 99 98")
			.setFax("+41 43 387 99 98")
			.setWebseite("labtechnologiesag.ch/zuerich")
			.setLabor(true)
		);


//		Domain systemDomain = new Domain()
//			.setSystem(true)
//			.setName(DomainConstant.INFORMATIK.name())
//			.setBezeichnung("de=lims|en=lims")
//			.setEntwicklung("lims.world.local:8080")
//			.setTest("lims.world.local:8080")
//			.setProduktion("lims.world.local:8080");
//		em.persist(systemDomain);
//
//		Division informatikGeschaeftseinheit = new Division()
//			.setSystem(true)
//			.setName(GeschaeftseinheitConstant.INFORMATIK.name())
//			.setBezeichnung("de=Informatik|en=Informatik");
//		em.persist(informatikGeschaeftseinheit);
//
//		Division hauptsitzGeschaeftseinheit = new Division()
//			.setSystem(true)
//			.setName(GeschaeftseinheitConstant.HAUPTSITZ.name())
//			.setBezeichnung("de=Hauptsitz|en=Head Office");
//		em.persist(hauptsitzGeschaeftseinheit);
//
//		Division filliale1Geschaeftseinheit = new Division()
//			.setName("FILIALE_1")
//			.setBezeichnung("de=Filliale 1|en=Branch 1");
//		em.persist(filliale1Geschaeftseinheit);
//
//		User administrator = new User()
//			.setSystem(true)
//			.setName(UserConstant.ADMIN.name())
//			.setPasswort("limsadmin321")
//			.setEmail("admin@lims.world");
//		em.persist(administrator);
//		
//		User anonymouse = new User()
//			.setSystem(true)
//			.setAktiviert(true)
//			.setName(UserConstant.ANONYMOUSE.name())
//			.setPasswort("none")
//			.setEmail("anonymous@lims.world");
//		em.persist(anonymouse);
//
//		User labormitarbeiter = new User()
//			.setName("meierhans")
//			.setPasswort("meierpassword")
//			.setEmail("meierhand@lims.world");
//		em.persist(labormitarbeiter);
//
//		Rolle adminRolle = new Rolle()
//			.setSystem(true)
//			.setName(RolleConstant.ADMIN.name())
//			.setBezeichnung("de=Administrator|en=Administrator");
//		em.persist(adminRolle);
//
//		Rolle anonymousRolle = new Rolle()
//			.setSystem(true)
//			.setName(RolleConstant.ANONYMOUSE.name())
//			.setBezeichnung("de=Anonymer Benutzer|en=Anonymouse");
//		em.persist(anonymousRolle);
//
//		Rolle superuserRolle = new Rolle()
//			.setSystem(true)
//			.setName(RolleConstant.SUPERUSER.name())
//			.setBezeichnung("de=Hauptadministrator|en=Superuser");
//		em.persist(superuserRolle);

//		administrator
//			.addGeschaeftseinheit(informatikGeschaeftseinheit)
//			.addRolle(anonymousRolle)
//			.setRolle(adminRolle)
//			.setGeschaeftseinheit(informatikGeschaeftseinheit)
//			.addDomain(systemDomain)
//			.setDomain(systemDomain);
//		em.persist(administrator);
//
//		anonymouse
//			.addGeschaeftseinheit(informatikGeschaeftseinheit)
//			.addRolle(adminRolle)
//			.setRolle(adminRolle)
//			.setGeschaeftseinheit(informatikGeschaeftseinheit)
//			.addDomain(systemDomain)
//			.setDomain(systemDomain);
//		em.persist(anonymouse);
//
//		labormitarbeiter
//			.addGeschaeftseinheit(informatikGeschaeftseinheit)
//			.addGeschaeftseinheit(filliale1Geschaeftseinheit)
//			.setGeschaeftseinheit(filliale1Geschaeftseinheit)
//			.addRolle(superuserRolle)
//			.setRolle(superuserRolle)
//			.addDomain(systemDomain)
//			.setDomain(systemDomain);
//		em.persist(anonymouse);
//
//		Kontakttyp adresstypAuftragsadresse = new Kontakttyp()
//			.setName(AdresstypConstant.AUFTRAGSADRESSE.name())
//			.setBezeichnung("de=Auftragsadresse|en=Order Address");
//		em.persist(adresstypAuftragsadresse);
//
//		Kontakttyp adresstypRechnungsadresse = new Kontakttyp()
//			.setName(AdresstypConstant.RECHNUNGSADRESSE.name())
//			.setBezeichnung("de=Rechnungsadresse|en=Invoice Address");
//		em.persist(adresstypRechnungsadresse);
//
//		Kontakttyp adresstypLieferadresse = new Kontakttyp()
//			.setName(AdresstypConstant.LIEFERADRESSE.name())
//			.setBezeichnung("de=Rechnungsadresse|en=Shipment Address");
//		em.persist(adresstypLieferadresse);
//
//		Geschlecht mann = new Geschlecht()
//			.setName(GeschlechtConstant.MANN.name())
//			.setBezeichnung("de=Herr|en=Mr");
//		em.persist(mann);
//
//		Geschlecht frau = new Geschlecht()
//			.setName(GeschlechtConstant.FRAU.name())
//			.setBezeichnung("de=Frau|en=Mrs");
//		em.persist(frau);
//
//		Partner partnerMeier = new Partner()
//			.addGeschaeftseinheit(hauptsitzGeschaeftseinheit)
//			.addGeschaeftseinheit(filliale1Geschaeftseinheit)
//			.setGeschaeftseinheit(filliale1Geschaeftseinheit);
//		em.persist(partnerMeier);
//
//		Adresse partnerMeierAdresseHinwil = new Adresse()
//			.setPartner(partnerMeier)
//			.setFirma("Filiale Hinwil")
//			.setOrt("Hinwil");
//		em.persist(partnerMeierAdresseHinwil);
//
//		Person paulSchweizer = new Person()
//			.setGeschlecht(mann)
//			.setNachname("Schweizer")
//			.setVorname("Paul");
//		em.persist(paulSchweizer);
//
//		Kontakt partnerMeierAdresseHinwilPaulSchweizer = new Kontakt()
//			.setGeschaeftseinheit(filliale1Geschaeftseinheit)
//			.setAdresse(partnerMeierAdresseHinwil)
//			.setPerson(paulSchweizer);
//		em.persist(partnerMeierAdresseHinwilPaulSchweizer);
//
//		Adresse partnerMeierAdresseBern = new Adresse()
//			.setPartner(partnerMeier)
//			.setFirma("Filiale Hinwil")
//			.setOrt("Hinwil");
//		em.persist(partnerMeierAdresseBern);
//
//		Person nicoleGuenther = new Person()
//			.setGeschlecht(frau)
//			.setNachname("Günther")
//			.setVorname("Nicole");
//		em.persist(nicoleGuenther);
//	
//		Kontakt partnerMeierAdresseBernNicoleGuenther = new Kontakt()
//			.setGeschaeftseinheit(filliale1Geschaeftseinheit)
//			.setAdresse(partnerMeierAdresseBern)
//			.setPerson(nicoleGuenther);
//		em.persist(partnerMeierAdresseBernNicoleGuenther);
//
//
//
//		Person hansMeierZuerich = new Person()
//			.setUser(labormitarbeiter)
//			.setZusatznamenverwenden(true)
//			.setGeschlecht(mann)
//			.setNachname("Meier")
//			.setVorname("Hans")
//			.setZusatzname("Zuerich");
//		em.persist(hansMeierZuerich);
//
//
//		Personenbeziehung personenbeziehung = new Personenbeziehung()
//			.setMitarbeiter(hansMeierZuerich)
//			.setKunde(paulSchweizer)
//			.setPerdu(true)
//			.setAnrede1("Lieber Paul");
//		em.persist(personenbeziehung);
//
//
//		
//		
//		
//		Einheitengruppe laboreinheiten = new Einheitengruppe()
//			.setName("LABOREINHEITEN")
//			.setBezeichnung("de=Laboreinheiten");
//		em.persist(laboreinheiten);
//
//		Einheit einheit = new Einheit()
//			.setName("mg/kg")
//			.setBezeichnung("de=mg/kg")
//			.addEinheitengruppe(laboreinheiten);
//		em.persist(einheit);
//
//		Laboreinstellungen laboreinstellungen = new Laboreinstellungen()
//			.setEinheitengruppe(laboreinheiten);
//		em.persist(laboreinstellungen);
//
//		Norm norm = new Norm()
//			.setName("ICP_OES")
//			.setBezeichnung("de=ICP-OES|en=ICP-OES");
//		em.persist(norm);
//
//
//
//
//		Labormethode icpOesBafuMethode = new Labormethode()
//			.setName("ICP_OES_BAFU")
//			.setBezeichnung("de=ICP-OES (BAFU)")
//			.setNummer("555555")
//			.setPreis(new Double("555"))
//			.addNormen(norm)
//			.setJahresmittelwert(false)
//			.setVerwenden(true)
//			.setAkkreditiert(true)
//			.setPreisausgeben(true)
//			.setUser(administrator);
//		em.persist(icpOesBafuMethode);
//
//		Labormethode asarsen = new Labormethode()
//			.setName("AS_ARSEN")
//			.setBezeichnung("de=As Arsen")
//			.setUser(administrator)
//			.addUebergeordnet(icpOesBafuMethode);
//		em.persist(asarsen);
//
//		Labormethode cdcadmium = new Labormethode()
//			.setName("CD_CADMIUM")
//			.setBezeichnung("de=Cd Cadmium")
//			.setUser(administrator)
//			.addUebergeordnet(icpOesBafuMethode);
//		em.persist(cdcadmium);
//		
//		Vorgangstyp vorgangstypEingangsbestellung = new Vorgangstyp()
//			.setName(VorgangstypConstant.EINGANGSBESTELLUNG.name())
//			.setBezeichnung("de=Eingangsbestellung");
//		em.persist(vorgangstypEingangsbestellung);
//
//		Vorgangstyp vorgangstypProduktion = new Vorgangstyp()
//			.setName(VorgangstypConstant.PRODUKTION.name())
//			.setBezeichnung("de=Produktion");
//		em.persist(vorgangstypProduktion);
//
//		Vorgangsstatus vorgangsstatusErfassen = new Vorgangsstatus()
//			.setName(VorgangsstatusConstant.ERFASSEN.name())
//			.setBezeichnung("de=Erfassen");
//		em.persist(vorgangsstatusErfassen);
//
//		Vorgangsstatus vorgangsstatusErfasst = new Vorgangsstatus()
//			.setName(VorgangsstatusConstant.ERFASST.name())
//			.setBezeichnung("de=Erfasst");
//		em.persist(vorgangsstatusErfasst);
//
//		Positionsstatus positionsstatusFreigegeben = new Positionsstatus()
//			.setName(PositionsstatusConstant.FREIGEGEBEN.name())
//			.setBezeichnung("de=Freigegeben");
//		em.persist(positionsstatusFreigegeben);
//		
//		Vorgang bestellung1 = new Vorgang()
//			.setVorgangstyp(vorgangstypEingangsbestellung)
//			.setVorgangsstatus(vorgangsstatusErfasst)
//			.setUser(administrator);
//		em.persist(bestellung1);
//
//		Eingangsbestellungsposition bestellung1position1 = new Eingangsbestellungsposition()
//			.setVorgang(bestellung1)
//			.setUser(administrator)
//			.setArtikel(icpOesBafuMethode)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(bestellung1position1);
//
//		Eingangsbestellungsposition bestellung1position2 = new Eingangsbestellungsposition()
//			.setVorgang(bestellung1)
//			.setUser(administrator)
//			.setArtikel(asarsen)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(bestellung1position2);
//
//		Eingangsbestellungsposition bestellung1position3 = new Eingangsbestellungsposition()
//			.setVorgang(bestellung1)
//			.setUser(administrator)
//			.setArtikel(cdcadmium)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(bestellung1position3);
//
//		Vorgang uebernahmeInProduktion = new Vorgang()
//			.setVorgangstyp(vorgangstypProduktion)
//			.setVorgangsstatus(vorgangsstatusErfasst)
//			.setUser(labormitarbeiter);
//		em.persist(uebernahmeInProduktion);
//
//		Laborposition produktion1position1 = new Laborposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(labormitarbeiter)
//			.setLabormethode(icpOesBafuMethode)
//			.setEingangsbestellungsposition(bestellung1position1)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(produktion1position1);
//
//		Laborposition produktion1position2 = new Laborposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(labormitarbeiter)
//			.setLabormethode(asarsen)
//			.setEingangsbestellungsposition(bestellung1position2)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(produktion1position2);
//
//		Laborposition produktion1position3 = new Laborposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(labormitarbeiter)
//			.setLabormethode(asarsen)
//			.setEingangsbestellungsposition(bestellung1position3)
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(produktion1position3);
//
//		Vorgang ausgangsrechnung1 = new Vorgang()
//			.setVorgangstyp(vorgangstypProduktion)
//			.setVorgangsstatus(vorgangsstatusErfasst)
//			.setUser(administrator);
//		em.persist(ausgangsrechnung1);
//		
//		Ausgangsrechngungsposition ausgangsrechnung1pos1 = new Ausgangsrechngungsposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(administrator)
//			.setProduktionsposition(produktion1position1.getProduktionsposition())
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(ausgangsrechnung1pos1);
//
//		Ausgangsrechngungsposition ausgangsrechnung1pos2 = new Ausgangsrechngungsposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(administrator)
//			.setProduktionsposition(produktion1position2.getProduktionsposition())
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(ausgangsrechnung1pos2);
//
//		Ausgangsrechngungsposition ausgangsrechnung1pos3 = new Ausgangsrechngungsposition()
//			.setVorgang(uebernahmeInProduktion)
//			.setUser(administrator)
//			.setProduktionsposition(produktion1position3.getProduktionsposition())
//			.setPositionsstatus(positionsstatusFreigegeben);
//		em.persist(ausgangsrechnung1pos3);

	
//		
//		Artikel artikel = new Artikel();
//		em.persist(artikel.setBezeichnung("Artikelname"));
//		
//		Methode methode = new Methode().setBezeichnung("blabla");
//		em.persist(methode);
//		
//		Partner partnerMueller = new Partner();
//		em.persist(partnerMueller);
//
//		Adresse hauptadresse = new Adresse()
//			.setFirma("Müller AG")
//			.setOrt("Zürich")
//			.setSuchfeld("Müller AG, Zürich")
//			.setPartner(partnerMueller);
//		em.persist(hauptadresse);
//
//		Adresse muellerContakt1 = new Adresse()
//			.setFirma("Müller AG")
//			.setNachname("Schweizer")
//			.setVorname("Hans")
//			.setFunktion("Laborleiter")
//			.setOrt("Zürich")
//			.setSuchfeld("Müller AG, Schweizer Hans, Laborleiter, Zürich");
//		muellerContakt1.setHauptadresse(hauptadresse).setPartner(partnerMueller);
//		em.persist(muellerContakt1);
//
//		Adresse muellerContakt2 = new Adresse()
//			.setFirma("Müller AG")
//			.setNachname("Lebert")
//			.setVorname("Ruedi")
//			.setFunktion("Geschäftsführer")
//			.setOrt("Zürich")
//			.setSuchfeld("Müller AG, Lebert Ruedi, Geschäftsführer, Zürich");
//		muellerContakt2.setHauptadresse(hauptadresse).setPartner(partnerMueller);
//		em.persist(muellerContakt2);

	}



	private void stammdaten() {

		Partnerbeziehungstyp geschaeftsbereichDivision = new Partnerbeziehungstyp()
			.setName(PartnerbeziehungstypEnum.GESCHAEFTSBEREICH.name())
			.setBezeichnung("de=Filiale|en=Division")
			.setSystem(true);
		em.persist(geschaeftsbereichDivision);
			
		Partnerbeziehungstyp beziehungKunde = new Partnerbeziehungstyp()
			.setName(PartnerbeziehungstypEnum.KUNDE.name())
			.setBezeichnung("de=Kunde|en=Customer")
			.setSystem(true);
		em.persist(beziehungKunde);

		Partnerbeziehungstyp beziehungLieferant = new Partnerbeziehungstyp()
			.setName(PartnerbeziehungstypEnum.LIEFERANT.name())
			.setBezeichnung("de=Lieferant|en=Supplier")
			.setSystem(true);
		em.persist(beziehungLieferant);


		Geschlecht mann = new Geschlecht()
			.setName(GeschlechtEnum.MANN.name())
			.setBezeichnung("de=Herr|en=Mr");
		em.persist(mann);

		Geschlecht frau = new Geschlecht()
			.setName(GeschlechtEnum.FRAU.name())
			.setBezeichnung("de=Frau|en=Mrs");
		em.persist(frau);


		Vorgangsstatus vorgangsstatusErfassen = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.ERFASSEN.name())
			.setBezeichnung("de=erfassen|en=to record");
		em.persist(vorgangsstatusErfassen);

		Vorgangsstatus vorgangsstatusErfasst = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.ERFASST.name())
			.setBezeichnung("de=erfasst|en=record");
		em.persist(vorgangsstatusErfasst);

		Vorgangsstatus vorgangsstatusInarbeit = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.INARBEIT.name())
			.setBezeichnung("de=in Arbeit|en=progress");
		em.persist(vorgangsstatusInarbeit);

		Vorgangsstatus vorgangsstatusVerrechnen = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.VERRECHNEN.name())
			.setBezeichnung("de=in Arbeit|en=to charge");
		em.persist(vorgangsstatusVerrechnen);

		Vorgangsstatus vorgangsstatusVerrechnet = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.VERRECHNET.name())
			.setBezeichnung("de=verrechnet|en=cleared");
		em.persist(vorgangsstatusVerrechnet);

		Vorgangsstatus vorgangsstatusBeendet = new Vorgangsstatus()
			.setName(VorgangsstatusEnum.BEENDET.name())
			.setBezeichnung("de=beendet|en=completed");
		em.persist(vorgangsstatusBeendet);


		Vorgangstyp vorgangstypKundenbestellung = new Vorgangstyp()
			.setName(VorgangstypEnum.KUNDENBESTELLUNG.name())
			.setBezeichnung("de=Kundenbestellung|en=customer order");
		em.persist(vorgangstypKundenbestellung);

		Vorgangstyp vorgangstypKundenofferte = new Vorgangstyp()
			.setName(VorgangstypEnum.KUNDENOFFERTE.name())
			.setBezeichnung("de=Kundenofferte|en=customer offer");
		em.persist(vorgangstypKundenofferte);

		Vorgangstyp vorgangstypEingangslieferschein = new Vorgangstyp()
			.setName(VorgangstypEnum.EINGANGSLIEFERSCHEIN.name())
			.setBezeichnung("de=Eingangslieferschein|en=incoming invoice");
		em.persist(vorgangstypEingangslieferschein);

		Vorgangstyp vorgangstypEingangsbestellung = new Vorgangstyp()
			.setName(VorgangstypEnum.EINGANGSBESTELLUNG.name())
			.setBezeichnung("de=Eingangsbestellung|en=incoming order");
		em.persist(vorgangstypEingangsbestellung);

		Vorgangstyp vorgangstypProduktion = new Vorgangstyp()
			.setName(VorgangstypEnum.PRODUKTION.name())
			.setBezeichnung("de=Produktion|en=production");
		em.persist(vorgangstypProduktion);

		Vorgangstyp vorgangstypAusgangslieferschein = new Vorgangstyp()
			.setName(VorgangstypEnum.AUSGANGSLIEFERSCHEIN.name())
			.setBezeichnung("de=Ausgangslieferschein|en=outgoing delivery");
		em.persist(vorgangstypAusgangslieferschein);

		Vorgangstyp vorgangstypAusgangsrechnung = new Vorgangstyp()
			.setName(VorgangstypEnum.AUSGANGSRECHNUNG.name())
			.setBezeichnung("de=Ausgangsrechnung|en=outgoing invoice");
		em.persist(vorgangstypAusgangsrechnung);

		Einheitengruppe einheitengruppeErp = new Einheitengruppe()
			.setName(EinheitengruppeEnum.ERP.name())
			.setBezeichnung("de=Einheiten ERP|en=Units ERP");
		em.persist(einheitengruppeErp);

		Einheitengruppe einheitengruppeLabor = new Einheitengruppe()
			.setName(EinheitengruppeEnum.LABOR.name())
			.setBezeichnung("de=Einheiten Labor|en=Units Labor");
		em.persist(einheitengruppeLabor);


		Einheit einheitAnzahl = new Einheit()
			.addEinheitengruppe(einheitengruppeErp)
			.setName(EinheitEnum.ANZAHL.name())
			.setBezeichnung("de=Einheit|en=unit");
		em.persist(einheitAnzahl);

		Einheit einheitMgLiter = new Einheit()
			.addEinheitengruppe(einheitengruppeLabor)
			.setName("MG_LITER")
			.setBezeichnung("de=ml/l|en=ml/l");
		em.persist(einheitMgLiter);

	}

	@PreDestroy
	private void preDestroy() {

	}

}