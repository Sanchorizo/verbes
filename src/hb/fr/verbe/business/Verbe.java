package hb.fr.verbe.business;

import java.util.Objects;

public class Verbe {

	private long id;
	private String baseVerbale;
	private String preterit;
	private String participePasse;
	private String traduction;
	public static long compteur = 0L;
	
	public Verbe() {
		id= ++compteur;
	}
	
	public Verbe(String baseVerbale, String preterit, String participePasse, String traduction) {
		this();
		this.baseVerbale = baseVerbale;
		this.preterit = preterit;
		this.participePasse = participePasse;
		this.traduction = traduction;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBaseVerbale() {
		return baseVerbale;
	}

	public void setBaseVerbale(String baseVerbale) {
		this.baseVerbale = baseVerbale;
	}

	public String getPreterit() {
		return preterit;
	}

	public void setPreterit(String preterit) {
		this.preterit = preterit;
	}

	public String getParticipePasse() {
		return participePasse;
	}

	public void setParticipePasse(String participePasse) {
		this.participePasse = participePasse;
	}

	public String getTraduction() {
		return traduction;
	}

	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	public static long getCompteur() {
		return compteur;
	}

	public static void setCompteur(long compteur) {
		Verbe.compteur = compteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseVerbale, id, participePasse, preterit, traduction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verbe other = (Verbe) obj;
		return Objects.equals(baseVerbale, other.baseVerbale) && id == other.id
				&& Objects.equals(participePasse, other.participePasse) && Objects.equals(preterit, other.preterit)
				&& Objects.equals(traduction, other.traduction);
	}

	@Override
	public String toString() {
		return "Verbe [id=" + id + ", baseVerbale=" + baseVerbale + ", preterit=" + preterit + ", participePasse="
				+ participePasse + ", traduction=" + traduction  + "]"+ "\n";
	}
	
	
	
	
}
