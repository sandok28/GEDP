package Entidad;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
   
    
   private String url = "jdbc:postgresql://localHost:5432/GEDP";
   private String user =  "postgres";
   private String pass = "2828";   
   private String sentenciaSQL = "select * from clientes";
   private Connection conexion;
   private Statement st;
   private ResultSet rs;
   private ResultSetMetaData meta;
   
     public Conexion(){ 	
       conectarSQL();      
   } 
   
   
   public ResultSet getRs(){ return rs;  }
   
   public ResultSetMetaData getMeta(){ return meta; }
     
   private void conectarSQL(){       
       try{
           Class.forName("org.postgresql.Driver"); //Es la clase que se usa para el driver.
           //String url = "jdbc:postgresql://localhost:5432/dbcjava"; //Ruta de la Base de Datos.
           conexion = DriverManager.getConnection(url, user, pass); //Es la conexión con la BD.
           st = conexion.createStatement(); //Trae los datos.
           sentencia(sentenciaSQL);
       } 
       catch(ClassNotFoundException ex){
           System.out.println("Eror en el driver! ");
       }
       catch(SQLException e){
           System.out.println("Error en la conexión! ");
       }        
   }
   
   public ResultSet sentencia(String sentenciaSQL1){
       try {
           rs = st.executeQuery(sentenciaSQL1);
           
           listar(rs);
           return rs;
       } catch (SQLException exc) {
         //  Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, exc);
    	   return null;
       }
       
   }
   
   
   private void listar(ResultSet rs) throws SQLException{
       System.out.println("");
       meta = rs.getMetaData(); //Trae los datos de la Tabla.

   }

   public boolean validar(String llave,String nomtabla){
	   ResultSet rs=sentencia("SELECT * FROM "+nomtabla);
		boolean estado=false;
		 try {
			 
			while (rs.next()) if(rs.getString(1).equalsIgnoreCase(llave))	estado=true;
			
			} catch (SQLException e) {
					System.out.println(e);
				
				}
		if(!estado)System.out.println("NO REGISTRA llave: "+llave+" tabla: "+nomtabla);	
		return estado;
   }
  public ArrayList<String[]> Generarlista(ResultSet rs,int numcolumnas){
	  
	  ArrayList<String[]> DatosTabla = new ArrayList<String[]>();
	  String[] columnas;

		 try {
        while (rs.next()) {        	   
  
        columnas=new String[numcolumnas];
        for (int i = 0; i < numcolumnas; i++) {columnas[i]=rs.getString(i+1);}//System.out.print(columnas[i]+" ");}System.out.println();
			DatosTabla.add(columnas);
				
        }
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}

		
		return DatosTabla;
	
  }
  //metodo q sirve para las pruebas
  public void MostrarTabla(ArrayList<String[]> tabla){
	
		int tamaño=tabla.size(); 
		 
		for (int i = 0; i < tamaño; i++) {
		String[] z=tabla.get(i);
		for (int j = 0; j < z.length; j++) System.out.print("   "+z[j]);
			
			System.out.println();
		}
  }


}
