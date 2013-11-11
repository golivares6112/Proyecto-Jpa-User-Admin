package cl.ocp.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

public class TransactionFactory {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static int lastID;
	
	public static void createFctoryConnection(String persistenceName)
	{
		try{
			emf = Persistence.createEntityManagerFactory(persistenceName);
			em = emf.createEntityManager();
		}catch(Exception e){
			System.out.println("ERROR : " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadAllUsers(DefaultTableModel modelUsers)
	{
		try{
			Query listAllUsers = em.createNamedQuery("Usuario.findAll");
			List<Usuario> userList = listAllUsers.getResultList();
			Iterator<Usuario> i = userList.iterator();
			while(i.hasNext())
			{
				Usuario u = i.next();
				modelUsers.addRow(new Object[]{u.getIdusuarios(), 
                        					   u.getUsername(), 
                        					   u.getPassword(), 
                        					   u.getName(),
                        					   u.getLastname(),
                        					   u.getDirection(),
                        					   u.getTelephone(),
                        					   u.getEmail()});
			setLastID(u.getIdusuarios());
			}
		}catch(Exception e){
			System.out.println("ERROR : " + e.getMessage());
		}
	}

	public static int getLastID() {
		return lastID;
	}

	public static void setLastID(int lastID) {
		TransactionFactory.lastID = lastID;
	}

	
	
}
