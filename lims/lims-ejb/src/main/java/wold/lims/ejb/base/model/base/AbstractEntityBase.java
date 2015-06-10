package wold.lims.ejb.base.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class AbstractEntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ID", length = 32, columnDefinition = "char(32)")
	protected String id;

	@Version
	@Column(name = "VERSION")
	protected long version;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	protected Date created;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	protected Date updated;

	@Column(name = "aktiv", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean aktiv;

	@Column(name = "system", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean system;


	@PrePersist
	public void onCreate() {
		Date tmpDate = new Date();
		created = tmpDate;
		updated = tmpDate;
		aktiv = true;
	}

	@PreUpdate
	public void onUpdate() {
		updated = new Date();
	}

	public String getId() {
		return id;
	}

	public AbstractEntityBase setId(String id) {
		this.id = id;
		return this;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isSystem() {
		return system;
	}

	public AbstractEntityBase setSystem(boolean system) {
		this.system = system;
		return this;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public AbstractEntityBase setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
		return this;
	}

}
