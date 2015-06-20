package wold.lims.ejb.base.model.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class AbstractEntityId implements Serializable {

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

	@Override
    public int hashCode() {
		return id.hashCode();
    }

	public String getId() {
		return id;
	}

	public AbstractEntityId setId(String id) {
		this.id = id;
		return this;
	}

	public long getVersion() {
		return version;
	}

	public AbstractEntityId setVersion(long version) {
		this.version = version;
		return this;
	}

}
