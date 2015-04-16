package Control;
import Entidad.Cursos;
import Entidad.Docentes;
import Entidad.Facultades;
import Entidad.Periodos;
import Entidad.Programas;
import Entidad.Semestres;
import Entidad.Vinculaciones;

public class RegistrarConstancia {
	
	Cursos cursos=new Cursos();
	Facultades facultades=new Facultades();
	Periodos periodos=new Periodos();
	Docentes profesores=new Docentes();
	Programas programas=new Programas();
	Semestres semestres=new Semestres();
	Vinculaciones vinculaciones=new Vinculaciones();
	
	public void AgregarRegistrarconstancia(String año,String periodo,String cedula,String id_vinculaciones,String id_cursos,String grupo,String autoevaluacion,String evaluacionconsejo,String evaluacionestudiante){
			String id_semestre=semestres.getid(año, periodo);
       periodos.agregar(id_semestre, cedula, id_vinculaciones, id_cursos, grupo, autoevaluacion, evaluacionconsejo, evaluacionestudiante);
	}
	
	public String getProfesoresNombre(String cedula){
		return profesores.getnombre(cedula);
	}
	public String getVinculacionesNombre(String id_Vinculaciones){
		return vinculaciones.getnombre(id_Vinculaciones);
	}
	
	public String getFacultadesNombre(String id_facultades){
		return vinculaciones.getnombre(id_facultades);
	}
	
	public String getCursosNombre(String id_cursos){
		return cursos.getnombre(id_cursos);
	}
}
