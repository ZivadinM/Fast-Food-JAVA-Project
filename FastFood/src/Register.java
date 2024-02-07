import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import klase.Korisnik;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static boolean patternMatches(String emailAddress, String regexPattern) {
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
	public static Scanner sc=null;
	public static void PodaciOkorisnicima() {
		try {
		// inicijalizacija fajla korisnici, citamo iz nje
			sc=new Scanner(new File("Korisnici.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			 System.exit(1);
		}
		String username;
		String password;
		String email;
		String line="";
		while(sc.hasNext()) {
			line=sc.nextLine().trim();
			username=line;
			
			line=sc.nextLine().trim();
			password=line;
			
			line=sc.nextLine().trim();
			email=line;
			Korisnik a=new Korisnik(username,password,email);
			//dodavalje korsnika u listu
			Login.listk.add(a);
		}
		}
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
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("REGISTER");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_3_1.setBounds(138, 21, 171, 55);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PodaciOkorisnicima();
					FileWriter a=new FileWriter("Korisnici.txt",true);
					PrintWriter izl=new PrintWriter(a);
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) 
						throw new Exception("Morate popuniti sva polja ili vas password nije u redu");
					if(patternMatches(textField_2.getText(), "^(.+)@(\\S+)$")==false)
						throw new Exception("Unesite ispravan mail");
					for(int i=0;i<Login.listk.size();i++) {
					if(textField.getText().toString().compareTo(Login.listk.get(i).username)==0)
						throw new Exception("Ovaj Username vec postoji probajete niki drugi");
					if(textField_2.getText().toString().compareTo(Login.listk.get(i).email)==0)
						throw new Exception("Ovaj email vec postoji probajete niki drugi");}
					izl.println(textField.getText());
					izl.println(textField_1.getText());
					izl.println(textField_2.getText());
					izl.flush(); 
					izl.close();
					dispose();
					
					Login frame = new Login();
					frame.setVisible(true);
					throw new Exception("Uneli ste novog korisnika");

				}
				catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(164, 276, 122, 31);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 101, 377, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(99, 10, 261, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(99, 55, 261, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 101, 261, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(32, 105, 96, 13);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPasswor = new JLabel("Password:");
		lblPasswor.setBounds(10, 61, 96, 13);
		panel.add(lblPasswor);
		lblPasswor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 16, 96, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

}
