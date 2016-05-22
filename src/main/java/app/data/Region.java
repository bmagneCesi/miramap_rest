package app.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Region database table.
 * 
 */
@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_region")
	private int idRegion;

	private String libelle;

	//bi-directional many-to-one association to Ville
	@OneToMany(mappedBy="region")
	private List<Ville> villes;

	public Region() {
	}

	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Ville> getVilles() {
		return this.villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Ville addVille(Ville ville) {
		getVilles().add(ville);
		ville.setRegion(this);

		return ville;
	}

	public Ville removeVille(Ville ville) {
		getVilles().remove(ville);
		ville.setRegion(null);

		return ville;
	}

}