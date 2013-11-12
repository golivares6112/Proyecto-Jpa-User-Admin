package cl.ocp.ensambling;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import cl.ocp.interfaceapp.AddUserForm;
import cl.ocp.interfaceapp.ApplicationInterface;
import cl.ocp.model.TransactionFactory;
import cl.ocp.object.ObjectCreator;

public class PanelEnsambling implements ActionListener{
	
	private  FlowLayout contenedor;
    private  JLabel lbTitulo, lbusernameBuscar;
    private  JButton agregar, modificar, eliminar, buscar;
    private  DefaultTableModel modelUsers;
	private  JTable tableUsers;
	private  JTextField tfBuscarUsername;
	private AddUserForm addUserF;
	
    public JPanel panelTitulo()
    {
        JPanel pt = new JPanel();
        TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("", "Serif", 1, 11);
        pt.setBorder(bordePanelTitulo);
        contenedor = new FlowLayout(FlowLayout.LEFT);
        pt.setLayout(contenedor);
        lbTitulo = ObjectCreator.constructorLabel("User List", "Serif", 1, 13);
        pt.add(lbTitulo);
       
        return pt;
    }
    
    public JPanel panelControles()
    {
    	JPanel jpControlPanel, jpControlBuscar;
    	
        JPanel jpc = new JPanel();
        TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("Administration User Options", "Serif", 1, 11);
        jpc.setBorder(bordePanelTitulo);
        jpc.setLayout(new BorderLayout());
        jpControlPanel = panelControlPane();
        jpControlBuscar = panelControlBuscar();
        jpc.add(jpControlPanel, BorderLayout.WEST);
        jpc.add(jpControlBuscar, BorderLayout.EAST);
        return jpc;
    }
    
    private JPanel panelControlPane()
    {
    	JPanel jpcp = new JPanel();
    	
    	contenedor = new FlowLayout(FlowLayout.LEFT);
        jpcp.setLayout(contenedor);
        agregar = ObjectCreator.constructorButton("Add User", "Serif", 1, 11);
        modificar = ObjectCreator.constructorButton("Modify User", "Serif", 1, 11);
        eliminar = ObjectCreator.constructorButton("Delete User", "Serif", 1, 11);
        agregar.addActionListener(this);
        agregar.setActionCommand("Add User");
        jpcp.add(agregar);
        jpcp.add(modificar);
        jpcp.add(eliminar);
        
    	return jpcp;
    }
    
    private JPanel panelControlBuscar()
    {
    	JPanel jpb = new JPanel();
    	contenedor = new FlowLayout(FlowLayout.RIGHT);
        jpb.setLayout(contenedor);
        lbusernameBuscar = ObjectCreator.constructorLabel("Find Username : ", "Serif", 1, 11);
        tfBuscarUsername = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
        tfBuscarUsername.setColumns(8);
        buscar = ObjectCreator.constructorButton("Find", "Serif", 1, 11);
        buscar.addActionListener(this);
        buscar.setActionCommand("Find");
        jpb.add(lbusernameBuscar);
        jpb.add(tfBuscarUsername);
        jpb.add(buscar);
    	return jpb;
    }
    
    public JPanel panelDatos()
    {
    	JPanel jpd = new JPanel();
    	TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("User Data Information", "Serif", 1, 11);
        jpd.setBorder(bordePanelTitulo);
        jpd.setLayout(new BorderLayout());
        modelUsers = new DefaultTableModel(); //definimos el model donde va la informacion	
    	modelUsers.addColumn("ID Users");
    	modelUsers.addColumn("Username");
    	modelUsers.addColumn("Password");
    	modelUsers.addColumn("Name");
    	modelUsers.addColumn("Lastname");
    	modelUsers.addColumn("Direction");
    	modelUsers.addColumn("Telephone");
    	modelUsers.addColumn("Email");
    	TransactionFactory.createFctoryConnection("JPAuserAdministrationProgram");
    	TransactionFactory.loadAllUsers(modelUsers);
    	System.out.println("Ultimo Dato : " + TransactionFactory.getLastID());
    	tableUsers = new JTable(modelUsers); //definimos la tabla que recibira el model
    	tableUsers.setFillsViewportHeight(true);
		JScrollPane scrollPaneTableUsers = new JScrollPane(tableUsers); //le entregamos la tabla al scroll
		scrollPaneTableUsers.setPreferredSize(new Dimension(150,200));
		this.centrarDatosTabla(tableUsers);
		this.centrarTituloTabla(tableUsers);
   
    	jpd.add(scrollPaneTableUsers, BorderLayout.CENTER);
    	
    	return jpd;
    }
    
    
  

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		String action = ae.getActionCommand();
	    int error = 0;
	    
		if(action.equalsIgnoreCase("Find"))
		{
			String username = tfBuscarUsername.getText();
	        for (int i = 0; i < tableUsers.getRowCount(); i++) 
	        {
	               if (tableUsers.getValueAt(i, 1).equals(username)) 
	               {                                           
	            	   		tableUsers.changeSelection(i, 1, false, false);
	            	   		error = 0;
	            	   		break;
	               }else{
	            	   		error = 1;
	               }
	        }
	        
	        if(error == 1)
	        {
	        	JOptionPane.showMessageDialog(null,
	     			       "No se encontro el username", //Mensaje
	     			       "Mensaje de Error", //T�tulo
	     			       JOptionPane.ERROR_MESSAGE);
	        }
		}
		
		if(action.equalsIgnoreCase("Add User"))
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				@Override
				public void run() 
				{
					addUserF = new AddUserForm(new ApplicationInterface(), true, "Add User Form");
					addUserF.setVisible(true);	
				}
				
			});
			
		}
	}
    
	private void centrarDatosTabla(JTable tabla)
	{
		  DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
          modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
          tabla.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(5).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(6).setCellRenderer(modelocentrar);
          tabla.getColumnModel().getColumn(7).setCellRenderer(modelocentrar);
	}
	
    private void centrarTituloTabla(JTable tabla)
    {
    	TableCellRenderer rendererFromHeader = tabla.getTableHeader().getDefaultRenderer();
    	JLabel headerLabel = (JLabel) rendererFromHeader;
    	headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    
}
