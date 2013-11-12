package cl.ocp.object;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ObjectCreator {
	
	 public static JButton constructorButton(String titulo, String fuente, int negrita, int tam)
	    {
		 	JButton b = new JButton(titulo);
		 	b.setFont(new Font(fuente, negrita, tam));
		 	
		 	return b;
	    }
		
	    public static JTextField constructorJTextField(String text, String fuente, int negrita, int tam)
	    {
	        JTextField tf = new JTextField();
	        tf.setText(text);
	        tf.setFont(new Font(fuente, negrita, tam));
			
	        return tf;
	    }
		
	    public static JPasswordField constructorPasswordField(String fuente, int negrita, int tam)
	    {
	        JPasswordField jpsf = new JPasswordField();
	        jpsf.setFont(new Font(fuente, negrita, tam));
		
	        return jpsf;
	    }
		    
	    public static JTextArea constructorTextArea(int columnas, int filas, 
							String fuente, int negrita, int tam)
	    {
	    	JTextArea jta = new JTextArea();
	    	jta.setColumns(columnas);
	        jta.setRows(filas);
	        jta.setFont(new Font(fuente, negrita, tam));
	        jta.setEditable(true);
		    
	        return jta;
	    }

	    public static TitledBorder constructorBorderPanel(String titulo, String fuente, 
	                                                      int negrita, int tam)
	    {
	    	TitledBorder borderPanel;
	    	borderPanel = BorderFactory.createTitledBorder(titulo);
	    	borderPanel.setTitleFont(new Font(fuente, negrita, tam));
		
	        return borderPanel;
	    }
	    
	    public static JLabel constructorLabel(String titulo, String fuente, int negrita, int tam)
	    {
	    	JLabel lb = new JLabel(titulo);
	    	lb.setFont(new Font(fuente, negrita, tam));
		
	        return lb;
	    }

	    public static JScrollPane constructorScrollPane(JTextArea textArea)
	    {
	        JScrollPane scroll = new JScrollPane();
	        scroll.setViewportView(textArea);
	        
	        return scroll;
	    }

	    public static JProgressBar constructorBarraProgreso(int min, int max, String fuente, 
		    						int negrita, int tam) 
	    {
	        JProgressBar progressBar = new JProgressBar();
	        progressBar.setMinimum(min);
	        progressBar.setMaximum(max);
	        progressBar.setStringPainted(true);
	        progressBar.setBorderPainted(true);
	        progressBar.setFont(new Font(fuente, negrita, tam));
				
	        return progressBar;
	    }    
}
