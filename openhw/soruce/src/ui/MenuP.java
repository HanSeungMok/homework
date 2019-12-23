package ui;




import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ui.Menu;

public class MenuP extends JFrame {

	private JPanel contentPane;
	private JTextField MenuN;
	private JTextField MenuP;
	private JTextField MenuT;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String driver, url;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuP() throws SQLException {
		dbConnect();
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
		
		
		MenuN = new JTextField();
		MenuN.setBounds(182, 126, 134, 21);
		contentPane.add(MenuN);
		MenuN.setColumns(10);
		
		MenuP = new JTextField();
		MenuP.setBounds(182, 170, 134, 21);
		contentPane.add(MenuP);
		MenuP.setColumns(10);
		
		
		
		
		
		MenuT = new JTextField();
		MenuT.setColumns(10);
		MenuT.setBounds(182, 214, 134, 21);
		contentPane.add(MenuT);
		
		
		JButton Plus = new JButton("\uCD94\uAC00");
		Plus.setFont(new Font("����", Font.PLAIN, 12));
		Plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				
				try {
					query("insert", "insert into menu values(null,'"+MenuN.getText()+"','"+MenuP.getText()+"','"+MenuT.getText()+"')");
					//���ο� �޴� �߰� �ڵ�
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				System.out.println("���׸� �߰��Ϸ�");

				MenuN.setText("");
				MenuP.setText("");
				MenuT.setText("");
				//�߰� �� ���� ����
			}
		});
		Plus.setBounds(328, 143, 102, 68);
		contentPane.add(Plus);
		JLabel label = new JLabel("\uBA54\uB274 \uCD94\uAC00");
		label.setFont(new Font("����", Font.PLAIN, 15));
		label.setBounds(225, 66, 147, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uBA54\uB274 \uC774\uB984");
		label_1.setBounds(110, 129, 60, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uAC00\uACA9");
		label_2.setBounds(138, 173, 32, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\uBA54\uB274 \uC124\uBA85(\uD0C0\uC785)");
		label_3.setBounds(74, 217, 96, 15);
		contentPane.add(label_3);
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
	public static void query(String order, String sql) throws SQLException {
		if (order == "Plus") {
			rs = stmt.executeQuery(sql);
		} 
		else {
			stmt.executeUpdate(sql);
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
}

