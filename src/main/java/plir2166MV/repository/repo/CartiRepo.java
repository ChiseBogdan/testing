package plir2166MV.repository.repo;


import plir2166MV.model.Carte;
import plir2166MV.repository.repoInterfaces.CartiRepoInterface;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepo implements CartiRepoInterface {
	
	private String numeFisier = "cartiBD.dat";
	
	public CartiRepo(){
		URL location = CartiRepo.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
	}

	public CartiRepo(String numeFisier) {
		this.numeFisier = numeFisier;
	}

	@Override
	public void adaugaCarte(Carte c) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(numeFisier,true));
			bw.write(c.toString());
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Carte> getCarti() {
		List<Carte> lc = new ArrayList<Carte>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(numeFisier));
			String line = null;
			while((line=br.readLine())!=null){
				lc.add(Carte.getCarteFromString(line));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lc;
	}

	@Override
	public void modificaCarte(Carte nou, Carte vechi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stergeCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carte> cautaCarteDupaAutor(String ref) {
		List<Carte> carti = getCarti();
		List<Carte> cartiGasite = new ArrayList<Carte>();
		int i=0;
		while (i<carti.size()){
			boolean flag = false;
			List<String> lref = carti.get(i).getReferenti();
			int j = 0;
			while(j<lref.size()){
				if(lref.get(j).toLowerCase().contains(ref.toLowerCase())){
					flag = true;
					break;
				}
				j++;
			}
			if(flag == true){
				cartiGasite.add(carti.get(i));
			}
			i++;
		}
		return cartiGasite;
	}

	@Override
	public List<Carte> cautaCartiDinAnulOrdonateDupaTitluSiAutor(String an) {
		List<Carte> lc = getCarti();
		List<Carte> lca = new ArrayList<Carte>();
		for(Carte c:lc){
			if(c.getAnAparitie().equals(an)){
				lca.add(c);
			}
		}
		
		Collections.sort(lca,new Comparator<Carte>(){

			@Override
			public int compare(Carte a, Carte b) {
				if(a.getAnAparitie().compareTo(b.getAnAparitie())==0){
					return a.getTitlu().compareTo(b.getTitlu());
				}
				
				return a.getTitlu().compareTo(b.getTitlu());
			}
		
		});
		
		return lca;
	}

}
