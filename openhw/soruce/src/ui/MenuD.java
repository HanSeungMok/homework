package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import static javax.swing.ScrollPaneConstants.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
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
import javax.swing.JScrollPane;

public class MenuD extends JFrame {

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
	public MenuD() throws SQLException {
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
		
		JLabel label = new JLabel("\uBA54\uB274 \uC0AD\uC81C");
		label.setFont(new Font("돋움", Font.PLAIN, 15));
		label.setBounds(12, 0, 147, 36);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 540, 323);
		contentPane.add(scrollPane);
		int y=0;
		JPanel panel = new JPanel();
		dbConnect2();
		while(rs.next()) {
			int sql = rs.getInt("MenuID");
			//메뉴 아이디 저장
			JLabel Label=new JLabel(rs.getString("MName")+" / "+rs.getString("MPrice")+"원 / "+rs.getString("MEx"));
			//메뉴 이름, 가격, 타입을 설정
			Label.setPreferredSize(new Dimension(450,30));
			y=y+32;
			Label.setFont(new Font("굴림", Font.PLAIN, 15));
			panel.add(Label);
			JButton Butu =new JButton("x");
			Butu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					delete(sql);
					//삭제 함수(아이디)실행
					//query("delet", sql);
					try {
						new MenuD();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			});
			panel.add(Butu);
			
		}
		panel.setPreferredSize(new Dimension(520,y));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 38, 540, 323);
		scrollPane.setViewportView(panel);
		panel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
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
	public static void dbConnect2() {
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
        String sql = "Select * From menu";
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
	public void delete(int id) {
		//삭제 함수
        StringBuilder sb = new StringBuilder();
        String sql = sb.append("delete from menu where MenuID = ")
                .append(id)
                .append(";")
                .toString();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
