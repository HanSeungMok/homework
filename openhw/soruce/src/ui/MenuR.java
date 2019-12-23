package ui;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class MenuR extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String driver, url,Rtext;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static int Idget=0;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuR() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar mb = new JMenuBar(); 
		JMenu mainMenu = new JMenu("����");
		int cL= checkL();
		
		JMenuItem menuItemM1 = new JMenuItem("���� ȭ��");
		mainMenu.add(menuItemM1);
		menuItemM1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainJFrame();
				setVisible(false);
			}
		});
		JMenuItem menuItemM2 = new JMenuItem("���� ȭ��");
		mainMenu.add(menuItemM2);
		menuItemM2.addActionListener(new ActionListener() {
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
		mainMenu.addSeparator();
		JMenuItem menuItemM3 = new JMenuItem("����");
		mainMenu.add(menuItemM3);
		menuItemM3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Modified="update mli set checkL = '0'";
				 try {
					stmt.executeUpdate(Modified);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				System.exit(0);
				
			}
		});

		mb.add(mainMenu);
		
        JMenu mangerMenu = new JMenu("������");
		
        JMenuItem menuItemMNL = new JMenuItem("������ �α���");
        mangerMenu.add(menuItemMNL);
		menuItemMNL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});

        mangerMenu.addSeparator();
        JMenuItem menuItem = new JMenuItem("�޴� ����");
        menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu();
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem);
        JMenuItem menuItem_1 = new JMenuItem("�޴� �߰�");
        menuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new MenuP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem_1);
        JMenuItem menuItem_2 = new JMenuItem("�޴� ����");
        menuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new MenuD();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem_2);
        JMenuItem menuItem_3 = new JMenuItem("�޴� ����");
        menuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new MenuR();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem_3);
        mangerMenu.addSeparator();
        JMenuItem menuItem_4 = new JMenuItem("��й�ȣ ����");
        menuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new PWR();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem_4);
        mangerMenu.addSeparator();
        JMenuItem menuItem_5 = new JMenuItem("�α׾ƿ�");
        mangerMenu.add(menuItem_5);
        menuItem_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Modified="update mli set checkL = '0'";
				 try {
					stmt.executeUpdate(Modified);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				setVisible(false);
				new MainJFrame();
			}
		});
        if(cL==0){
        	menuItem.setEnabled(false);
        	menuItem_4.setEnabled(false);
            menuItem_2.setEnabled(false);
        	menuItem_3.setEnabled(false);
            menuItem_1.setEnabled(false);
            menuItem_5.setEnabled(false);
        }
		mb.add(mangerMenu);
		
		JMenu SPMenu = new JMenu("���/����");
		JMenuItem menuItemSP1 = new JMenuItem("��躸��");
		SPMenu.add(menuItemSP1);
		menuItemSP1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Stat();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		JMenuItem menuItemSP2 = new JMenuItem("��������");
		SPMenu.add(menuItemSP2);
		menuItemSP2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Pred();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		
		mb.add(SPMenu);
		
		JMenu DLMenu = new JMenu("����");
		JMenuItem menuItemDL = new JMenuItem("����ȭ��");
		DLMenu.add(menuItemDL);
		menuItemDL.addActionListener(new ActionListener() {
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
		
		mb.add(DLMenu);
		
		setJMenuBar(mb);
		
		
		JLabel label = new JLabel("\uBA54\uB274 \uC218\uC815");
		label.setFont(new Font("����", Font.PLAIN, 15));
		label.setBounds(12, 0, 147, 36);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 38, 540, 172);
		contentPane.add(scrollPane);
		int y=0;
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel_1.setBounds(12, 220, 540, 142);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC14\uAFB8\uAE30 \uC804 \uBA54\uB274");
		panel_1.add(lblNewLabel_1);
		
		JLabel RMT = new JLabel("");
		RMT.setPreferredSize(new Dimension(480, 20));
		RMT.setFont(new Font("����", Font.PLAIN, 13));
		panel_1.add(RMT);
		
		JLabel label_6 = new JLabel("\uBC14\uAFC0 \uB0B4\uC6A9");
		panel_1.add(label_6);
		label_6.setPreferredSize(new Dimension(480, 20));
		JButton button_4 = new JButton("\uBA54\uB274 \uC774\uB984");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Rtext="MName";
				label_6.setText("�ٲ� ����: �޴� �̸�");
			}
		});
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("\uAC00\uACA9");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Rtext="MPrice";
				label_6.setText("�ٲ� ����: ����");
			}
		});
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("\uBA54\uB274 \uD0C0\uC785");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Rtext="MEx";
				label_6.setText("�ٲ� ����: �޴� Ÿ��");
			}
		});
		panel_1.add(button_6);
		
		textField = new JTextField();
		panel_1.add(textField);
		
		textField.setColumns(41);
		
		JButton button_7 = new JButton("\uC218\uC815");
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()<=0||RMT.getText()=="") {
					JOptionPane.showMessageDialog(null, "������ ����", "�������", JOptionPane.WARNING_MESSAGE);
					//���� ���� Ȯ��
				}
				else if(Rtext=="MEx"){
					String Modified="update menu set Mex='"+textField.getText()+"' WHERE MenuID = '"+Idget+"';";
					//������ ������ Ÿ�� Ȯ��, �޴� ID�� �̿��Ͽ� ���� ����.
					try {
						stmt.executeUpdate(Modified);
						//����
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					try {
						new MenuR();
						//���� ������ ���� ���� ����.
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					setVisible(false);
				}
				else if(Rtext=="MPrice"){
					String Modified="update menu set MPrice='"+textField.getText()+"' WHERE MenuID = '"+Idget+"';";
					try {
						stmt.executeUpdate(Modified);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						new MenuR();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
				else if(Rtext=="MName"){
					String Modified="update menu set MName='"+textField.getText()+"'WHERE MenuID = '"+Idget+"';";
					try {
						stmt.executeUpdate(Modified);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						new MenuR();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		panel_1.add(button_7);
		dbConnect2();
		while(rs.next()) {
			int IDget=rs.getInt("MenuID");
			JLabel Label=new JLabel(rs.getString("MName")+" / "+rs.getString("MPrice")+"��  / "+rs.getString("MEx"));
			Label.setPreferredSize(new Dimension(450,30));
			y=y+32;
			Label.setFont(new Font("����", Font.PLAIN, 15));
			panel.add(Label);
			JButton Butu =new JButton("����");
			Butu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				 RMT.setText(Label.getText());
				 Idget=IDget;
				}
			});
			panel.add(Butu);
		
		}
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 38, 540, 184);
		panel.setPreferredSize(new Dimension(520,y));
		scrollPane.setViewportView(panel);
		panel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
		
		setVisible(true);
	}
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("����̹� �˻� ����!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:possystem";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/possystem?useUnicode=yes&characterEncoding=UTF8";
        String sql = "Select * From mli";
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("�����ͺ��̽� ���� ����!");            
         
        }
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����!");
        }
	}
	public static int checkL() throws SQLException {
		dbConnect();
		String search="select * from mli where checkL like '1';";
		rs = stmt.executeQuery(search);
		if(rs.next()) 
		return 1;
		else
		return 0;
	}
	public static void dbConnect2() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("����̹� �˻� ����!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:possystem";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/possystem?useUnicode=yes&characterEncoding=UTF8";
        String sql = "Select * From menu";
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("�����ͺ��̽� ���� ����!");            
         
        }
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����!");
        }
	}
}
