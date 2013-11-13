package cl.ocp.interfaceapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import cl.ocp.model.TransactionFactory;
import cl.ocp.object.ObjectCreator;


public class AddUserForm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel pnNorth, pnCenter, pnSouth;
	private  JLabel lbId, lbUsername, lbPassword, lbName, lbLastName;
	private  JLabel lbDireccion, lbTelefono, lbEmail;
	private  JTextField tfId, tfUsername, tfName, tfLastName;
	private  JTextField tfDireccion, tfTelefono, tfEmail;
	private  JPasswordField pfPassword;
	private  JButton jbAddUser, btCancelar;
	private  FlowLayout contenedor;
	
	public AddUserForm(JFrame frame, boolean modal, String titulo)
	{
		super(frame, modal);
		pnNorth = this.panelAddUserCodigo();
		pnCenter = this.panelAddUserData();
		pnSouth = this.addUserControlButtons();
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
    	tfName = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
    	tfLastName = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
    	tfDireccion = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
    	tfTelefono = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
    	tfEmail = ObjectCreator.constructorJTextField("", "Serif", 1, 11);
    	
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
    	jbAddUser.addActionListener(this);
    	jbAddUser.setActionCommand("Add");
    	btCancelar = ObjectCreator.constructorButton("Cancel Add", "Serif", 1, 11);
    	btCancelar.addActionListener(this);
    	btCancelar.setActionCommand("Cancel Add");
    	jpcb.add(jbAddUser);
    	jpcb.add(btCancelar);
		return jpcb;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String action = event.getActionCommand();
		
		if(action.equalsIgnoreCase("Cancel Add"))
		{
			this.dispose();
		}
		
		if(action.equalsIgnoreCase("Add"))
		{
			if(validarDatos())
			{
				JOptionPane.showMessageDialog(null,
	     			       "Campo Vacio", 
	     			       "Uno de los Campos se Encuentra Vacio", 
	     			       JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,
	     			       "Usuario Registrado", 
	     			       "Usuario Registrado Exitosamente", 
	     			       JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		}
		
	}
	
	public boolean validarDatos()
	{
		boolean condicion = false;
		if( tfUsername.getText().isEmpty() || tfName.getText().isEmpty() || tfLastName.getText().isEmpty() ||
			tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty() || tfEmail.getText().isEmpty() ||
			pfPassword.getPassword().length == 0)
		{
			condicion = true;
		}
		
		return condicion;
	}
	
}
