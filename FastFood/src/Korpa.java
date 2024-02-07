import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klase.Artikal;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Korpa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Korpa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 240, 261, 27);
		contentPane.add(textField);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdresa.setBounds(41, 244, 96, 13);
		contentPane.add(lblAdresa);
		
		JLabel lblNapomena = new JLabel("Napomena:");
		lblNapomena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNapomena.setBounds(41, 284, 96, 27);
		contentPane.add(lblNapomena);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(144, 288, 261, 88);
		contentPane.add(textArea);

		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(46, 26, 501, 199);
		contentPane.add(textArea1);
		textArea1.append("Proizvod\tKolicina\tCena\tVrednost\n");
		int x=0;
		for(Artikal a:OdabirProizvoda.lista) {
			textArea1.append(""+a.naziv+"\t"+a.kolicina+"\t"+a.cena+" RSD\t"+a.cena*a.kolicina+" RSD\n");
			x=x+(a.cena*a.kolicina);
		}
		textArea1.append("\n \nIznos:"+Integer.toString(x));
		JButton btnNewButton = new JButton("NARUCI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter izl=new PrintWriter("Racun.txt");
					int x=0;
					if(textField.getText().isEmpty() ) 
						throw new Exception("Morate popuniti adres");
					izl.println("Proizvod\tKolicina\tCena\tVrednost");
					for(Artikal a:OdabirProizvoda.lista) {
						izl.println(""+a.naziv+"\t\t"+a.kolicina+"\t\t"+a.cena+"RSD\t"+a.cena*a.kolicina+"RSD");
						x=x+(a.cena*a.kolicina);
					}
					izl.println("\n\nAdresa"+textField.getText());
					izl.println("Iznos "+Integer.toString(x)+" RSD");
					izl.println("Napomena");
					izl.flush(); 
					izl.close();
					
					OdabirProizvoda.lista.clear();
					textArea1.setText("");
					throw new Exception("Porudzbina je obavljena racun imate u dokumentu");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(425, 243, 122, 145);
		contentPane.add(btnNewButton);
		
		JButton btnDodajJos = new JButton("DODAJ JOS");
		btnDodajJos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OdabirProizvoda frame = new OdabirProizvoda();
				frame.setVisible(true);
			}
		});
		btnDodajJos.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDodajJos.setBounds(-22, 371, 148, 27);
		contentPane.add(btnDodajJos);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OdabirProizvoda.lista.clear();
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogOut.setBounds(-2, 333, 128, 30);
		contentPane.add(btnLogOut);
	}
}
