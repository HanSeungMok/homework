package ui;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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

public class Stat extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String driver, url;
	static Connection conn,conn2;
	static Statement stmt,stmt2;
	static ResultSet rs,rs2;
	static String header[] = {"a","b","c"};
	static String contens[][]=new String [400][3];
	static int x=0,y=0;
	static String setro= null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Stat() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar mb = new JMenuBar(); 
		JMenu mainMenu = new JMenu("메인");
		int cL= checkL();
		
		for(int i=0;i<300;i++) {
			contens[i][0]=null;
			contens[i][1]=null;
			contens[i][2]=null;
		}
		
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
		
		JLabel label = new JLabel("\uD1B5\uACC4\uBCF4\uAE30");
		label.setFont(new Font("돋움", Font.PLAIN, 15));
		label.setBounds(12, 0, 147, 36);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 540, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 38, 540, 290);
		contentPane.add(panel);
		panel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		
		JLabel lblNewLabel_1 = new JLabel("1\uC6D4");
		lblNewLabel_1.setForeground(Color.RED);
		panel.add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("32,900,000");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(490,30));
		
		JLabel label_1 = new JLabel("2\uC6D4");
		label_1.setForeground(Color.RED);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("32,770,000");
		label_2.setPreferredSize(new Dimension(490, 30));
		label_2.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("3\uC6D4");
		label_3.setForeground(Color.RED);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("31,800,000");
		label_4.setPreferredSize(new Dimension(490, 30));
		label_4.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("4\uC6D4");
		label_5.setForeground(Color.RED);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("29,900,000");
		label_6.setPreferredSize(new Dimension(490, 30));
		label_6.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("5\uC6D4");
		label_7.setForeground(Color.RED);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("28,950,000");
		label_8.setPreferredSize(new Dimension(490, 30));
		label_8.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("6\uC6D4");
		label_9.setForeground(Color.RED);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("27,800,000");
		label_10.setPreferredSize(new Dimension(490, 30));
		label_10.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("7\uC6D4");
		label_11.setForeground(Color.RED);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("27,590,000");
		label_12.setPreferredSize(new Dimension(490, 30));
		label_12.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("8\uC6D4");
		label_13.setForeground(Color.RED);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("28,900,000");
		label_14.setPreferredSize(new Dimension(490, 30));
		label_14.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(label_14);
		
		JRadioButton monthradio = new JRadioButton("\uC6D4 \uBCC4");
		monthradio.setBounds(12, 334, 58, 23);
		contentPane.add(monthradio);
		
		JRadioButton menuradio = new JRadioButton("\uBA54\uB274 \uBCC4");
		menuradio.setBounds(350, 334, 70, 23);
		contentPane.add(menuradio);
		
		JRadioButton typeradio = new JRadioButton("\uACB0\uC81C \uD0C0\uC785 \uBCC4");
		typeradio.setBounds(440, 334, 102, 23);
		contentPane.add(typeradio);
		
		JRadioButton timeradio = new JRadioButton("\uC2DC\uAC04 \uBCC4");
		timeradio.setBounds(89, 334, 70, 23);
		contentPane.add(timeradio);
		
		JRadioButton quarterradio = new JRadioButton("\uBD84\uAE30 \uBCC4");
		quarterradio.setBounds(167, 334, 70, 23);
		contentPane.add(quarterradio);
		
		JRadioButton dayradio = new JRadioButton("\uC77C\uC790 \uBCC4");
		dayradio.setBounds(260, 334, 70, 23);
		contentPane.add(dayradio);
		setVisible(true);
		
		ActionListener actionListener = new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   if(monthradio.isSelected()==true) {
					   if(menuradio.isSelected()==true) {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<13;i++) {
								contens[x][0]=i+"월";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								contens[x][1]="";
								contens[x][2]="";
								x++;
								try {
									rs=stmt.executeQuery("Select * FROM menu");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
								}
								try {
									while(rs.next()) {
										String menun= rs.getString("MName");
										String menid= rs.getString("MenuID");
										String menPR= rs.getString("MPrice");
										contens[x][0]=menun;
										contens[x][1]="";
										contens[x][2]="";
										x++;
										contens[x][0]="카드 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '0';");
										//통계에서 조건을 주고 갯수를 더하는 sql문
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										System.out.println(contens[x][1]+"while 확인 뒤");
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										System.out.println(contens[x][0]+",카드 확인");
										System.out.println(contens[x][1]+",카드 확인");
										System.out.println(contens[x][2]+",카드 확인");
										x++;
										contens[x][0]="현금 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '1';");
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										while(rs2.next()) {
											contens[x][2]=rs2.getString(1);
										}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										x++;
									}
								} catch (NumberFormatException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}}}
								else {
									x=0;
									for(int i=1;i<13;i++) {
									contens[x][0]=i+"월";
									contens[x][1]="";
									contens[x][2]="";
									x++;
									try {
										rs2=stmt2	.executeQuery("Select * FROM menu");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs2.next()) {
											String menun= rs2.getString("MName");
											String menid= rs2.getString("MenuID");
											String menPR= rs2.getString("MPrice");
											contens[x][0]=menun;
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+i+"월%' "
															+ "AND menuselllist.MID like'"+menid+"';");
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
												
											}
											else {
												setro=contens[x][1];
												contens[x][1]=contens[x][1]+"개";}
											
											if(contens[x][1]=="없음") {
												contens[x][2]="없음";
											}else {
												contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
											}
											System.out.println(contens[x][0]+","+contens[x][1]+","+contens[x][2]+"메뉴만 확인");
											x++;
}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					   else {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<13;i++) {
								contens[x][0]=i+"월";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								contens[x][1]="";
								contens[x][2]="";
								x++;
								int sumP=0;
									contens[x][0]="카드 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND sell.MOP like '0';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
										contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND sell.MOP like '0'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									contens[x][0]="현금 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND sell.MOP like '1';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"월%'"
														+ " AND sell.MOP like '1'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									
								}}
								else {
									x=0;
									for(int i=1;i<13;i++) {
										int sumP=0;
									contens[x][0]=i+"월";
									String mon=null;
									if(i<10) {
										mon="0"+i;
									}
									else {
										mon=i+"";
									}
									
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)as likeqd"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON sell.SellID = menuselllist.MSLID"
												+ " WHERE sell.STime like '%"+mon+"월%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"월%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
											System.out.println(sumP);
										}else {
										sumP=Integer.parseInt(contens[x][2]);}

									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
										System.out.println(contens[x][2]+"가격");
									}
									
									x++;
								}
									
							}
					   }
					}
				   else if(timeradio.isSelected()==true) {
					   if(menuradio.isSelected()==true) {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<25;i++) {
								contens[x][0]=i+"시";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								System.out.println(contens[x][0]);
								contens[x][1]="";
								contens[x][2]="";
								x++;
								try {
									System.out.println("rs2 확인 앞");
									rs=stmt.executeQuery("Select * FROM menu");
									System.out.println("rs2 확인 뒤");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
								}
								try {
									while(rs.next()) {
										String menun= rs.getString("MName");
										String menid= rs.getString("MenuID");
										String menPR= rs.getString("MPrice");
										contens[x][0]=menun;
										contens[x][1]="";
										contens[x][2]="";
										x++;
										contens[x][0]="카드 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '0';");
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										System.out.println(contens[x][1]+"while 확인 뒤");
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										System.out.println(contens[x][0]+",카드 확인");
										System.out.println(contens[x][1]+",카드 확인");
										System.out.println(contens[x][2]+",카드 확인");
										x++;
										contens[x][0]="현금 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '1';");
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										while(rs2.next()) {
											contens[x][2]=rs2.getString(1);
										}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										x++;
									}
								} catch (NumberFormatException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}}}
								else {
									x=0;
									for(int i=1;i<25;i++) {
									contens[x][0]=i+"시";
									contens[x][1]="";
									contens[x][2]="";
									x++;
									try {
										rs2=stmt2	.executeQuery("Select * FROM menu");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs2.next()) {
											String menun= rs2.getString("MName");
											String menid= rs2.getString("MenuID");
											String menPR= rs2.getString("MPrice");
											contens[x][0]=menun;
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+i+"시%' "
															+ "AND menuselllist.MID like'"+menid+"';");
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
												
											}
											else {
												setro=contens[x][1];
												contens[x][1]=contens[x][1]+"개";}
											
											if(contens[x][1]=="없음") {
												contens[x][2]="없음";
											}else {
												contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
											}
											System.out.println(contens[x][0]+","+contens[x][1]+","+contens[x][2]+"메뉴만 확인");
											x++;
}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					   else {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<25;i++) {
								contens[x][0]=i+"시";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								contens[x][1]="";
								contens[x][2]="";
								x++;
								int sumP=0;
									contens[x][0]="카드 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND sell.MOP like '0';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
										contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND sell.MOP like '0'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									contens[x][0]="현금 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND sell.MOP like '1';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"시%'"
														+ " AND sell.MOP like '1'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									
								}}
								else {
									x=0;
									for(int i=1;i<25;i++) {
										int sumP=0;
									contens[x][0]=i+"시";
									String mon=null;
									if(i<10) {
										mon="0"+i;
									}
									else {
										mon=i+"";
									}
									
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)as likeqd"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON sell.SellID = menuselllist.MSLID"
												+ " WHERE sell.STime like '%"+mon+"시%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"시%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
											System.out.println(sumP);
										}else {
										sumP=Integer.parseInt(contens[x][2]);}

									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
										System.out.println(contens[x][2]+"가격");
									}
									
									x++;
								}
									
							}
					   }
					}
				   else if(dayradio.isSelected()==true)
				   {
					   if(menuradio.isSelected()==true) {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<32;i++) {
								contens[x][0]=i+"일";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								System.out.println(contens[x][0]);
								contens[x][1]="";
								contens[x][2]="";
								x++;
								try {
									System.out.println("rs2 확인 앞");
									rs=stmt.executeQuery("Select * FROM menu");
									System.out.println("rs2 확인 뒤");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
								}
								try {
									while(rs.next()) {
										String menun= rs.getString("MName");
										String menid= rs.getString("MenuID");
										String menPR= rs.getString("MPrice");
										contens[x][0]=menun;
										contens[x][1]="";
										contens[x][2]="";
										x++;
										contens[x][0]="카드 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '0';");
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										System.out.println(contens[x][1]+"while 확인 뒤");
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										System.out.println(contens[x][0]+",카드 확인");
										System.out.println(contens[x][1]+",카드 확인");
										System.out.println(contens[x][2]+",카드 확인");
										x++;
										contens[x][0]="현금 결제";
										rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '1';");
										while(rs2.next()) {
											contens[x][1]=rs2.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											setro=contens[x][1];
											contens[x][1]=contens[x][1]+"개";}
										while(rs2.next()) {
											contens[x][2]=rs2.getString(1);
										}
										if(contens[x][1]=="없음") {
											contens[x][2]="없음";
										}else {
											contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
										}
										x++;
									}
								} catch (NumberFormatException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}}}
								else {
									x=0;
									for(int i=1;i<32;i++) {
									contens[x][0]=i+"일";
									contens[x][1]="";
									contens[x][2]="";
									x++;
									try {
										rs2=stmt2	.executeQuery("Select * FROM menu");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs2.next()) {
											String menun= rs2.getString("MName");
											String menid= rs2.getString("MenuID");
											String menPR= rs2.getString("MPrice");
											contens[x][0]=menun;
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+i+"일%' "
															+ "AND menuselllist.MID like'"+menid+"';");
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
												
											}
											else {
												setro=contens[x][1];
												contens[x][1]=contens[x][1]+"개";}
											
											if(contens[x][1]=="없음") {
												contens[x][2]="없음";
											}else {
												contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
											}
											System.out.println(contens[x][0]+","+contens[x][1]+","+contens[x][2]+"메뉴만 확인");
											x++;
}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					   else {
						   if(typeradio.isSelected()==true) {
								x=0;
								for(int i=1;i<32;i++) {
								contens[x][0]=i+"일";
								String mon=null;
								if(i<10) {
									mon="0"+i;
								}
								else {
									mon=i+"";
								}
								contens[x][1]="";
								contens[x][2]="";
								x++;
								int sumP=0;
									contens[x][0]="카드 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND sell.MOP like '0';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
										contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND sell.MOP like '0'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									contens[x][0]="현금 결제";
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
												+ " FROM sell INNER JOIN menuselllist"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND sell.MOP like '1';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"일%'"
														+ " AND sell.MOP like '1'");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
										}else {
										sumP=Integer.parseInt(contens[x][2]);}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
									}
									x++;
									
								}}
								else {
									x=0;
									for(int i=1;i<32;i++) {
										int sumP=0;
									contens[x][0]=i+"일";
									String mon=null;
									if(i<10) {
										mon="0"+i;
									}
									else {
										mon=i+"";
									}
									
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count)as likeqd"
												+ " FROM sell"
												+ " INNER JOIN menuselllist"
												+ " ON sell.SellID = menuselllist.MSLID"
												+ " WHERE sell.STime like '%"+mon+"일%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][1]=rs.getString(1);
										}
										if(contens[x][1]==null) {
											contens[x][1]="없음";
										}
										else {
											contens[x][1]=contens[x][1]+"개";}
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
												+ " FROM menuselllist"
												+ " INNER JOIN sell"
												+ " ON menuselllist.MSLID = sell.SellID"
												+ " INNER JOIN menu"
												+ " ON menu.MenuID=menuselllist.MID"
												+ " WHERE sell.STime like '%"+mon+"일%';");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											contens[x][2]=rs.getString(1);
										}
										if(contens[x][2]==null) {
											sumP=0;
											System.out.println(sumP);
										}else {
										sumP=Integer.parseInt(contens[x][2]);}

									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									if(sumP!=0) {
										contens[x][2]=String.format("%,d",sumP)+"원";
									}
									else {
										contens[x][2]="없음";
										System.out.println(contens[x][2]+"가격");
									}
									
									x++;
								}
									
							}
					   }
					}else if(quarterradio.isSelected()==true)
					   {
						   if(menuradio.isSelected()==true) {
							   if(typeradio.isSelected()==true) {
									x=0;
									for(int i=1;i<32;i++) {
									contens[x][0]=i+"일";
									String mon=null;
									if(i<10) {
										mon="0"+i;
									}
									else {
										mon=i+"";
									}
									System.out.println(contens[x][0]);
									contens[x][1]="";
									contens[x][2]="";
									x++;
									try {
										System.out.println("rs2 확인 앞");
										rs=stmt.executeQuery("Select * FROM menu");
										System.out.println("rs2 확인 뒤");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										//e1.printStackTrace();
									}
									try {
										while(rs.next()) {
											String menun= rs.getString("MName");
											String menid= rs.getString("MenuID");
											String menPR= rs.getString("MPrice");
											contens[x][0]=menun;
											contens[x][1]="";
											contens[x][2]="";
											x++;
											contens[x][0]="카드 결제";
											if(mon=="1") {
												
											}
											rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE (sell.STime like '%01월%' OR sell.STime like '%02월%' OR sell.STime like '%03월%')"
															+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '0';");
											while(rs2.next()) {
												contens[x][1]=rs2.getString(1);
											}
											System.out.println(contens[x][1]+"while 확인 뒤");
											if(contens[x][1]==null) {
												contens[x][1]="없음";
											}
											else {
												setro=contens[x][1];
												contens[x][1]=contens[x][1]+"개";}
											if(contens[x][1]=="없음") {
												contens[x][2]="없음";
											}else {
												contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
											}
											System.out.println(contens[x][0]+",카드 확인");
											System.out.println(contens[x][1]+",카드 확인");
											System.out.println(contens[x][2]+",카드 확인");
											x++;
											contens[x][0]="현금 결제";
											rs2=stmt2.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+mon+"일%'"
															+ " AND menuselllist.MID like'"+menid+"' AND sell.MOP like '1';");
											while(rs2.next()) {
												contens[x][1]=rs2.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
											}
											else {
												setro=contens[x][1];
												contens[x][1]=contens[x][1]+"개";}
											while(rs2.next()) {
												contens[x][2]=rs2.getString(1);
											}
											if(contens[x][1]=="없음") {
												contens[x][2]="없음";
											}else {
												contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
											}
											x++;
										}
									} catch (NumberFormatException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}}}
									else {
										x=0;
										for(int i=1;i<32;i++) {
										contens[x][0]=i+"일";
										contens[x][1]="";
										contens[x][2]="";
										x++;
										try {
											rs2=stmt2	.executeQuery("Select * FROM menu");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											while(rs2.next()) {
												String menun= rs2.getString("MName");
												String menid= rs2.getString("MenuID");
												String menPR= rs2.getString("MPrice");
												contens[x][0]=menun;
												rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
														+ " FROM sell"
														+ " INNER JOIN menuselllist"
														+ " ON menuselllist.MSLID = sell.SellID"
														+ " WHERE sell.STime like '%"+i+"일%' "
																+ "AND menuselllist.MID like'"+menid+"';");
												while(rs.next()) {
													contens[x][1]=rs.getString(1);
												}
												if(contens[x][1]==null) {
													contens[x][1]="없음";
													
												}
												else {
													setro=contens[x][1];
													contens[x][1]=contens[x][1]+"개";}
												
												if(contens[x][1]=="없음") {
													contens[x][2]="없음";
												}else {
													contens[x][2]=String.format("%,d",Integer.parseInt(setro)*Integer.parseInt(menPR))+"원";
												}
												System.out.println(contens[x][0]+","+contens[x][1]+","+contens[x][2]+"메뉴만 확인");
												x++;
	}
										} catch (NumberFormatException | SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							}
						   else {
							   if(typeradio.isSelected()==true) {
									x=0;
									for(int i=1;i<32;i++) {
									contens[x][0]=i+"일";
									String mon=null;
									if(i<10) {
										mon="0"+i;
									}
									else {
										mon=i+"";
									}
									contens[x][1]="";
									contens[x][2]="";
									x++;
									int sumP=0;
										contens[x][0]="카드 결제";
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+mon+"일%'"
															+ " AND sell.MOP like '0';");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
											}
											else {
											contens[x][1]=contens[x][1]+"개";}
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
													+ " FROM menuselllist"
													+ " INNER JOIN sell"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " INNER JOIN menu"
													+ " ON menu.MenuID=menuselllist.MID"
													+ " WHERE sell.STime like '%"+mon+"일%'"
															+ " AND sell.MOP like '0'");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											while(rs.next()) {
												contens[x][2]=rs.getString(1);
											}
											if(contens[x][2]==null) {
												sumP=0;
											}else {
											sumP=Integer.parseInt(contens[x][2]);}
										} catch (NumberFormatException | SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										if(sumP!=0) {
											contens[x][2]=String.format("%,d",sumP)+"원";
										}
										else {
											contens[x][2]="없음";
										}
										x++;
										contens[x][0]="현금 결제";
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)"
													+ " FROM sell INNER JOIN menuselllist"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " WHERE sell.STime like '%"+mon+"일%'"
															+ " AND sell.MOP like '1';");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
											}
											else {
												contens[x][1]=contens[x][1]+"개";}
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
													+ " FROM menuselllist"
													+ " INNER JOIN sell"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " INNER JOIN menu"
													+ " ON menu.MenuID=menuselllist.MID"
													+ " WHERE sell.STime like '%"+mon+"일%'"
															+ " AND sell.MOP like '1'");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										try {
											while(rs.next()) {
												contens[x][2]=rs.getString(1);
											}
											if(contens[x][2]==null) {
												sumP=0;
											}else {
											sumP=Integer.parseInt(contens[x][2]);}
										} catch (NumberFormatException | SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										if(sumP!=0) {
											contens[x][2]=String.format("%,d",sumP)+"원";
										}
										else {
											contens[x][2]="없음";
										}
										x++;
										
									}}
									else {
										x=0;
										for(int i=1;i<32;i++) {
											int sumP=0;
										contens[x][0]=i+"일";
										String mon=null;
										if(i<10) {
											mon="0"+i;
										}
										else {
											mon=i+"";
										}
										
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count)as likeqd"
													+ " FROM sell"
													+ " INNER JOIN menuselllist"
													+ " ON sell.SellID = menuselllist.MSLID"
													+ " WHERE sell.STime like '%"+mon+"일%';");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											//e1.printStackTrace();
										}
										try {
											while(rs.next()) {
												contens[x][1]=rs.getString(1);
											}
											if(contens[x][1]==null) {
												contens[x][1]="없음";
											}
											else {
												contens[x][1]=contens[x][1]+"개";}
											
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											//e1.printStackTrace();
										}
										try {
											rs=stmt.executeQuery("Select SUM(menuselllist.Count*menu.MPrice)"
													+ " FROM menuselllist"
													+ " INNER JOIN sell"
													+ " ON menuselllist.MSLID = sell.SellID"
													+ " INNER JOIN menu"
													+ " ON menu.MenuID=menuselllist.MID"
													+ " WHERE sell.STime like '%"+mon+"일%';");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											//e1.printStackTrace();
										}
										try {
											while(rs.next()) {
												contens[x][2]=rs.getString(1);
											}
											if(contens[x][2]==null) {
												sumP=0;
												System.out.println(sumP);
											}else {
											sumP=Integer.parseInt(contens[x][2]);}

										} catch (NumberFormatException | SQLException e1) {
											// TODO Auto-generated catch block
											//e1.printStackTrace();
										}
										if(sumP!=0) {
											contens[x][2]=String.format("%,d",sumP)+"원";
										}
										else {
											contens[x][2]="없음";
											System.out.println(contens[x][2]+"가격");
										}
										
										x++;
									}
										
								}
						   }
						}
				   int ix=x;
				   for(;ix<300;ix++) {
						contens[ix][0]=null;
						contens[ix][1]=null;
						contens[ix][2]=null;
					}
				   String atu[][]=new String[x][3];
				   for(int au=0;au<x;au++) {
						atu[au][0]=contens[au][0];
						atu[au][1]=contens[au][1];
						atu[au][2]=contens[au][2];
					}
				   table = new JTable(atu,header);
				   table.setTableHeader(null);
					table.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
					table.setShowGrid(false);
					table.setShowVerticalLines(false);
					table.setShowHorizontalLines(false);
					
					scrollPane.setViewportView(table);
					table.setVisible(false);
					table.setVisible(true);
					}
			  };
		dayradio.addActionListener(actionListener);
		monthradio.addActionListener(actionListener);
		quarterradio.addActionListener(actionListener);
		timeradio.addActionListener(actionListener);
		typeradio.addActionListener(actionListener);
		menuradio.addActionListener(actionListener);
		
		ButtonGroup  group = new ButtonGroup();
		
		group.add(dayradio); group.add(monthradio); group.add(quarterradio); group.add(timeradio);
		
		
//		table.;
		
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
            conn2 = DriverManager.getConnection(url,"root","apmsetup");
            stmt2 = conn.createStatement( );

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
