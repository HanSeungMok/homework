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

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.TimeZone;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Payment extends JFrame {

	private JPanel contentPane;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	private int MI=0;
	private int SellI=0;
	private int SellA=0;
	private JTable table;
	private String meSe[][]=new String[100][2];
	static int x=0;
	private int y=0;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Payment() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 440);
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
					new Payment();
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
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		contentPane.add(table);
		
		JScrollPane SellS = new JScrollPane();
		SellS.setBounds(12, 28, 245, 227);
		contentPane.add(SellS);
		SellS.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel SellV = new JPanel();
		FlowLayout fl_SellV = (FlowLayout) SellV.getLayout();
		fl_SellV.setAlignment(FlowLayout.LEFT);

		SellV.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
		JPanel MenuV = new JPanel();
		MenuV.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		FlowLayout fl_MenuV = (FlowLayout) MenuV.getLayout();
		fl_MenuV.setAlignment(FlowLayout.LEFT);
		
		JScrollPane MenuS = new JScrollPane();
		MenuS.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		MenuS.setBounds(269, 28, 283, 276);
		contentPane.add(MenuS);
		JLabel NumH = new JLabel("");
		NumH.setPreferredSize(new Dimension(235,20));
		NumH.setBackground(Color.WHITE);
		NumH.setOpaque(true); 
		NumH.setText( String.format("%,d",SellA));
		dbConnect2();
		while(rs.next()) {
			//메뉴 들고옴.
			JButton SellB=new JButton(rs.getString("MName")+" / "+rs.getString("MPrice")+"원  / "+rs.getString("MEx"));
			//버튼을 메뉴 이름, 가격, 타입을 받아서 만듦.
			String MenuN=rs.getString("MName");
			SellB.setPreferredSize(new Dimension(270,30));
			MI=MI+32;
			String inmeSe=rs.getInt("MenuID")+"";
			System.out.println(inmeSe);
			int inX=x;
			y++;
			x++;
			SellB.setFont(new Font("굴림", Font.PLAIN, 15));
			MenuV.add(SellB);
			int SellSumA=rs.getInt("MPrice");
			
			SellB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JLabel label = new JLabel(MenuN);
					//위에서 만든 버튼을 클릭하면 메뉴 이름을 이용하여 라벨 생성
					SellA=SellA+SellSumA;
					//금액에 해당 메뉴 가격 +
					SellV.add(label);
					label.setPreferredSize(new Dimension(155,30));
					JLabel label2 = new JLabel("1");
					//갯수 설정
					label2.setPreferredSize(new Dimension(30, 30));
					label2.setOpaque(true);
					label2.setBackground(Color.WHITE);
					//배경 흰색
					SellV.add(label2);
					JPanel BuTe = new JPanel();
					//버튼을 묶어줄 패널 생성
					FlowLayout fl_BuTe = (FlowLayout) BuTe.getLayout();
					fl_BuTe.setVgap(0);
					fl_BuTe.setHgap(0);
					SellV.add(BuTe);
					BuTe.setPreferredSize(new Dimension(40,30));
					meSe[inX][0]=inmeSe;
					meSe[inX][1]=label2.getText();
					//금액 합산+데이터 저장을 위한 함수에 저장
					JButton UpBu = new JButton("\u25B2");
					UpBu.setFont(new Font("굴림", Font.PLAIN, 7));
					UpBu.setPreferredSize(new Dimension(40,15));
					UpBu.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int SuRa=Integer.parseInt(label2.getText());
							SuRa=SuRa+1;
							label2.setText(Integer.toString(SuRa));
							label2.setVisible(false);
							label2.setVisible(true);
							SellA=SellA+SellSumA;
							NumH.setText( String.format("%,d",SellA)+"원");
							meSe[inX][1]=label2.getText();
							
						}});
					
					BuTe.add(UpBu);
					
					JButton DoBu = new JButton("\u25BC");
					DoBu.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							//갯수 다운 버튼
							int SuRa=Integer.parseInt(label2.getText());
							SuRa=SuRa-1;
							label2.setText(Integer.toString(SuRa));
							label2.setVisible(false);
							label2.setVisible(true);
							SellA=SellA-SellSumA;
							NumH.setText( String.format("%,d",SellA)+"원");
							meSe[inX][1]=label2.getText();
							if(SuRa==0)
							{	
								//갯수가 0개 이하로 내려가면 내용 삭제
								label2.setVisible(false);
								label.setVisible(false);
								BuTe.setVisible(false);
								SellV.setVisible(false);
								SellV.setVisible(true);
								SellB.setEnabled(true);
								meSe[inX][0]=null;
								meSe[inX][1]=null;
							}
						}});
					DoBu.setPreferredSize(new Dimension(40, 15));
					DoBu.setFont(new Font("굴림", Font.PLAIN, 7));
					BuTe.add(DoBu);
					NumH.setText( String.format("%,d",SellA)+"원");
					SellV.setVisible(false);
					SellV.setVisible(true);
					SellI=SellI+32;
					SellB.setEnabled(false);
				}
			});}
		MenuV.setBounds(269, 28, 283, 276);
		MenuV.setPreferredSize(new Dimension(270,MI));
		SellV.setBounds(12, 28, 245, 227);
		SellV.setPreferredSize(new Dimension(235,SellI));
		MenuS.setViewportView(MenuV);
		SellS.setViewportView(SellV);
		JPanel PayH = new JPanel();
		FlowLayout fl_PayH = (FlowLayout) PayH.getLayout();
		PayH.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		fl_PayH.setAlignment(FlowLayout.LEFT);
		PayH.setBounds(12, 265, 245, 96);
		contentPane.add(PayH);
		JLabel label_1 = new JLabel("\uC8FC\uBB38 \uAE08\uC561");
		PayH.add(label_1);
		
		PayH.add(NumH);
		
		JButton card = new JButton("\uCE74\uB4DC \uACB0\uC81C");
		card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//meSe=checkNULL(meSe);
				int inx=0;
				meSe=checkNULL(meSe);
				String inMSLID=null;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
				Calendar c= Calendar.getInstance();
				String fromDate=sdf.format(c.getTime());
				//현재 시간을 받아 설정 MM월만 대문자인 이유는 mm월로 실행해보니 월이 이상하게 나와서 대문자로 바꿔보니 제대로 나옴!
				try {
					query("insert", "insert into sell values(null,'"+fromDate+"','0');");
					//판매 테이블에 날짜와, 결제 타입을 입력
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					rs=stmt.executeQuery("SELECT MAX(SellID) FROM sell;");
					//방금 입력한 테이블의 아이디를 받아 오기위해 max로 제일 높은 숫자를 받기 위한 sql문
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while (rs.next()) {
						inMSLID = rs.getString(1);
						//id를 받아옴
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(inx=0;inx<=x;inx++) {
					try {
						query("insert", "insert into menuselllist values('"+inMSLID+"','"+meSe[inx][0]+"','"+meSe[inx][1]+"');");
						//받은 id를 이용하여 메뉴와 갯수를 menuselllist에 입력.
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
}

				setVisible(false);
				try {
					new Payment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		card.setPreferredSize(new Dimension(115,40));
		PayH.add(card);
		
		JButton cash = new JButton("\uD604\uAE08 \uACB0\uC81C");
		cash.setPreferredSize(new Dimension(115, 40));
		cash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//meSe=checkNULL(meSe);
				int inx=0;
				meSe=checkNULL(meSe);
				String inMSLID=null;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
				Calendar c= Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
				String fromDate=sdf.format(c.getTime());
				try {
					query("insert", "insert into sell values(null,'"+fromDate+"','1');");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					rs=stmt.executeQuery("SELECT MAX(SellID) FROM sell;");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while (rs.next()) {
						inMSLID = rs.getString(1);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(inx=0;inx<x;inx++) {
					try {
						query("insert", "insert into menuselllist values('"+inMSLID+"','"+meSe[inx][0]+"','"+meSe[inx][1]+"');");
						System.out.println(inx+"반복문 안 inx");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	}
				setVisible(false);
				
				try {
					new Payment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("새항목 추가완료");
			}
		});
		PayH.add(cash);
		
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel label = new JLabel("\uBA54\uB274");
		label.setBounds(269, 10, 57, 15);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C \uCDE8\uC18C");
		btnNewButton.setBounds(269, 314, 283, 47);
		btnNewButton.setFont(new Font("돋움", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CancelP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
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
    		System.out.println("드라이버 검색 성공(메뉴)!");        
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
	
	public static void query(String order, String sql) throws SQLException {
		if (order == "Plus") {
			rs = stmt.executeQuery(sql);
		} 
		else {
			stmt.executeUpdate(sql);
		}
	}
	public static String[][] checkNULL(String [][] a){
		int inx;
		int sumx=0;
		String [][] b=new String[100][2];
		for(inx=0;inx<=x;inx++) {
			if(a[inx][0]!=null) {
				b[sumx][0]=a[inx][0];
				b[sumx][1]=a[inx][1];
				sumx++;
			}
		}
		x=sumx;
		return b;
	}
}