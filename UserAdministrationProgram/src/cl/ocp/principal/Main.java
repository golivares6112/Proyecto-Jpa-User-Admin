package cl.ocp.principal;

import javax.swing.SwingUtilities;

import cl.ocp.interfaceapp.ApplicationInterface;

public class Main {
	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ApplicationInterface().setVisible(true);
            }
        });
    }
}
