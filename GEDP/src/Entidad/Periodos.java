package Entidad;
import java.sql.ResultSet;   
import java.sql.SQLException;
import java.util.ArrayList;

public class Periodos extends Conexion{
	
	int numcolumnas=8;
	String tabla="periodos";
	public Periodos() {
	super();
	}
	
	//AGREGA NUEVOS PERIODOS A LA TABLA
	public void agregar(String id_semestres,String id_docentes,String id_vinculaciones,String id_cursos,String grupo,String autoevaluacion,String evaluacionconsejo,String evaluacionestudiante){
	super.sentencia("INSERT INTO "+tabla+" VALUES('"+id_semestres+"','"+id_docentes+"','"+id_vinculaciones+"','"+id_cursos+"',"+grupo+",'"+autoevaluacion+"','"+evaluacionconsejo+"','"+evaluacionestudiante+"');");	

	}

	public boolean EleminarRegistro(String id_semestres,String id_docentes,String id_cursos,String grupo){
		super.sentencia("DELETE FROM "+tabla+" WHERE id_semestres='"+id_semestres+"' AND id_docentes='"+id_docentes+"' AND id_cursos='"+id_cursos+"' AND grupo="+grupo+";");
		return true;
	}
		
	public ArrayList<String[]> getRegistrosDocentes(String id_docentes){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+" WHERE id_docentes='"+id_docentes+"';");
		
		return Generarlista(rs, numcolumnas);
	}
	//me trae los id_cursos,grupo,evaluacionestudiante de un profesor en x año, periodo
	public ArrayList<String[]> getRegistrosDocentesCursos(String id_docentes,String id_semestres){
		ResultSet rs=super.sentencia("SELECT id_cursos,grupo,evaluacionestudiante FROM "+tabla+" WHERE id_docentes='"+id_docentes+"'AND id_semestres='"+id_semestres+"';");
		
		return Generarlista(rs,3);
	}
	
	public String promedioevaluacionesestudinte(ArrayList<String[]> lista,int columna){
		double suma=0;
		int tamaño=lista.size();
		for (int i = 0; i < tamaño; i++) {
			String[] fila=lista.get(i);
			suma+=Double.parseDouble(fila[columna]);
			
		}
		double promedio=suma/tamaño;
		return Double.toString(promedio);
	}
	
	//OBTIENE EL ID DE LOS PROFESORES,AUTOEVAUACION,EVALUACIONCONCEJO  Q DICTARON EN ESE PERIODO FILTRANDO POR FACULTAD Y VINCULACION
	//sirve tambien para los ceres pero estos no tiene vinculacion ni titulacion o puede ser titulacion Ceres asi de simple 
	
	public ArrayList<String[]> getReistrosCursos(String id_docentes){
		ResultSet rs=super.sentencia("SELECT id_cursos,grupo,evaluacionestudiante FROM "+tabla+" WHERE id_docentes='"+id_docentes+"';");
		//solo retorna id_curso grupo evaluacioestudiante
		return Generarlista(rs, 3);
	}
	
	public ArrayList<String[]> getRegitrosFacultadDocentes(String id_semestres,String id_vinculaciones,String id_titulaciones,String id_facultades){
		
		ResultSet rs=super.sentencia(" SELECT periodos.id_docentes,periodos.autoevaluacion,periodos.evaluacionconsejo,count(*)"+ 
                                     " FROM  periodos"+
                                     " INNER JOIN cursos ON periodos.id_semestres='"+id_semestres+"' AND periodos.id_vinculaciones='"+id_vinculaciones+"' AND periodos.id_cursos=cursos.id_cursos "+
                                     " INNER JOIN programas ON  cursos.id_programas=programas.id_programas"+
                                     " INNER JOIN titulaciones ON titulaciones.id_titulaciones=programas.id_titulaciones AND programas.id_titulaciones='"+id_titulaciones+"'"+
                                     " INNER JOIN facultades ON  programas.id_facultades=facultades.id_facultades AND facultades.id_facultades='"+id_facultades+"'"+
                                     " GROUP BY periodos.id_docentes,autoevaluacion,evaluacionconsejo;");
		//solo retorna id_docente evaluacionconcejo y autoevaluacion
		
		return Generarlista(rs,3);
	}
	
	
	public ArrayList<String[]> getRegitrosFacultades(String id_semestres,String id_vinculaciones,String id_titulaciones,String id_facultades){
		
		ResultSet rs=super.sentencia(" SELECT periodos.id_docentes,periodos.autoevaluacion,periodos.evaluacionconsejo,periodos.id_cursos,periodos.grupo,cursos.nomb_cursos,programas.nomb_programas,ceres.nomb_ceres,periodos.evaluacionestudiante"+ 
                                     " FROM  periodos"+
                                     " INNER JOIN cursos ON periodos.id_semestres='"+id_semestres+"' AND periodos.id_vinculaciones='"+id_vinculaciones+"'"+
                                     " INNER JOIN ceres ON ceres.id_ceres=cursos.id_ceres"+
                                     " INNER JOIN programas ON  cursos.id_programas=programas.id_programas"+
                                     " INNER JOIN titulaciones ON titulaciones.id_titulaciones=programas.id_titulaciones AND programas.id_titulaciones='"+id_titulaciones+"'"+
                                     " INNER JOIN facultades ON  programas.id_facultades=facultades.id_facultades AND facultades.id_facultades='"+id_facultades+"'");
		//solo retorna id_docente evaluacionconcejo y autoevaluacion
		
		return Generarlista(rs,9);
	}
	
	
	
	public ArrayList<String[]> getRegitrosFacultadesCeres(String id_semestres,String id_vinculaciones,String id_titulaciones,String id_facultades){
		ResultSet rs=super.sentencia(" SELECT periodos.id_docentes,periodos.autoevaluacion,periodos.evaluacionconsejo,periodos.id_cursos,periodos.grupo,cursos.nomb_cursos,programas.nomb_programas,periodos.evaluacionestudiante"+ 
                                     " FROM  periodos"+
                                     " INNER JOIN cursos ON periodos.id_semestres='"+id_semestres+"' AND periodos.id_vinculaciones='"+id_vinculaciones+"' AND periodos.id_cursos=cursos.id_cursos AND cursosid_ceres!='1' "+  
                                     " INNER JOIN programas ON  cursos.id_programas=programas.id_programas"+
                                     " INNER JOIN titulaciones ON titulaciones.id_titulaciones=programas.id_titulaciones AND programas.id_titulaciones='"+id_titulaciones+"'"+
                                     " INNER JOIN facultades ON  programas.id_facultades=facultades.id_facultades AND facultades.id_facultades='"+id_facultades+"'");
		//solo retorna id_docente evaluacionconcejo y autoevaluacion
		
		return Generarlista(rs,8);
	}
	
	
	
	
	
	
	
	public ArrayList<String[]> getTabla(){
		ResultSet rs=super.sentencia("SELECT * FROM "+tabla+";");
		return Generarlista(rs, 3);
		
	}
	
public static void main(String[] args) {
	Periodos obj=new Periodos();
	
	//idsemestres='20151' AND idvinculaciones='1' AND idfacultades='61';
	//obj.MostrarTabla(obj.getRegitrosFacultad("20141","1","1","2"));
	//obj.MostrarTabla(obj.getReistrosCursos("1"));
	
}

}

