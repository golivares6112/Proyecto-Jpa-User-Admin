package cl.ocp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

import cl.ocp.interfaceapp.AddUserForm;
import cl.ocp.interfaceapp.ApplicationInterface;

public class ObjectController implements ActionListener{
	
	private AddUserForm addUserF;
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String event = ae.getActionCommand();
			
		if(event.equalsIgnoreCase("Add User"))
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

}
