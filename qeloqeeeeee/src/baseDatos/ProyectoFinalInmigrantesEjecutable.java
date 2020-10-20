package baseDatos;

import java.util.logging.Logger;
import java.util.logging.Level;

public class ProyectoFinalInmigrantesEjecutable {

	public static void main(String[] args) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoFinalInmigrantesEjecutable.class.getName()).log(Level.SEVERE, null, ex);
        }
		ProyectoFinalInmigrantes ventana = new ProyectoFinalInmigrantes();
		ventana.setVisible(true);
		ventana.setSize(600,400);
		ventana.setTitle("Registro de Migraciones");
		ventana.setLocationRelativeTo(null);
		
		

	}

}
