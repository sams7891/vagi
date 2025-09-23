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
		if(pasAtrums + atrums > maxAtrums) {
			JOptionPane.showMessageDialog(null, "Tu sāki braukt pārāk ātri salaužot savu mašīnu", "Avārija", JOptionPane.ERROR_MESSAGE);
			return true;
		} else {
			pasAtrums += atrums;
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
			JOptionPane.showMessageDialog(null, "Tu mēģināji pārāk lielā ātrumā noparkoties", "Avārija", JOptionPane.ERROR_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Tu veiksmīgi noparkojies un " + vards + " izdomāja nokrāsoties atpakaļ savā krāsā", "Parkošanās", JOptionPane.PLAIN_MESSAGE);		
	}
	
	void noteiktAtrumu() {
		JOptionPane.showMessageDialog(null, "Tu brauc ar " + pasAtrums + " km/h");
	}
	
	void krasot() {
		Color krasa = JColorChooser.showDialog(null, "Izvēlies krāsu", null);
		
		if(krasa != null)
			JOptionPane.showMessageDialog(null, "Tu izvēlējies: #" + Integer.toHexString(krasa.getRGB()).substring(2).toUpperCase(), "Los Santos Customs", JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Tevi izmeta ārā no darbnīcas", "Los Santos Customs", JOptionPane.ERROR_MESSAGE);
	}
	
	void apskatit() {
		JOptionPane.showMessageDialog(null, "Modelis: " + modelis + "\nMarka: " + marka + "\nKrāsa: " + krasa + "\nMaksimālais ātrums: " + maxAtrums + " km/h", vards, JOptionPane.PLAIN_MESSAGE);
	}
	
}
