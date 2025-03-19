package example;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Gui2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField PathA;
	private JTextField PathB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
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
	        
	 public Gui2() {
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
	        
	        ActionListener fileChooserListener = e -> {
	            JFileChooser fileChooser = new JFileChooser();
	            int returnValue = fileChooser.showOpenDialog(null);

	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                if (e.getSource() == btnBrowseA) {
	                    PathA.setText(selectedFile.getAbsolutePath());
	                } else if (e.getSource() == btnBrowseB) {
	                    PathB.setText(selectedFile.getAbsolutePath());
	                }
	            }
	        }; ActionListener FileDeleting = e ->{
	        	String filePathA = PathA.getText(); 
	        	String filePathB = PathB.getText(); 
	            if (filePathA.isEmpty() && filePathB.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Select a file", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            File fileA = new File(filePathA);
	            File fileB = new File(filePathB);
	            if (!fileA.exists() && !fileB.exists()) {
	                JOptionPane.showMessageDialog(null, "Couldn't find file", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	            try (FileWriter writer = new FileWriter(fileA, false)) {
	            	PathA.setText(" "); 
	                JOptionPane.showMessageDialog(null, "Success", "", JOptionPane.INFORMATION_MESSAGE);
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            try (FileWriter writer = new FileWriter(fileB, false)) {
	            	PathB.setText(" "); 
	                JOptionPane.showMessageDialog(null, "Success", "", JOptionPane.INFORMATION_MESSAGE);
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        	
	        };
	        
	        ActionListener FileSubmiting = e -> dispose();
               	        
	        
	        btnSubmit.addActionListener(FileSubmiting);	
	        btnDelete.addActionListener(FileDeleting);
	        btnBrowseA.addActionListener(fileChooserListener);
	        btnBrowseB.addActionListener(fileChooserListener);
	        
	    }   
       
	  }

