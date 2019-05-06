package plir2166MV.repository.repoInterfaces;

import plir2166MV.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c);
	void modificaCarte(Carte nou, Carte vechi);
	void stergeCarte(Carte c);
	List<Carte> cautaCarteDupaAutor(String ref);
	List<Carte> getCarti();
	List<Carte> cautaCartiDinAnulOrdonateDupaTitluSiAutor(String an);
}
