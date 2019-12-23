package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MainJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uD310\uB9E4\uD558\uAE30");
		btnNewButton.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Payment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnNewButton.setBounds(193, 61, 165, 43);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uAD00\uB9AC\uC790\uC811\uC18D");
		button.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		button.setBounds(193, 129, 165, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uD1B5\uACC4/\uC608\uCE21 \uD655\uC778");
		button_1.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		button_1.setBounds(193, 196, 165, 43);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Stat_Pred();
				setVisible(false);
			}
		});
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uB9C8\uAC10");
		button_2.setFont(new Font("µ¸¿ò", Font.PLAIN, 12));
		button_2.setBounds(193, 262, 165, 43);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DL();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		contentPane.add(button_2);
		setVisible(true);
	}
}
