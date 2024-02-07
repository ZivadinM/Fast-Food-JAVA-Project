import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klase.Artikal;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OdabirProizvoda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static ArrayList <Artikal> lista=new ArrayList<>();
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
	public OdabirProizvoda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(-10, 33, 868, 297);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(22, 5, 128, 128);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("burger.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("Kolicina");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 138, 118, 19);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(60, 167, 52, 19);
		panel.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				if(textField.getText().isEmpty()) 
					throw new Exception("Morate popuniti kolicinu");
				Artikal a=new Artikal("Obrok",Integer.parseInt(textField.getText().toString()),500);
				lista.add(a);
				throw new Exception("Dodali ste novi artikal");
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(22, 196, 128, 30);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_4 = new JLabel("Cena: 500 RSD");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(16, 268, 141, 19);
		panel.add(lblNewLabel_1_4);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kolicina");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(27, 138, 118, 19);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(60, 167, 52, 19);
		
		panel_1.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				if(textField.getText().isEmpty()) 
					throw new Exception("Morate popuniti kolicinu");
				Artikal a=new Artikal("Pomfrit",Integer.parseInt(textField_1.getText().toString()),270);
				lista.add(a);				throw new Exception("Dodali ste novi artikal");
}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(22, 196, 128, 30);
		panel_1.add(btnNewButton_1);
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setBounds(-2, -19, 178, 187);
		panel_1.add(lblNewLabel1);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setIcon(new ImageIcon("french-fries.jpg"));
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Cena: 270 RSD");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(18, 268, 136, 19);
		panel_1.add(lblNewLabel_1_4_1);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kolicina");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(27, 138, 118, 19);
		panel_2.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(60, 167, 52, 19);
		textField_2.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		panel_2.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Dodaj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				if(textField.getText().isEmpty()) 
					throw new Exception("Morate popuniti kolicinu");
				Artikal a=new Artikal("Krilca",Integer.parseInt(textField_2.getText().toString()),350);
				lista.add(a);				throw new Exception("Dodali ste novi artikal");
}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(22, 196, 128, 30);
		panel_2.add(btnNewButton_2);
		JLabel lblNewLabe2 = new JLabel();
		lblNewLabe2.setBounds(-2, -19, 178, 187);
		panel_2.add(lblNewLabe2);
		lblNewLabe2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe2.setIcon(new ImageIcon("fried-chicken.jpg"));
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Cena: 350 RSD");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(18, 268, 136, 19);
		panel_2.add(lblNewLabel_1_4_2);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Kolicina");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(27, 138, 118, 19);
		panel_3.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(60, 167, 52, 19);
		panel_3.add(textField_3);
		textField_3.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		
		JButton btnNewButton_3 = new JButton("Dodaj");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				if(textField.getText().isEmpty()) 
					throw new Exception("Morate popuniti kolicinu");
				Artikal a=new Artikal("Palacinke",Integer.parseInt(textField_3.getText().toString()),350);
				lista.add(a);				throw new Exception("Dodali ste novi artikal");
}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(22, 196, 128, 30);
		panel_3.add(btnNewButton_3);
		JLabel lblNewLabe4 = new JLabel();
		lblNewLabe4.setBounds(-2, -17, 178, 187);
		panel_3.add(lblNewLabe4);
		lblNewLabe4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabe4.setIcon(new ImageIcon("pancake (2).jpg"));
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Cena: 300 RSD");
		lblNewLabel_1_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_3.setBounds(18, 268, 136, 19);
		panel_3.add(lblNewLabel_1_4_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_4.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Kolicina");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(27, 138, 118, 19);
		panel_3_1.add(lblNewLabel_1_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(60, 167, 52, 19);
		panel_3_1.add(textField_4);
		textField_4.addKeyListener(new KeyAdapter() {
			//obezbedjivanje unosa samo brojeva
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			
			}});
		
		JButton btnNewButton_3_1 = new JButton("Dodaj");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				if(textField.getText().isEmpty()) 
					throw new Exception("Morate popuniti kolicinu");
				Artikal a=new Artikal("Pizza",Integer.parseInt(textField_4.getText().toString()),220);
				lista.add(a);				throw new Exception("Dodali ste novi artikal");
}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_1.setBounds(22, 196, 128, 30);
		panel_3_1.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Cena: 220 RSD");
		lblNewLabel_1_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_4.setBounds(18, 268, 136, 19);
		panel_3_1.add(lblNewLabel_1_4_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(18, 10, 136, 128);
		panel_3_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("pizza.jpg"));

		
		JButton btnKorpa = new JButton("Korpa");
		btnKorpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				try {
					dispose();
					Korpa frame = new Korpa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnKorpa.setBounds(359, 357, 128, 30);
		btnKorpa.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnKorpa);
		
		JLabel lblNewLabel_1_5 = new JLabel("Obrok");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(21, 10, 118, 19);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Pomfrit");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5_1.setBounds(192, 10, 118, 19);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Krlica");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5_2.setBounds(364, 10, 118, 19);
		contentPane.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Palacinke");
		lblNewLabel_1_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5_3.setBounds(537, 10, 118, 19);
		contentPane.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_4 = new JLabel("Pizza");
		lblNewLabel_1_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5_4.setBounds(707, 10, 118, 19);
		contentPane.add(lblNewLabel_1_5_4);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
			dispose();
			Login frame = new Login();
			frame.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBounds(10, 366, 128, 30);
		contentPane.add(btnLogOut);

	}
}
