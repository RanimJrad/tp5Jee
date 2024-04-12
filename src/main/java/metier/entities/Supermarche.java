package metier.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supermarche")
public class Supermarche implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="ID_Supermarche")
	private Long idSupermarche;
	
	@Column (name="NOM_Supermarche")
	private String nomSupermarche;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "Localisation_Supermarche")
	private String loc;
	
	@Column(name = "Date_de_creation")
	private Date dateSup;
	
	private Type typ;

	public Supermarche (String nomSupermarche, String loc,Type typ) {

	super();
	this.nomSupermarche = nomSupermarche;
	this.loc = loc;
	this.setTyp(typ);;
	}
	
	public Supermarche() {
		super();
	}
	public Supermarche(String nomSupermarche, String type, String loc, Date dateSup) {
		super();
		this.nomSupermarche = nomSupermarche;
		this.type = type;
		this.loc = loc;
		this.dateSup = dateSup;
	}
	
	public Long getIdSupermarche() {
		return idSupermarche;
	}
	public void setIdSupermarche(Long idSupermarche) {
		this.idSupermarche = idSupermarche;
	}
	public String getNomSupermarche() {
		return nomSupermarche;
	}
	public void setNomSupermarche(String nomSupermarche) {
		this.nomSupermarche = nomSupermarche;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Date getDateSup() {
		return dateSup;
	}
	public void setDateSup(Date dateSup) {
		this.dateSup = dateSup;
	}
	@Override
	public String toString() {
		return "Supermarche [nomSupermarche=" + nomSupermarche + ", type=" + type
				+ ", loc=" + loc + ", dateSup=" + dateSup + "]";
	}
	
	public Type getTyp() {
		return typ;
	}



	public void setTyp(Type typ) {
		this.typ= typ;
	}

}
