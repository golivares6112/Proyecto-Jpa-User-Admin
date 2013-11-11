package cl.ocp.interfaceapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cl.ocp.ensambling.PanelEnsambling;


public class AddUserForm extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel pnNorth, pnCenter, pnSouth;
	private PanelEnsambling panelEnsambling;
	
	public AddUserForm(JFrame frame, boolean modal, String titulo)
	{
		super(frame, modal);
		panelEnsambling = new PanelEnsambling();
		pnNorth = panelEnsambling.panelAddUserCodigo();
		pnCenter = panelEnsambling.panelAddUserData();
		pnSouth = panelEnsambling.addUserControlButtons();
		this.getContentPane().setLayout(new BorderLayout());
		this.setTitle(titulo);
		this.add(pnNorth, BorderLayout.NORTH);
		this.add(pnCenter, BorderLayout.CENTER);
		this.add(pnSouth, BorderLayout.SOUTH);
		setLocationRelativeTo(frame);
		this.setSize(760, 450);
		this.centrarVentana();
	}
	
	private void centrarVentana()
	{
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
	}

}
