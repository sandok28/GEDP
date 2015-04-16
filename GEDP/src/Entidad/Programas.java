package Entidad;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;

public class Programas extends Conexion{
	ArrayList<String[]> DatosTabla = new ArrayList<String[]>();
	int numcolumnas=4;
	String tabla="programas";
	public Programas() {
	super();
	}
	
	//AGREGA NUEVOS PROGRAMAS A LA TABLA
	public void agregar(String id,String nombre,String idfacultades,String idtitulaciones){
		super.sentencia("INSERT INTO "+tabla+" VALUES('"+id+"','"+nombre+"','"+idfacultades+"','"+idtitulaciones+"');");		
	}
	
	public boolean  setid(String id,String newid){
		boolean estado=true;
		if(super.validar(newid, tabla)){System.out.println("LLAVE YA EXISTE");estado=false;}
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
	public boolean  settidfacultades(String id,String newidfacultades){
		boolean estado=true;
		if(super.validar(id, tabla))super.sentencia("UPDATE "+tabla+" SET id_facultades='"+newidfacultades+"' WHERE id_"+tabla+"='"+id+"'");
		else estado=false;
	return estado;
}
	public boolean  settidtitulaciones(String id,String newidtitulaciones){
		boolean estado=true;
		if(super.validar(id, tabla))super.sentencia("UPDATE "+tabla+" SET id_titulaciones='"+newidtitulaciones+"' WHERE id_"+tabla+"='"+id+"'");
		else estado=false;
	return estado;
}

	public String  getid(String nomb_programas){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE nomb_"+tabla+"='"+nomb_programas+"'");
		String id="No registra "+nomb_programas ;
		 try {
			 
			while (rs.next()) {

				id=rs.getString(2);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return id;
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
	public String  getidfacultades(int id){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"'");
		String id_facultades="No registra "+id ;
		 try {
			 
			while (rs.next()) {

				id_facultades=rs.getString(4);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return id_facultades;
	}
	public String  getidtitulaciones(int id){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"'");
		String id_titulaciones="No registra "+id ;
		 try {
			 
			while (rs.next()) {

				id_titulaciones=rs.getString(4);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return id_titulaciones;
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