import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainS {

	private JFrame frame;
	private JTextField txtKodeMenu;
	private JTextField txtNamaMenu;
	private JTextField txtHargaMenu;
	private JTextField txtStokMenu;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainS window = new MainS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainS() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 400);
		frame.setTitle("Pudding Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{217, 217, 0};
		gridBagLayout.rowHeights = new int[]{29, 29, 29, 29, 29, 29, 29, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Kode Menu (PD-XXX)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtKodeMenu = new JTextField();
		txtKodeMenu.setText("");
		GridBagConstraints gbc_txtKodeMenu = new GridBagConstraints();
		gbc_txtKodeMenu.fill = GridBagConstraints.BOTH;
		gbc_txtKodeMenu.insets = new Insets(0, 0, 5, 0);
		gbc_txtKodeMenu.gridx = 1;
		gbc_txtKodeMenu.gridy = 0;
		frame.getContentPane().add(txtKodeMenu, gbc_txtKodeMenu);
		txtKodeMenu.setColumns(10);
		
		JLabel lblNamaMenu = new JLabel("Nama Menu");
		lblNamaMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNamaMenu = new GridBagConstraints();
		gbc_lblNamaMenu.fill = GridBagConstraints.BOTH;
		gbc_lblNamaMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblNamaMenu.gridx = 0;
		gbc_lblNamaMenu.gridy = 1;
		frame.getContentPane().add(lblNamaMenu, gbc_lblNamaMenu);
		
		btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewaction();
			}
		});
		
		txtNamaMenu = new JTextField();
		txtNamaMenu.setText("");
		txtNamaMenu.setColumns(10);
		GridBagConstraints gbc_txtNamaMenu = new GridBagConstraints();
		gbc_txtNamaMenu.fill = GridBagConstraints.BOTH;
		gbc_txtNamaMenu.insets = new Insets(0, 0, 5, 0);
		gbc_txtNamaMenu.gridx = 1;
		gbc_txtNamaMenu.gridy = 1;
		frame.getContentPane().add(txtNamaMenu, gbc_txtNamaMenu);
		
		JLabel lblHargaMenu = new JLabel("Harga Menu");
		lblHargaMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblHargaMenu = new GridBagConstraints();
		gbc_lblHargaMenu.fill = GridBagConstraints.BOTH;
		gbc_lblHargaMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblHargaMenu.gridx = 0;
		gbc_lblHargaMenu.gridy = 2;
		frame.getContentPane().add(lblHargaMenu, gbc_lblHargaMenu);
		
		txtHargaMenu = new JTextField();
		txtHargaMenu.setText("");
		txtHargaMenu.setColumns(10);
		GridBagConstraints gbc_txtHargaMenu = new GridBagConstraints();
		gbc_txtHargaMenu.fill = GridBagConstraints.BOTH;
		gbc_txtHargaMenu.insets = new Insets(0, 0, 5, 0);
		gbc_txtHargaMenu.gridx = 1;
		gbc_txtHargaMenu.gridy = 2;
		frame.getContentPane().add(txtHargaMenu, gbc_txtHargaMenu);
		
		JLabel lblStokMenu = new JLabel("Stok Menu");
		lblStokMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStokMenu = new GridBagConstraints();
		gbc_lblStokMenu.fill = GridBagConstraints.BOTH;
		gbc_lblStokMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblStokMenu.gridx = 0;
		gbc_lblStokMenu.gridy = 3;
		frame.getContentPane().add(lblStokMenu, gbc_lblStokMenu);
		
		txtStokMenu = new JTextField();
		txtStokMenu.setText("");
		txtStokMenu.setColumns(10);
		GridBagConstraints gbc_txtStokMenu = new GridBagConstraints();
		gbc_txtStokMenu.fill = GridBagConstraints.BOTH;
		gbc_txtStokMenu.insets = new Insets(0, 0, 5, 0);
		gbc_txtStokMenu.gridx = 1;
		gbc_txtStokMenu.gridy = 3;
		frame.getContentPane().add(txtStokMenu, gbc_txtStokMenu);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertaction();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					deleteaction(txtKodeMenu.getText());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 5;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					updateaction(txtKodeMenu.getText());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 5;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String KodeMenu = table.getValueAt(table.getSelectedRow(), 0).toString();
				selectaction(KodeMenu);
			}
		});
		scrollPane.setViewportView(table);
	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/db_menu";
			Class.forName(driver);
			return DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			System.out.println("Connection Failed! " + e);
		}
		return null;
	}
	
	private void insertaction() {
		Connection con = con();
		try {
			String query = "insert into tb_menu values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtKodeMenu.getText());
			ps.setString(2, txtNamaMenu.getText());
			ps.setString(3, txtHargaMenu.getText());
			ps.setString(4, txtStokMenu.getText());
			
			String pd = "PD-.*[0-9].*";
	        String specialChar = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
	        boolean valid = false;
	        
	        for (int i=3; i < txtKodeMenu.getText().length() ; i++) {
	            char ch = txtKodeMenu.getText().charAt(i);
	            if(specialChar.contains(Character.toString(ch))) {
	                valid = true;
	            }
	        }
			
			if (txtKodeMenu.getText().matches(pd) && txtKodeMenu.getText().length() == 6 && valid == false) {
				ps.execute();
				JOptionPane.showMessageDialog(null, "Data inserted!");
				viewaction();
			} else if (txtKodeMenu.getText().isEmpty() || txtNamaMenu.getText().isEmpty() || txtHargaMenu.getText().isEmpty() || txtStokMenu.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No data to be inserted!");
			} else {
				JOptionPane.showMessageDialog(null, "Fail to insert data!");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void viewaction() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kode Menu");
		model.addColumn("Nama Menu");
		model.addColumn("Harga Menu");
		model.addColumn("Stok Menu");
		try {
			String query = "select * from tb_menu";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
					rs.getString("KodeMenu"),
					rs.getString("NamaMenu"),
					rs.getString("HargaMenu"),
					rs.getString("StokMenu")
				});
			}
			
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(75);
			table.getColumnModel().getColumn(1).setPreferredWidth(125);
			table.getColumnModel().getColumn(2).setPreferredWidth(125);
			table.getColumnModel().getColumn(3).setPreferredWidth(125);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void selectaction(String KodeMenu) {
		Connection con = con();
		try {
			String query = "select * from tb_menu where KodeMenu = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, KodeMenu);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				txtKodeMenu.setText(rs.getString("KodeMenu"));
				txtNamaMenu.setText(rs.getString("NamaMenu"));
				txtHargaMenu.setText(rs.getString("HargaMenu"));
				txtStokMenu.setText(rs.getString("StokMenu"));
			}
			
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void updateaction(String KodeMenu) {
		Connection con = con();
		try {
			String query = "update tb_menu set HargaMenu = ?, StokMenu = ? where KodeMenu = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtHargaMenu.getText());
			ps.setString(2, txtStokMenu.getText());
			ps.setString(3, KodeMenu);
			ps.execute();
			
			ps.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Update successfull!");
			viewaction();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void deleteaction(String KodeMenu) {
		Connection con = con();
		try {
			String query = "delete from tb_menu where KodeMenu = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, KodeMenu);
			ps.execute();
			
			ps.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Data deleted!");
			viewaction();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
