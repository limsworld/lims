package wold.lims.ejb.erp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityBase;

@Entity
@Table(name = "PERSONENBEZIEHUNG", schema = "ERP")
public class Personenbeziehung extends AbstractEntityBase {

	private static final long serialVersionUID = 1638659896510609941L;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID")	
	protected Person person;

	@ManyToOne
	@JoinColumn(name = "PERSON2_ID")	
	protected Person person2;

	@NotNull
	@Column(name = "PERDU", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean perdu;

	@Column(length = 120)
	protected String anrede1;
	
	@Column(length = 120)
	protected String anrede2;

	@Column(length = 120)
	protected String anrede3;

	public Person getPerson() {
		return person;
	}

	public Personenbeziehung setPerson(Person person) {
		this.person = person;
		return this;
	}

	public Person getPerson2() {
		return person2;
	}

	public Personenbeziehung setPerson2(Person person2) {
		this.person2 = person2;
		return this;
	}

	public boolean isPerdu() {
		return perdu;
	}

	public Personenbeziehung setPerdu(boolean perdu) {
		this.perdu = perdu;
		return this;
	}

	public String getAnrede1() {
		return anrede1;
	}

	public Personenbeziehung setAnrede1(String anrede1) {
		this.anrede1 = anrede1;
		return this;
	}

	public String getAnrede2() {
		return anrede2;
	}

	public Personenbeziehung setAnrede2(String anrede2) {
		this.anrede2 = anrede2;
		return this;
	}

	public String getAnrede3() {
		return anrede3;
	}

	public Personenbeziehung setAnrede3(String anrede3) {
		this.anrede3 = anrede3;
		return this;
	}

}
