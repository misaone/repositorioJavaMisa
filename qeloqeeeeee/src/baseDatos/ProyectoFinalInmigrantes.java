package baseDatos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoFinalInmigrantes extends JFrame{
	private JPanel panel1,panel2;
	private JButton btnext,btprev,btinsert,btupdate,btdelete;
	private JButton btlimpiar,btbuscar;
	private JLabel lbid,lbapynom,lbpais,lbestad,lbedad,lbproc,lbintext,lbocup,lbano;
	private JTextField txid,txapynom, txpais,txestad,txedad,txproc,txintext,txtocup,txano;
	
	
	
	ResultSet rs;
	
	PreparedStatement ps4;
	
	private static Connection con = null;
	
	
	public ProyectoFinalInmigrantes() {
		
		initComponents();
		leerDatos();
		cerrar();
		
		
		
		
	}
	
	public void initComponents() {
		this.setLayout(new BorderLayout());
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		
		panel2.setLayout(new GridLayout(10,1));
		
		
		panel1.setLayout(new GridLayout(3,3,5,10));
		
		
		
		btnext = new JButton("Next");
		btprev = new JButton("Previous");
		btinsert = new JButton("Insert");
		btupdate = new JButton("Update");
		btdelete = new JButton("Delete");
		btlimpiar = new JButton("Limpiar");
		btbuscar = new JButton("Buscar");
		
		
		btnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next();
				
			}
		});
		
		btprev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				previous();
				
			}
		});
		
		btinsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertData();
				
			}
		});
		
		btupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateData();
				
			}
		});
		
		btdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();
				
			}
		});
		
		btlimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiar();
				
			}
		});
		
		btbuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar();
				
			}
		});
		
		lbid = new JLabel("Id");
		lbapynom = new JLabel("Apellidos y Nombre");
		lbpais = new JLabel("País");
		lbestad = new JLabel("Estado Civil");
		lbedad = new JLabel("Edad");
		lbproc = new JLabel("Procedencia");
		lbintext = new JLabel("Interna/Externa");
		lbocup = new JLabel("Ocupación");
		lbano = new JLabel("Año");
		
		txid = new JTextField(10);
		txapynom = new JTextField(20);
		txpais = new JTextField(20);
		txestad = new JTextField(20);
		txedad = new JTextField(20);
		txproc = new JTextField(20);
		txintext = new JTextField(20);
		txtocup = new JTextField(20);
		txano = new JTextField(20);
		
		this.add(panel2,BorderLayout.NORTH);
		this.add(panel1,BorderLayout.SOUTH);
		
		
		
		panel2.add(lbid);
		panel2.add(txid);
		
		panel2.add(lbapynom);
		panel2.add(txapynom);
		
		panel2.add(lbpais);
		panel2.add(txpais);
		
		panel2.add(lbestad);
		panel2.add(txestad);
		
		panel2.add(lbedad);
		panel2.add(txedad);
		
		panel2.add(lbproc);
		panel2.add(txproc);
		
		panel2.add(lbintext);
		panel2.add(txintext);
		
		panel2.add(lbocup);
		panel2.add(txtocup);
		
		panel2.add(lbano);
		panel2.add(txano);
		
		
		panel1.add(btprev);
		panel1.add(btnext);
		panel1.add(btinsert);
		panel1.add(btupdate);
		panel1.add(btbuscar);
		panel1.add(btlimpiar);
		panel1.add(btdelete);
		
	}
	
	private void leerDatos() {
		try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/direccionRegistro?&user=root&password=cERVATIYO99"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
            String sql = "SELECT iD,ApellidosNombre,Pais,EstadoCivil,Edad,Procedencia,IntExt,Ocupacion,Anio FROM direccionRegistro.migracion;";
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "CONECTADO A LA BASE DE DATOS",
                    "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoFinalInmigrantes.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }
	
	private void populateControls(){
		try{
			txid.setText(rs.getString("iD"));
			txapynom.setText(rs.getString("ApellidosNombre"));
			txpais.setText(rs.getString("Pais"));
			txestad.setText(rs.getString("EstadoCivil"));
			txedad.setText(rs.getString("Edad"));
			txproc.setText(rs.getString("Procedencia"));
			txintext.setText(rs.getString("IntExt"));
			txtocup.setText(rs.getString("Ocupacion"));
			txano.setText(rs.getString("Anio"));
				
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),
			"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
                
	}
	
	
	
	 private void insertData(){
           
        Connection connection;
        
         PreparedStatement ps;
         try {
             
             connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/direccionRegistro?&user=root&password=cERVATIYO99"
                           + "&useLegacyDatetimeCode=false&serverTimezone=UTC");  
              
             ps = connection.prepareStatement("INSERT INTO migracion VALUES (?,?,?,?,?,?,?,?,?)");
        
        int prueba= Integer.parseInt(txid.getText());
        ps.setInt(1, prueba);
        ps.setString(2, txapynom.getText());
        ps.setString(3, txpais.getText());
        ps.setString(4, txestad.getText());
        ps.setString(5, txedad.getText());
        ps.setString(6, txproc.getText());
        ps.setString(7, txintext.getText());
        ps.setString(8, txtocup.getText());
        ps.setString(9, txano.getText());
        
                ps.executeUpdate();  
        	    JOptionPane.showMessageDialog(null, "ELEMENTO INSERTADO",
        		         "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                next();
         }  
         
         catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR",
  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
         }
    
    }
	 
	private void deleteData()
		{
	            Connection connection;
	        
	         PreparedStatement ps;
	         try {
	             
	             connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/direccionRegistro?&user=root&password=cERVATIYO99"
	                           + "&useLegacyDatetimeCode=false&serverTimezone=UTC");  
	              
	             ps = connection.prepareStatement("DELETE FROM migracion WHERE iD='"+txid.getText()+"'");   
	                  ps.execute();
	                  JOptionPane.showMessageDialog(null, "ELIMINADO",
	  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				next();
			}
			catch(Exception e)
			{
	                     JOptionPane.showMessageDialog(null, "NO SE PUDO BORRAR",
	  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	                 }
	         
	         
	    
	    }
	
    private void updateData(){
        Connection connection;

	PreparedStatement ps;
	try {
	    connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/direccionRegistro?&user=root&password=cERVATIYO99"
	                   + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
	    
	    ps = connection.prepareStatement("UPDATE autores SET nombre=?,nacionalidad=? WHERE idAutor= ?");
	    ps = connection.prepareStatement("UPDATE migracion SET ApellidosNombre=?,Pais=?,EstadoCivil=?,Edad=?,Procedencia=?,IntExt=?,Ocupacion=?,Anio=? WHERE iD= ?");
	    int prueba= Integer.parseInt(txid.getText());
	    ps.setString(1, txapynom.getText());
	    ps.setString(2, txpais.getText());
	    ps.setString(3, txestad.getText());
	    ps.setString(4, txedad.getText());
	    ps.setString(5, txproc.getText());
	    ps.setString(6, txintext.getText());
	    ps.setString(7, txtocup.getText());
	    ps.setString(8, txano.getText());
	    ps.setInt(9, prueba);
	    ps.execute();
	    JOptionPane.showMessageDialog(null, "ACTUALIZADO",
	         "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	}
	catch(Exception e)
	{
		                  JOptionPane.showMessageDialog(null, "ERROR",
	         "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	}
    


        
}
	 
	 
	 
	 private void next(){
         Connection con;
		try{
			if(rs == null){
				 leerDatos();
			}
                     if(rs.next() && !rs.isAfterLast()){
				populateControls();
			}
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	 
	
	  private void previous(){
          Connection con;
		try{
			if(rs == null){
				 leerDatos();
			}
			if(rs.previous()){
                         
				populateControls();				
				
			}
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	public void cerrar() {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
				confirmarSalida();
				
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmarSalida() {
		
		
		int valor = JOptionPane.showConfirmDialog(this,"SEGURO QUIERES SALIR","",JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "GRACIAS","",JOptionPane.INFORMATION_MESSAGE );
			System.exit(0);
			
		}
	}
	 
	public void limpiar() {
		txid.setText(null);
		txapynom.setText(null);
		txpais.setText(null);
		txestad.setText(null);
		txedad.setText(null);
		txproc.setText(null);
		txintext.setText(null);
		txtocup.setText(null);
		txano.setText(null);
	}
	
	public void buscar() {
		Connection con = null;
		
		try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/direccionRegistro?&user=root&password=cERVATIYO99"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
            ps4 = con.prepareStatement("SELECT * FROM migracion WHERE iD=?");
            int prueba= Integer.parseInt(txid.getText());
            ps4.setInt(1, prueba);
            
            rs = ps4.executeQuery();
            
            while(rs.next()) {
               txid.setText(rs.getString("iD"));
          	  
         	   txapynom.setText(rs.getString("ApellidosNombre"));
         	   txpais.setText(rs.getString("Pais"));
         	   txestad.setText(rs.getString("EstadoCivil"));
         	   txedad.setText(rs.getString("Edad"));
         	   txproc.setText(rs.getString("Procedencia"));
         	   txintext.setText(rs.getString("IntExt"));
         	   txtocup.setText(rs.getString("Ocupacion"));
         	   txano.setText(rs.getString("Anio"));
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR",
			         "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
	}
	

	
	

}
