package ui;


import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField IdTexF;
	private JTextField passwordTexF;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		IdTexF = new JTextField();
		IdTexF.setBounds(150, 168, 134, 21);
		contentPane.add(IdTexF);
		IdTexF.setColumns(10);
		
		passwordTexF = new JTextField();
		passwordTexF.setBounds(150, 211, 134, 21);
		contentPane.add(passwordTexF);
		passwordTexF.setColumns(10);
		
		dbConnect();
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(308, 164, 123, 68);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String search="select * from mli where MangerID like '"+IdTexF.getText()+"';";
					//id �ؽ�Ʈ�� �޾� mli ���̺� �ش� ���� ��� �ִ� ������ ��� �´�.
					rs = stmt.executeQuery(search);
					if(rs.next()) {
						//id ���� ��� �ִ� ������ �ִٸ�
						if(passwordTexF.getText().equals(rs.getString("MangerPW"))) {
							//password �ؽ�Ʈ�� ���� ��� �ͼ� �ش� ���̵� ���� ���ð� ��й�ȣ�� ������ Ȯ���Ѵ�.
							System.out.print("�α��� ����");
							new Manger();
							//������ ȭ���� �Ѿ��.
							String Modified="update mli set MangerID='"+IdTexF.getText()+"', MangerPW='"+passwordTexF.getText()+"', checkL = '1'";
							 stmt.executeUpdate(Modified);
							//�α��� ���¸� ������Ʈ �Ѵ�.
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.WARNING_MESSAGE);
							//�α��� ���з� ����â�� ����.
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		label.setFont(new Font("����", Font.PLAIN, 15));
		label.setBounds(225, 118, 147, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setBounds(102, 171, 40, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setBounds(90, 214, 52, 15);
		contentPane.add(label_2);
		
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
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		} 
		else{
			stmt.executeUpdate(sql);
		}
	}
}