package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.sql.*;

public class CancelP extends JFrame {

	private JPanel contentPane;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CancelP() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar mb = new JMenuBar(); 
		JMenu mainMenu = new JMenu("메인");
		int cL= checkL();
		JMenuItem menuItemM1 = new JMenuItem("메인 화면");
		mainMenu.add(menuItemM1);
		menuItemM1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainJFrame();
				setVisible(false);
			}
		});
		JMenuItem menuItemM2 = new JMenuItem("결제 화면");
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
		JMenuItem menuItemM3 = new JMenuItem("종료");
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
		
        JMenu mangerMenu = new JMenu("관리자");
		
        JMenuItem menuItemMNL = new JMenuItem("관리자 로그인");
        mangerMenu.add(menuItemMNL);
		menuItemMNL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});

        mangerMenu.addSeparator();
        JMenuItem menuItem = new JMenuItem("메뉴 관리");
        menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu();
				setVisible(false);
			}
		});
        mangerMenu.add(menuItem);
        JMenuItem menuItem_1 = new JMenuItem("메뉴 추가");
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
        JMenuItem menuItem_2 = new JMenuItem("메뉴 삭제");
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
        JMenuItem menuItem_3 = new JMenuItem("메뉴 수정");
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
        JMenuItem menuItem_4 = new JMenuItem("비밀번호 수정");
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
        JMenuItem menuItem_5 = new JMenuItem("로그아웃");
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
				try {
					new CancelP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JMenu SPMenu = new JMenu("통계/예측");
		JMenuItem menuItemSP1 = new JMenuItem("통계보기");
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
		JMenuItem menuItemSP2 = new JMenuItem("예측보기");
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
		
		JMenu DLMenu = new JMenu("마감");
		JMenuItem menuItemDL = new JMenuItem("마감화면");
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
		
		JLabel label = new JLabel("\uACB0\uC81C \uCDE8\uC18C");
		label.setFont(new Font("돋움", Font.PLAIN, 15));
		label.setBounds(12, 0, 147, 36);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 38, 540, 326);
		contentPane.add(panel);
		panel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		panel_1.setPreferredSize(new Dimension(530,75));
		
		JLabel lblNewLabel_1 = new JLabel("10:40");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.RED);
		JLabel lblNewLabel = new JLabel("1 \uBA54\uB274 2\uAC1C 11,000\uC6D0");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setPreferredSize(new Dimension(430,30));
		
		JButton btnNewButton = new JButton("x");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.setPreferredSize(new Dimension(40, 30));
		panel_1.add(btnNewButton);
		
		JLabel label_1 = new JLabel("       ");
		panel_1.add(label_1);
		label_1.setForeground(Color.RED);
		
		JLabel label_2 = new JLabel("2 \uBA54\uB274 1\uAC1C 4,000\uC6D0");
		panel_1.add(label_2);
		label_2.setPreferredSize(new Dimension(430, 30));
		label_2.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_1.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_2.setPreferredSize(new Dimension(530, 75));
		panel_2.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel.add(panel_2);
		
		JLabel label_3 = new JLabel("10:41");
		label_3.setForeground(Color.RED);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("1 \uBA54\uB274 1\uAC1C 5,500\uC6D0");
		label_4.setPreferredSize(new Dimension(430, 30));
		label_4.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_2.add(label_4);
		
		JButton button = new JButton("X");
		button.setPreferredSize(new Dimension(40, 30));
		button.setFont(new Font("굴림", Font.PLAIN, 13));
		panel_2.add(button);
		
		JLabel label_5 = new JLabel("       ");
		label_5.setForeground(Color.RED);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("2 \uBA54\uB274 2\uAC1C 8,000\uC6D0");
		label_6.setPreferredSize(new Dimension(430, 30));
		label_6.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_2.add(label_6);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(530, 75));
		panel_3.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel.add(panel_3);
		
		JLabel label_7 = new JLabel("10:45");
		label_7.setForeground(Color.RED);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("1 \uBA54\uB274 1\uAC1C 5,500\uC6D0");
		label_8.setPreferredSize(new Dimension(430, 30));
		label_8.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_3.add(label_8);
		
		JButton button_1 = new JButton("X");
		button_1.setPreferredSize(new Dimension(40, 30));
		button_1.setFont(new Font("굴림", Font.PLAIN, 13));
		panel_3.add(button_1);
		
		JLabel label_9 = new JLabel("       ");
		label_9.setForeground(Color.RED);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("3 \uBA54\uB274 1\uAC1C 8,000\uC6D0");
		label_10.setPreferredSize(new Dimension(430, 30));
		label_10.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_3.add(label_10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_4.setPreferredSize(new Dimension(530, 75));
		panel_4.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel.add(panel_4);
		
		JLabel label_11 = new JLabel("10:45");
		label_11.setForeground(Color.RED);
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("1 \uBA54\uB274 1\uAC1C 5,500\uC6D0");
		label_12.setPreferredSize(new Dimension(430, 30));
		label_12.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_4.add(label_12);
		
		JButton button_2 = new JButton("X");
		button_2.setPreferredSize(new Dimension(40, 30));
		button_2.setFont(new Font("굴림", Font.PLAIN, 13));
		panel_4.add(button_2);
		
		JLabel label_13 = new JLabel("       ");
		label_13.setForeground(Color.RED);
		panel_4.add(label_13);
		
		JLabel label_14 = new JLabel("3 \uBA54\uB274 1\uAC1C 8,000\uC6D0");
		label_14.setPreferredSize(new Dimension(430, 30));
		label_14.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_4.add(label_14);
		
		setVisible(true);
		
	}
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
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
            
            System.out.println("데이터베이스 연결 성공!");            
         
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!");
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
