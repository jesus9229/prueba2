package edu.CECAR.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.CECAR.logicanegocio.Operacion;
/**
 * La clase FrmPrincipal contiene todo el contenido que pertenece a la interfaz 
 * grafica del proyecto.
 * @author Grupo de trabajo cuello, rios, rodrigez, sierra
 * @version 2.0
 * Fecha 27/05/2015
 */


public final class FrmPrincipal extends JFrame {


	private JTextPane textArea;
	private JFileChooser chooser ;
	private int a;
	private File archivo = null;
	private FileReader lector;
	private BufferedReader bfReader;
      
        int x=0;
        int y=91;

/**
 * Creacion del contenido de la interfaz, se implentan las diferentes escuchadoras
 * para las opcines que realiza el menu archivo  del proyecto
 */
	public FrmPrincipal() {
		setTitle("NotasCECAR");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(archivo==null){
					
					JFileChooser guardar = new JFileChooser();
					int option = guardar.showSaveDialog(FrmPrincipal.this);

					if (option == JFileChooser.APPROVE_OPTION) {
						Operacion.guardar(guardar.getSelectedFile().getAbsolutePath(), textArea.getText());
					}	
				
				}
				else{
					Operacion.guardar(archivo.getAbsolutePath(), textArea.getText());
				}
			}
		});
		
				JMenuItem mntmAbrir = new JMenuItem("Abrir");
				mntmAbrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chooser = new JFileChooser();
						a = chooser.showOpenDialog(null);

						if(a ==JFileChooser.APPROVE_OPTION){
							archivo = chooser.getSelectedFile();
							textArea.setText(Operacion.abrir(archivo.getAbsolutePath()));	
						}
					}
				});
						
								JMenuItem mntmNuevo = new JMenuItem("Nuevo");
								mntmNuevo.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										nuevo();
									}
								});
								
								
								mnArchivo.add(mntmNuevo);
				
						mnArchivo.add(mntmAbrir);
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				JFileChooser guardar = new JFileChooser();
				int option = guardar.showSaveDialog(FrmPrincipal.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					Operacion.guardar(guardar.getSelectedFile().getAbsolutePath(), textArea.getText());
				}	
			}
		});
		mnArchivo.add(mntmGuardarComo);


		textArea = new JTextPane();
		JScrollPane scroll = new JScrollPane(textArea);
		getContentPane().add(scroll, BorderLayout.CENTER);
	}

/**
 * crear una nueva hoja en blanco
 */

	private final void nuevo(){
		archivo = null;
		textArea.setText(null);	
		setTitle("Nuevo documento.txt");
	}



/**
 * 
 * Main del proyecto 
 */
	public static void main(String[] args) {


		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
