package vagi2_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Garaza {
	
    static JFrame f = new JFrame("Vāģi 2");
    static Clip clip;
    static JPanel contentPanel;
    static JLabel bilde;
    static int index = 0;

    // iestatijumi
    public static void iestatijumi() {
        contentPanel.removeAll();

        JPanel iestatijumi = new JPanel();
        iestatijumi.setBackground(new Color(50, 50, 50));
        iestatijumi.setLayout(new BoxLayout(iestatijumi, BoxLayout.Y_AXIS));
        
        iestatijumi.add(Box.createVerticalStrut(25));
        
        JLabel nosaukums = new JLabel("Iestatījumi");
        nosaukums.setFont(new Font("Dialog", Font.BOLD, 70));
        nosaukums.setForeground(Color.white);
        iestatijumi.add(nosaukums);

        iestatijumi.add(Box.createVerticalStrut(50));

        
        JCheckBox muzika = JBuilders.cIestatijumi("Mūzika");
        muzika.setSelected(clip != null && clip.isRunning());
        iestatijumi.add(muzika);

        // Mūzikai
        muzika.addActionListener(_ -> {
            if (muzika.isSelected()) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
                clip.stop();
            }
        });
        
        
        iestatijumi.add(Box.createVerticalStrut(15));
        
        // Skaņai
        JCheckBox skana = JBuilders.cIestatijumi("Skaņa");
        skana.setSelected(JBuilders.mute);
        iestatijumi.add(skana);

        skana.addActionListener(_ -> {
            if (skana.isSelected()) {
                JBuilders.mute = true;
            } else {
                JBuilders.mute = false;
            }
        });
        
        iestatijumi.add(Box.createVerticalStrut(15));
        
        
        iestatijumi.add(Box.createHorizontalStrut(15));

        contentPanel.add(iestatijumi, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    public static void pateicibas(){
    	contentPanel.removeAll();
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(50, 50, 50));
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
        panel.add(Box.createVerticalStrut(25));
    	
    	JLabel virsraksts = new JLabel();
    	virsraksts.setFont(new Font("Dialog", Font.BOLD, 70));
    	virsraksts.setForeground(Color.white);
    	virsraksts.setText("Paldies...");

    	panel.add(virsraksts);
    	
        panel.add(Box.createVerticalStrut(50));
    	
    	JLabel teksts = new JLabel("<html>Gustavam Lācim<br>Emīls Smirnovs<br>ChatGPT<br>Gemini<br>Disnep</html>");
    	teksts.setFont(new Font("Dialog", Font.BOLD, 25));
    	teksts.setForeground(Color.white);
    	panel.add(teksts);
    	
    	panel.add(Box.createHorizontalStrut(15));
    	
    	contentPanel.add(panel);
    	contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    public static void masinuIzv(int index) {
    	int pasMas = index;
    	contentPanel.removeAll();
    	
    	ArrayList<masina> visasMasinas = new ArrayList<>();
    	
    	//pasAtrums marka modelis krāsa vārds ceļš uz bildi max ātrums
    	masina fins = new masina(0, "GT", "1965Faultless", "Pēlēka", "Fins", "finn.png", 180);
    	visasMasinas.add(fins);
    	masina metrins = new masina(0, "Chevrolet", "1951 boom truck", "Brūns", "Metriņš", "mater.png", 90);
    	visasMasinas.add(metrins);
    	masina makvins = new masina(0, "Corvette", "C6", "Sarkana", "Makvins", "mcqueen.png", 260);
    	visasMasinas.add(makvins);
    	
    	JPanel info = new JPanel();
    	info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
    	info.setBackground(new Color(60, 60, 60));
    	info.setMaximumSize(new Dimension(400, 720));
    	info.setPreferredSize(new Dimension(400, 720));
    	
    	info.add(Box.createVerticalStrut(15));
    	
    	JLabel vards = new JLabel();
    	vards.setFont(new Font("Dialog", Font.BOLD, 35));
    	vards.setForeground(Color.white);
    	vards.setText("Vārds: " + visasMasinas.get(pasMas).vards);
    	
    	info.add(vards);
    	info.add(Box.createVerticalStrut(15));
    	
    	JLabel marka = new JLabel();
    	marka.setFont(new Font("Dialog", Font.BOLD, 25));
    	marka.setForeground(Color.white);
    	marka.setText("Marka: " + visasMasinas.get(pasMas).marka);
    	
    	info.add(marka);
    	info.add(Box.createVerticalStrut(15));
    	
    	JLabel modelis = new JLabel();
    	modelis.setFont(new Font("Dialog", Font.BOLD, 25));
    	modelis.setForeground(Color.white);
    	modelis.setText("Modelis: " + visasMasinas.get(pasMas).modelis);
    	
    	info.add(modelis);
    	info.add(Box.createVerticalStrut(15));
    	
    	JLabel krasa = new JLabel();
    	krasa.setFont(new Font("Dialog", Font.BOLD, 25));
    	krasa.setForeground(Color.white);
    	krasa.setText("Krāsa: " + visasMasinas.get(pasMas).krasa);
    	
    	info.add(krasa);
    	info.add(Box.createVerticalStrut(15));
    	
    	JLabel maxAtrums = new JLabel();
    	maxAtrums.setFont(new Font("Dialog", Font.BOLD, 25));
    	maxAtrums.setForeground(Color.white);
    	maxAtrums.setText("Maksimālais ātrums: " + visasMasinas.get(pasMas).maxAtrums);
    	
    	info.add(maxAtrums);
    	info.add(Box.createVerticalStrut(15));
    	
    	info.add(Box.createHorizontalStrut(15));
    	
    	JPanel pBraukt = new JPanel(new BorderLayout());
    	pBraukt.setMaximumSize(new Dimension(1000, 50));
    	
    	JButton braukt = JBuilders.pSakumaMenu("Izbraukt");
    	braukt.setFont(new Font("Dialog", Font.BOLD, 20));
    	braukt.addActionListener(_ -> izbraukt(visasMasinas.get(pasMas)));
    	
    	pBraukt.add(braukt, BorderLayout.CENTER);
    	info.add(pBraukt, BorderLayout.SOUTH);
    	
    	contentPanel.add(info, BorderLayout.WEST);
    	
    	JPanel panelBilde = new JPanel(new BorderLayout());
    	panelBilde.setBackground(new Color(50, 50, 50));
    	JLabel bilde = new JLabel(visasMasinas.get(pasMas).bilde);
    	
    	panelBilde.add(bilde, BorderLayout.CENTER);
    	
    	JPanel pogas = new JPanel();
    	pogas.setBackground(new Color(50, 50, 50));
    	
    	
    	JButton prieksu = JBuilders.pSakumaMenu("Nākamais");
    	JButton atpakal = JBuilders.pSakumaMenu("Atpakaļ");
    	atpakal.setFont(new Font("Dialog", Font.BOLD, 20));
    	
    	atpakal.addActionListener(_ -> {
    		if(pasMas > 0) {
    			mainaAtpakal();
    		}
    	});
    	
        pogas.add(atpakal);
        pogas.add(Box.createHorizontalStrut(80));
        
    	
    	
    	prieksu.setFont(new Font("Dialog", Font.BOLD, 20));
    	
    	prieksu.addActionListener(_ -> {
    	    if (pasMas < visasMasinas.size() - 1) {
    	        mainaPrieksu();
    	    }
    	});
    	
        pogas.add(prieksu);
        pogas.add(Box.createVerticalStrut(80));
        
    	panelBilde.add(pogas, BorderLayout.SOUTH);
        
    	contentPanel.add(panelBilde);
    	
    	contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    public static void mainaPrieksu() {
    	index += 1;
    	masinuIzv(index);
    }
    
    public static void mainaAtpakal() {
    	index -= 1;
    	masinuIzv(index);
    }
    
    public static void izbraukt(masina masina) {
        String[] opcijas = {"Paātrināt", "Bremzēt", "Noparkoties", "Noteikt ātrumu", "Pārkrāsot", "Apskatīt"};
        String izv;
		int atrums = 0;
        do {
        	izv = (String) JOptionPane.showInputDialog(null, "Izvēlaties darbību", masina.vards, JOptionPane.PLAIN_MESSAGE, null, opcijas, opcijas[0]);
        	if(izv == null)
        		izv = "Noparkoties";
        	
        	switch(izv) {
        	case "Paātrināt":
        		try {
        		atrums = Integer.parseInt(JOptionPane.showInputDialog(null, "Pa cik palielināsiet ātrumu", masina.vards, JOptionPane.QUESTION_MESSAGE));
        		}catch(NumberFormatException e) {
        			JOptionPane.showMessageDialog(null, e);	
        		}
        		if(masina.paatrinat(atrums))
        			izv = "Noparkoties";	
        		break;
        		
        	case "Bremzēt":
        		try {
        		atrums = Integer.parseInt(JOptionPane.showInputDialog(null, "Pa cik pamazināt ātrumu", masina.vards, JOptionPane.QUESTION_MESSAGE));
        		}catch(NumberFormatException e) {
        			JOptionPane.showMessageDialog(null, e);	
        		}
        		if(masina.pamazinat(atrums))
        			izv = "Noparkoties";	
        		break;
        		
        	case "Noparkoties":
        		masina.noparkoties();
        		izv = "Noparkoties";	
        		break;
        		
        	case "Noteikt ātrumu":
        		masina.noteiktAtrumu();
        		break;
        		
        	case "Pārkrāsot":
        		masina.krasot();
        		break;
        		
        	case "Apskatīt":
        		masina.apskatit();
        	}
        	
        	
        	
        }while(!izv.equals("Noparkoties"));
    }
    
    public static void main(String[] args) {
    	
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(1280, 720);
        f.setLocationRelativeTo(null);
        //Mūzika
        try {
            File audioFile = new File("sounds/It's Finn McMissile! (From Cars 2Score).wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error playing file:\n" + e.getMessage());
        }

        ImageIcon imageIcon = new ImageIcon("images/compose.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(1050, 720, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        bilde = new JLabel();
        bilde.setIcon(imageIcon);

        JPanel mainPanels = new JPanel(new BorderLayout());
        mainPanels.setBackground(new Color(50, 50, 50));

        JPanel poguPanels = new JPanel();
        poguPanels.setBackground(Color.BLACK);
        poguPanels.setLayout(new BoxLayout(poguPanels, BoxLayout.Y_AXIS));

        poguPanels.add(Box.createVerticalStrut(20));

        JLabel nosaukums = new JLabel(" VĀĢI");
        nosaukums.setFont(new Font("Dialog", Font.BOLD, 70));
        nosaukums.setForeground(Color.white);
        poguPanels.add(nosaukums);

        poguPanels.add(Box.createVerticalStrut(70));
        
        //Starts
        JButton pStarts = JBuilders.pSakumaMenu("  Starts             ");
        pStarts.addActionListener(_ -> masinuIzv(index));
        poguPanels.add(pStarts);

        poguPanels.add(Box.createVerticalStrut(25));
        
        //Iestatijumi
        JButton pIestatijumi = JBuilders.pSakumaMenu("  Iestatījumi      ");
        pIestatijumi.addActionListener(_ -> iestatijumi());
        poguPanels.add(pIestatijumi);

        poguPanels.add(Box.createVerticalStrut(25));
        
        //Pateicibas
        JButton pPateiciba = JBuilders.pSakumaMenu("  Pateicibas      ");
        pPateiciba.addActionListener(_ -> pateicibas());
        poguPanels.add(pPateiciba);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(50, 50, 50));
        contentPanel.add(bilde, BorderLayout.CENTER);

        mainPanels.add(poguPanels, BorderLayout.EAST);
        mainPanels.add(contentPanel, BorderLayout.CENTER);

        f.add(mainPanels);
        f.setVisible(true);
    }
}
