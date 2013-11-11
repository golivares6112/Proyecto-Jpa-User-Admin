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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import cl.ocp.model.TransactionFactory;
import cl.ocp.object.ObjectCreator;

public class PanelEnsambling implements ActionListener{
	
	private  FlowLayout contenedor;
    private  JLabel lbTitulo, lbusernameBuscar;
    private  JButton agregar, modificar, eliminar, buscar;
    private  DefaultTableModel modelUsers;
	private  JTable tableUsers;
	private  JTextField tfBuscarUsername;
	//panel add user option
	private  JLabel lbId, lbUsername, lbPassword, lbName, lbLastName;
	private  JLabel lbDireccion, lbTelefono, lbEmail;
	private  JTextField tfId, tfUsername, tfName, tfLastName;
	private  JTextField tfDireccion, tfTelefono, tfEmail;
	private  JPasswordField pfPassword;
	private  JButton jbAddUser, btCancelar;
	
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
    
    
    //panel add user options
    public JPanel panelAddUserCodigo()
    {
    	JPanel jpb = new JPanel();
    	TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("Last Code", "Serif", 1, 11);
    	jpb.setBorder(bordePanelTitulo);
    	contenedor = new FlowLayout(FlowLayout.LEFT);
    	jpb.setLayout(contenedor);
    	lbId = ObjectCreator.constructorLabel("ID Username : ", "Serif", 1, 11);	
        tfId = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
        tfId.setText(Integer.toString(TransactionFactory.getLastID() + 1));
        tfId.setEditable(false);
        tfId.setColumns(3);
    	jpb.add(lbId);
    	jpb.add(tfId);
    	return jpb;
    	
    }
    
    
    public JPanel panelAddUserData()
    {
    	JPanel jpd = new JPanel();
    	TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("Data User", "Serif", 1, 11);
    	jpd.setBorder(bordePanelTitulo);
    	
    	lbUsername = ObjectCreator.constructorLabel("UserName : ", "Serif", 1, 11);
    	lbPassword = ObjectCreator.constructorLabel("Password : ", "Serif", 1, 11);
    	lbName = ObjectCreator.constructorLabel("Name : ", "Serif", 1, 11);
    	lbLastName = ObjectCreator.constructorLabel("LastName : ", "Serif", 1, 11);
    	lbDireccion = ObjectCreator.constructorLabel("Direction : ", "Serif", 1, 11);
    	lbTelefono = ObjectCreator.constructorLabel("Telephone : ", "Serif", 1, 11);
    	lbEmail = ObjectCreator.constructorLabel("Email : ", "Serif", 1, 11);
    	tfUsername = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	pfPassword = ObjectCreator.constructorPasswordField("Serif", 1, 11);
    	pfPassword.setColumns(15);
    	tfName = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	tfLastName = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	tfDireccion = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	tfTelefono = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	tfEmail = ObjectCreator.constructorJTextField(" ", "Serif", 1, 11);
    	
    	org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jpd);
    	jpd.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lbEmail)
                    .add(lbTelefono)
                    .add(lbDireccion)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(36, 36, 36)
                            .add(lbUsername))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(lbName))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(tfTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, tfEmail)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(tfUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .add(tfName))
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(31, 31, 31)
                                        .add(lbPassword)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(pfPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(25, 25, 25)
                                        .add(lbLastName)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(tfLastName))))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, tfDireccion))
                        .add(76, 76, 76))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbUsername)
                    .add(tfUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbPassword)
                    .add(pfPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbName)
                    .add(lbLastName)
                    .add(tfLastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbDireccion)
                    .add(tfDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbTelefono)
                    .add(tfTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbEmail)
                    .add(tfEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    	return jpd;
    }
    
	public JPanel addUserControlButtons()
	{
		JPanel jpcb = new JPanel();
		TitledBorder bordePanelTitulo = 
        		ObjectCreator.constructorBorderPanel("Control User", "Serif", 1, 11);
    	jpcb.setBorder(bordePanelTitulo);
    	contenedor = new FlowLayout(FlowLayout.CENTER);
    	jpcb.setLayout(contenedor);
    	jbAddUser = ObjectCreator.constructorButton("Add", "Serif", 1, 11);
    	btCancelar = ObjectCreator.constructorButton("Cancel Add", "Serif", 1, 11);
    	jpcb.add(jbAddUser);
    	jpcb.add(btCancelar);
		return jpcb;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
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
