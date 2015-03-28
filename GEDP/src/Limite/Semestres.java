package Limite;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;

public class Semestres extends Conexion{
	ArrayList<String[]> DatosTabla = new ArrayList<String[]>();
	int numcolumnas=3;
	String tabla="semestres";
	public Semestres() {
	super();
	}
	
	//AGREGA NUEVOS SEMESTRES A LA TABLA
	public void agregar(String id,String año,String periodo){
		super.sentencia("INSERT INTO "+tabla+" VALUES('"+id+"','"+año+"','"+periodo+"');");
		
	}
	
	
	public String  getAño(String id){
	ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"';");
	String año="No registra "+id ;
	 try {
		 
		while (rs.next()) {
       	año=rs.getString(2);
		}
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
	return año;
}
	public String  getPeriodo(String id){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_"+tabla+"='"+id+"'");
		String periodo="No registra "+id ;
		 try {
			 while (rs.next()) {
					
				periodo=rs.getString(3);
			 }
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return periodo;
	}
	
	public String  getid(String año,String periodo){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE año='"+año+"' AND periodo='"+periodo+"'");
		String idsemestres="No registra "+año+"  "+periodo ;
		 try {
			 
			while (rs.next()) {

				idsemestres=rs.getString(1);
			}
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
		return idsemestres;
	}	
		
}
