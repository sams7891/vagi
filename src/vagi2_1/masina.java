package vagi2_1;

import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class masina {
	String marka, modelis, krasa, vards;
	int pasAtrums = 0, maxAtrums;
	String cels;
	ImageIcon bilde;
	String jaunaKrasa = krasa;
	
	masina(int pasAtrums, String marka, String modelis, String krasa, String vards, String cels, int maxAtrums){
		this.pasAtrums = pasAtrums;
		this.marka = marka;
		this.modelis = modelis;
		this.krasa = krasa;
		this.vards = vards;
		bilde = new ImageIcon(new ImageIcon("images" + File.separator + cels).getImage());
		this.maxAtrums = maxAtrums;
	}
	
	void debuginfo(){
		System.out.println(pasAtrums);
		System.out.println(marka);
		System.out.println(modelis);
		System.out.println(krasa);
		System.out.println(vards);
	}
	
	boolean paatrinat(int atrums){
		if(atrums < 0) {
			JOptionPane.showMessageDialog(null, "Tu mēģināji paātrināt mašīnu, bet samazināt ātrumu vienlaikus...\n\n\nNeesi pelnijis izmantot manu programmu.", "Fizikas kļūda", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		if(pasAtrums + atrums > maxAtrums) {
			JOptionPane.showMessageDialog(null, "Tu sāki braukt pārāk ātri salaužot savu mašīnu", "Avārija", JOptionPane.ERROR_MESSAGE);
			return true;
		
		} else if(pasAtrums + atrums < 0) {
			JOptionPane.showMessageDialog(null, "Tu sāki braukt otrādi salaužot savu mašīnu", "Avārija", JOptionPane.ERROR_MESSAGE);
			return true;
		} else {
			pasAtrums += atrums;
			if(pasAtrums == 67 || pasAtrums == 69)
				JOptionPane.showMessageDialog(null, "Tu esi jokdaris huh...\nVai arī tas ir Intars kas testē šo programmu tagad", "Īpašs", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	boolean pamazinat(int atrums){
		if(pasAtrums - atrums < 0) {
			JOptionPane.showMessageDialog(null, "Tu bremzēji tik ilgi ka kāds tevī iebrauca", "Avārija", JOptionPane.ERROR_MESSAGE);
			return true;
		}else {
			pasAtrums += atrums;
			return false;
		}
	}
	
	void noparkoties() {
		if(pasAtrums > 15) {
			JOptionPane.showMessageDialog(null, "Tu mēģināji pārāk lielā ātrumā noparkoties\nVari tikai noparkoties ar ātrumu MAX 15 km/h", "Avārija", JOptionPane.ERROR_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null, "Tu veiksmīgi noparkojies un " + vards + " izdomāja nokrāsoties atpakaļ savā krāsā", "Parkošanās", JOptionPane.PLAIN_MESSAGE);		
		}
		}
	
	void noteiktAtrumu() {
		JOptionPane.showMessageDialog(null, "Tu brauc ar " + pasAtrums + " km/h");
	}
	
	void krasot() {
		Color krasa = JColorChooser.showDialog(null, "Izvēlies krāsu", null);
		jaunaKrasa = Integer.toHexString(krasa.getRGB()).substring(2).toUpperCase();
		if(krasa != null)
			JOptionPane.showMessageDialog(null, "Tu izvēlējies: #" + jaunaKrasa, "Los Santos Customs", JOptionPane.PLAIN_MESSAGE);
	}
	
	void apskatit() {
		JOptionPane.showMessageDialog(null, "Modelis: " + modelis + "\nMarka: " + marka + "\nKrāsa: " + jaunaKrasa + "\nMaksimālais ātrums: " + maxAtrums + " km/h", vards, JOptionPane.PLAIN_MESSAGE);
	}
}
