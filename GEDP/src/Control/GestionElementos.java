package Control;
import Limite.Cargos; 
import Limite.Cursos;
import Limite.Facultades;
import Limite.Periodos;
import Limite.Docentes;
import Limite.Programas;
import Limite.Titulaciones;
import Limite.Vinculaciones;
public class GestionElementos {
	
	Cargos cargos=new Cargos();
	Cursos cursos=new Cursos();
	Facultades facultades=new Facultades();
	Periodos periodos=new Periodos();
	Docentes docentes=new Docentes();
	Titulaciones titulaciones=new Titulaciones();
	Programas programas=new Programas();
	Vinculaciones vinculaciones=new Vinculaciones();
	
	//Profesores
	public void AgregarDocentes(String cedula,String nombre,String fehcaingreso){
		docentes.agregar(cedula, nombre, fehcaingreso);		
	}
	public boolean ModificarNombreProfesores(String cedula,String newnombre){
		return  docentes.setnombre(cedula, newnombre);
	}
	public boolean ModificarFechaProfesores(String cedula,String newfecha){
		return  docentes.setfecha(cedula, newfecha);
	}
	public boolean Modificarid_Profesores(String cedula,String newcedula){
		return  docentes.setid(cedula, newcedula);
	}
	
	//Titulaciones
		public void AgregarTitulaciones(String id_titulaciones,String nombre){
			titulaciones.agregar(id_titulaciones, nombre);		
		}
		public boolean ModificarNombreTitulaciones(String id_titulaciones,String newnombre){
			return  titulaciones.setnombre(id_titulaciones, newnombre);
		}
		public boolean Modificarid_Titulaciones(String id_titulaciones,String newid_titulaciones){
			return titulaciones.setid(id_titulaciones, newid_titulaciones);
		}
	
	//Programas
	public void AgregarProgramas(String id_programas,String nombre,String id_facultades,String id_titulaciones){
		programas.agregar(id_programas, nombre,id_facultades,id_titulaciones);		
	}
	public boolean ModificarNombreProgramas(String id_programas,String newnombre){
		return  programas.setnombre(id_programas, newnombre);
	}
	public boolean Modificarid_Programas(String id_programas,String newid_programas){
		return programas.setid(id_programas, newid_programas);
	}
	public boolean Modificarid_titulaciones(String id_programas,String newid_titulaciones){
		return programas.settidtitulaciones(id_programas, newid_titulaciones);
	}
	
	//Cargos
	public void AgregarCargos(String id_cargos,String nombre){
		cargos.agregar(id_cargos, nombre);		
	}
	public boolean ModificarNombreCargos(String id_cargos,String newnombre){
		return  cargos.setnombre(id_cargos, newnombre);
	}
	public boolean Modificarid_Cargos(String id_cargos,String newid_cargos){
		return cargos.setid(id_cargos, newid_cargos);
	}
	//Cursos
	public void AgregarCursos(String id_cursos,String nombre,String id_programas){
		cursos.agregar(id_cursos, nombre,id_programas);		
	}
	public boolean ModificarNombreCursos(String id_cursos,String newnombre){
		return  cursos.setnombre(id_cursos, newnombre);
	}
	public boolean Modificarid_Cursos(String id_cursos,String newid_cursos){
		return cursos.setid(id_cursos, newid_cursos);
	}
	public boolean Modificarid_programasCursos(String id_cursos,String newid_cursos){
		return cursos.setidprogramas(id_cursos, newid_cursos);
	}
	//Facultades
	public void AgregarFacultades(String id_facultades,String nombre){
		facultades.agregar(id_facultades, nombre);		
	}
	public boolean ModificarNombreFacultades(String id_facultades,String newnombre){
		return  facultades.setnombre(id_facultades, newnombre);
	}
	public boolean Modificarid_Facultades(String id_facultades,String newid_facultades){
		return facultades.setid(id_facultades, newid_facultades);
	}
	//Vinculaciones
	public void AgregarVinculaciones(String id_vinculaciones,String nombre){
		vinculaciones.agregar(id_vinculaciones, nombre);		
	}
	public boolean ModificarNombreVinculaciones(String id_vinculaciones,String newnombre){
		return  vinculaciones.setnombre(id_vinculaciones, newnombre);
	}
	public boolean Modificarid_Vinculaciones(String id_vinculaciones,String newid_facultades){
		return vinculaciones.setid(id_vinculaciones, newid_facultades);
	}
	
	//Periodos
	public void AgregarPeriodos(String id_semestre,String id_profesores,String id_vinculaciones,String id_facultades,String id_cursos,String grupo,String autoevaluacion,String evaluacionconsejo,String evaluacionestudiante){
		periodos.agregar(id_semestre,id_profesores,id_vinculaciones,id_cursos,grupo,autoevaluacion,evaluacionconsejo,evaluacionestudiante);	
	}
	
	public void EliminarPeriodos(String id_semestres,String id_profesores,String id_cursos,String grupo){
		periodos.EleminarRegistro(id_semestres, id_profesores, id_cursos, grupo);
	}
	
}
