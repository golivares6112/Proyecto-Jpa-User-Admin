package cl.ocp.interfaceapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cl.ocp.ensambling.PanelEnsambling;

public class ApplicationInterface extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel pNorte;
    private JPanel pSur;
    private JPanel pCentro;
    private PanelEnsambling panelEnsambling;
    
    public ApplicationInterface()
    {        
    	super(".:: User Managment ::.");
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	panelEnsambling = new PanelEnsambling(); 
    	pNorte = panelEnsambling.panelTitulo();
    	pSur = panelEnsambling.panelControles();
    	pCentro = panelEnsambling.panelDatos();
    	this.add(pNorte, BorderLayout.NORTH);
    	this.add(pCentro, BorderLayout.CENTER);
    	this.add(pSur, BorderLayout.SOUTH);
    	this.setSize(1100, 550);
    	this.centrarVentana();
    }
    
    
    private void centrarVentana() 
    {
        this.setResizable(false);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
    }
}
