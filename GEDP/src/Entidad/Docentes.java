package Entidad; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;

public class Docentes extends Conexion{
	ArrayList<String[]> DatosTabla = new ArrayList<String[]>();
	int numcolumnas=3;
	String tabla="docentes";
	public Docentes() {
	super();
	}
	
	//AGREGA NUEVOS DOCENTES A LA TABLA
		public void agregar(String id,String nomb,String fechaingreso){
			super.sentencia("INSERT INTO "+tabla+" VALUES('"+id+"','"+nomb+",'"+fechaingreso+"');");
		}
		
		public boolean  setid(String id,String newid){
			boolean estado=true;
			if(super.validar(newid,tabla)){System.out.println("LLAVE YA EXISTE");estado=false;}
			else if(super.validar(id, tabla))super.sentencia("UPDATE "+tabla+" SET id_"+tabla+"='"+newid+"' WHERE id_"+tabla+"='"+id+"'");
			else estado=false;
		return estado;
	    }
		
		public boolean  setnombre(String id,String newnomb){
			boolean estado=true;
			if(super.validar(id, tabla))super.sentencia("UPDATE "+tabla+" SET nomb_"+tabla+"='"+newnomb+"' WHERE id_"+tabla+"='"+id+"'");
			else estado=false;
		return estado;
	    }
		
		public boolean  setfecha(String id,String newfecha){
			boolean estado=true;
			if(super.validar(id, tabla))super.sentencia("UPDATE "+tabla+" SET fecha_ingreso='"+newfecha+"' WHERE id_"+tabla+"='"+id+"'");
			else estado=false;
		return estado;
	    }
		
		public String  getnombre(String id){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"'");
		String nombre="No registra "+id ;
		 try {
			 
			while (rs.next()) {

				nombre=rs.getString(2);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return nombre;
	    }
	
	
	
	
	public String  getfecha(String id){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"'");
		String fecha="No registra "+id;
		 try {
			 
			while (rs.next()) {

				fecha=rs.getString(3);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return fecha;
	 }

	
	
	public ArrayList<String[]> getTabla(){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+";");
		ArrayList<String[]> DatosTabla = new ArrayList<String[]>();
		
	String[] columnas;

		 try {
           while (rs.next()) {
           columnas=new String[numcolumnas];
           for (int i = 0; i < numcolumnas; i++) columnas[i]=rs.getString(i+1);
			DatosTabla.add(columnas);
			
			}			
			
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}

		return DatosTabla;
	}
	
}
