package example;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField PathA;
	private JTextField PathB;
	private JTextField Delete;
	private JTextField Submit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	        
	 public Gui() {
	        setTitle("AUTO-GRADING FILE CHOOSER");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 180);
	        setLocationRelativeTo(null); 

	        JPanel contentPane = new JPanel(new GridBagLayout());
	        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        contentPane.setBackground(Color.WHITE);
	        setContentPane(contentPane);
	      
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(7, 7, 7, 7); 

	      
	        JLabel labelPathA = new JLabel("Path A:");
	        labelPathA.setFont(new Font("Arial", Font.ITALIC, 15));
	        labelPathA.setForeground(Color.BLACK);
	        gbc.gridx = -1;
	        gbc.gridy = -1;
	        contentPane.add(labelPathA, gbc);

	        PathA = new JTextField(25);
	        PathA.setBackground(Color.pink);
	        PathA.setForeground(Color.BLACK);
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.weightx = 0.0; 
	        contentPane.add(PathA, gbc);

	        JButton btnBrowseA = new JButton("Choose a file");
	        btnBrowseA.setBackground(Color.pink);
	        btnBrowseA.setForeground(Color.BLACK);
	        gbc.gridx = 2;
	        gbc.gridy = 0;
	        gbc.weightx = 0; 
	        contentPane.add(btnBrowseA, gbc);


	        JButton btnDelete = new JButton("Delete");
	        btnDelete.setBackground(Color.pink);
	        btnDelete.setForeground(Color.BLACK);
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.weightx = 0.0; 
	        contentPane.add(btnDelete, gbc);
	        
	        JButton btnSubmit = new JButton("Submit");
	        btnSubmit.setBackground(Color.pink);
	        btnSubmit.setForeground(Color.BLACK);
	        gbc.gridx = 2;
	        gbc.gridy = 3;
	        gbc.weightx = 0.0; 
	        contentPane.add(btnSubmit, gbc);
	        
	        JLabel labelPathB = new JLabel("Path B:");
	        labelPathB.setFont(new Font("Arial", Font.ITALIC, 15));
	        labelPathB.setForeground(Color.BLACK);
	        gbc.gridx= 0;
	        gbc.gridy = 1;
	        contentPane.add(labelPathB, gbc);

	        PathB = new JTextField(25);
	        PathB.setBackground(Color.pink);
	        PathB.setForeground(Color.BLACK);
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.weightx = 1.0;
	        contentPane.add(PathB, gbc);

	        JButton btnBrowseB = new JButton("Choose a file");
	        btnBrowseB.setBackground(Color.pink);
	        btnBrowseB.setForeground(Color.BLACK);
	        gbc.gridx = 2;
	        gbc.gridy = 1;
	        gbc.weightx = 1;
	        contentPane.add(btnBrowseB, gbc);
	        

	        ActionListener openWebsiteListener = e -> {
	            try {
	                Desktop desktop = Desktop.getDesktop();
	                URI uri = new URI("https://yulearn.yeditepe.edu.tr/"); 
	                desktop.browse(uri);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        };

	        btnBrowseA.addActionListener(openWebsiteListener);
	        btnBrowseB.addActionListener(openWebsiteListener);
	    }
	        

	        
	        
	        
	}

