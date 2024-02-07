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
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static ArrayList<Korisnik> listk=new ArrayList<>();

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
	public static Scanner sc=null;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ako nemate nalog morate se registrovati.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(84, 232, 349, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DOBRODOSLI");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(113, -11, 294, 90);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("LOGIN:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3_1.setBounds(173, 65, 171, 55);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					dispose();
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(197, 265, 122, 31);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 111, 407, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(23, 30, 96, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(112, 24, 261, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(112, 69, 261, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPasswor = new JLabel("Password:");
		lblPasswor.setBounds(23, 75, 96, 13);
		panel.add(lblPasswor);
		lblPasswor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sc=new Scanner(new File("Korisnici.txt"));
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
						listk.add(a);
					}
				for(Korisnik k:listk) 
					if(k.username.compareTo(textField.getText().toString())==0)
						if(textField_1.getText().toString().compareTo(k.sifra)==1) {
							throw new Exception("Pogresli ste sifru");}
						else {
							dispose();
							OdabirProizvoda frame = new OdabirProizvoda();
							frame.setVisible(true);
						}
				}
							
			catch(Exception a){
				JOptionPane.showMessageDialog(null, a.getMessage());

			}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnLogIn.setBounds(170, 331, 179, 60);
		contentPane.add(btnLogIn);
	}
}
