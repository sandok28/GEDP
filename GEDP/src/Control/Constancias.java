package Control;
import java.util.ArrayList;  

import Entidad.Cursos;
import Entidad.Docentes;
import Entidad.Facultades;
import Entidad.GenerarExcel;
import Entidad.Periodos;
import Entidad.Programas;
import Entidad.Semestres;
import Entidad.Titulaciones;
import Entidad.Vinculaciones;

public class Constancias {
	
	Cursos cursos=new Cursos();
	Facultades facultades=new Facultades();
	Periodos periodos=new Periodos();
	Titulaciones titulaciones=new Titulaciones();
	Docentes docentes=new Docentes();
	Programas programas=new Programas();
	Semestres semestres=new Semestres();
	Vinculaciones vinculaciones=new Vinculaciones();
	GenerarExcel   Reportes=new GenerarExcel();
	
	
	// Genera reporte de todo los cursos que a dictado X profesor 
	public ArrayList<String[]> ConstanciaProfesores(String cedula){
		System.out.println("bislfebÑIWBCEÑW");
		ArrayList<String[]> Registrosprofesores=periodos.getRegistrosDocentes(cedula);	
		int tamaño=Registrosprofesores.size();
		
		for (int i = 0; i < tamaño; i++) {
			String[] pantallaRegistros=new String[12];
			String[] Registrosprof=Registrosprofesores.get(i);
			pantallaRegistros[0]=semestres.getAño(Registrosprof[0]);//Año
			pantallaRegistros[1]=semestres.getPeriodo(Registrosprof[0]);//periodo
			pantallaRegistros[2]=Registrosprof[5];//autoevaluacion
			pantallaRegistros[3]=Registrosprof[6];//evaluacion consejo
			pantallaRegistros[4]=Registrosprof[3];//curso
			pantallaRegistros[5]=Registrosprof[4];//grupo
			pantallaRegistros[6]=cursos.getnombre(Registrosprof[3]);//Nombre curso
			pantallaRegistros[7]=programas.getnombre(cursos.getidprogramas(Registrosprof[3]));//Nombre del programa
		    pantallaRegistros[8]=Registrosprof[7];//evaluacion estudiante
		    double porcentaje=Double.parseDouble(Registrosprof[5])+Double.parseDouble(Registrosprof[6])+Double.parseDouble(Registrosprof[7]);
		    pantallaRegistros[9]=Double.toString(porcentaje/3);//promedio evaluaciones
		    pantallaRegistros[10]=Double.toString(porcentaje)+"%";//porcentaje evaluaciones
		    if(porcentaje>=85)pantallaRegistros[11]="Sobresaliente";//calificacion evaluaciones
		    if(porcentaje>=70&&porcentaje<85)pantallaRegistros[11]="Buena";
		    if(porcentaje>=55&porcentaje<70)pantallaRegistros[11]="Regular";
		    if(porcentaje<55)pantallaRegistros[11]="Insufiente";
		    Registrosprofesores.set(i,pantallaRegistros);
		}
       		Reportes.ReporteDocente(Registrosprofesores,docentes.getnombre(cedula));
		
	return Registrosprofesores;
	}
	
	
	
	
	public void ConstanciafacultadesUnillanos(String año,String periodo,String id_vinculaciones,String id_titulaciones,String id_facultades){
		
		ArrayList<String[]> Listafacdocentes=periodos.getRegitrosFacultadDocentes(semestres.getid(año, periodo), id_vinculaciones, id_titulaciones, id_facultades);
		ArrayList<String[]> listafacultades=new ArrayList<String[]>();
		periodos.MostrarTabla(Listafacdocentes);
		int tamaño=Listafacdocentes.size();
		for (int i = 0; i < tamaño; i++) {
			String[] Registrosfacdocentes=Listafacdocentes.get(i);
			periodos.MostrarTabla(Listafacdocentes);
			
			ArrayList<String[]> ListafacdocentesCursos=periodos.getRegistrosDocentesCursos(Registrosfacdocentes[0],semestres.getid(año, periodo));
			int tam=ListafacdocentesCursos.size();
		
			for (int j = 0; j < tam; j++) {
				String[] RegistrosfacdocentesCursos=ListafacdocentesCursos.get(j);
				
				String[] pantallaRegistros=new String[12];
				pantallaRegistros[0]=Integer.toString(i+1);//numero asignado al docente
				pantallaRegistros[1]=docentes.getnombre(Registrosfacdocentes[0]);//nombre docente
				pantallaRegistros[2]=Registrosfacdocentes[1];//auto evaluacion
				pantallaRegistros[3]=Registrosfacdocentes[2];//evaluacion concejo
				pantallaRegistros[4]=RegistrosfacdocentesCursos[0];//id cursos
				pantallaRegistros[5]=RegistrosfacdocentesCursos[1];//grupo del curso
				pantallaRegistros[6]=cursos.getnombre(RegistrosfacdocentesCursos[0]);//nombre del curso
				pantallaRegistros[7]=programas.getnombre(cursos.getidprogramas(RegistrosfacdocentesCursos[0]));//nombre del programa
				pantallaRegistros[8]=RegistrosfacdocentesCursos[2];//nota estudiante
				String promedio=periodos.promedioevaluacionesestudinte(ListafacdocentesCursos,2);//nota promedio de todos los cursos de X docente
				pantallaRegistros[9]=promedio;
				double porcentaje=Double.parseDouble(Registrosfacdocentes[1])+Double.parseDouble(Registrosfacdocentes[2])+Double.parseDouble(promedio);
				pantallaRegistros[10]=Double.toString(porcentaje)+"%";//porcentaje de las evaluaciones
				if(porcentaje>=85)pantallaRegistros[11]="Sobresaliente";//calificacion evaluaciones
				if(porcentaje>=70&&porcentaje<85)pantallaRegistros[11]="Buena";
			    if(porcentaje>=55&porcentaje<70)pantallaRegistros[11]="Regular";
			    if(porcentaje<55)pantallaRegistros[11]="Insufiente";
			    listafacultades.add(pantallaRegistros);
			}
		}
		//periodos.MostrarTabla(listafacultades);
		if(periodo.equalsIgnoreCase("1"))periodo="PRIMERO"; else periodo="segundo";
		Reportes.ReporteFacultad(listafacultades, año, periodo, vinculaciones.getnombre(id_vinculaciones),titulaciones.getnombre(id_vinculaciones), facultades.getnombre(id_facultades),"Ni idea");
	}
	
public void ConstanciaCeres(String año,String periodo,String id_vinculaciones,String id_titulaciones,String id_facultades){
		
		ArrayList<String[]> Listafacdocentes=periodos.getRegitrosFacultadDocentes(semestres.getid(año, periodo), id_vinculaciones, id_titulaciones, id_facultades);
		ArrayList<String[]> listafacultades=new ArrayList<String[]>();
		periodos.MostrarTabla(Listafacdocentes);
		int tamaño=Listafacdocentes.size();
		for (int i = 0; i < tamaño; i++) {
			String[] Registrosfacdocentes=Listafacdocentes.get(i);
			periodos.MostrarTabla(Listafacdocentes);
			
			ArrayList<String[]> ListafacdocentesCursos=periodos.getRegistrosDocentesCursos(Registrosfacdocentes[0],semestres.getid(año, periodo));
			int tam=ListafacdocentesCursos.size();
		
			for (int j = 0; j < tam; j++) {
				String[] RegistrosfacdocentesCursos=ListafacdocentesCursos.get(j);
				
				String[] pantallaRegistros=new String[12];
				pantallaRegistros[0]=Integer.toString(i+1);//numero asignado al docente
				pantallaRegistros[1]=docentes.getnombre(Registrosfacdocentes[0]);//nombre docente
				pantallaRegistros[2]=Registrosfacdocentes[1];//auto evaluacion
				pantallaRegistros[3]=Registrosfacdocentes[2];//evaluacion concejo
				pantallaRegistros[4]=RegistrosfacdocentesCursos[0];//id cursos
				pantallaRegistros[5]=RegistrosfacdocentesCursos[1];//grupo del curso
				pantallaRegistros[6]=cursos.getnombre(RegistrosfacdocentesCursos[0]);//nombre del curso
				pantallaRegistros[7]=programas.getnombre(cursos.getidprogramas(RegistrosfacdocentesCursos[0]));//nombre del programa
				pantallaRegistros[8]=RegistrosfacdocentesCursos[2];//nota estudiante
				String promedio=periodos.promedioevaluacionesestudinte(ListafacdocentesCursos,2);//nota promedio de todos los cursos de X docente
				pantallaRegistros[9]=promedio;
				double porcentaje=Double.parseDouble(Registrosfacdocentes[1])+Double.parseDouble(Registrosfacdocentes[2])+Double.parseDouble(promedio);
				pantallaRegistros[10]=Double.toString(porcentaje)+"%";//porcentaje de las evaluaciones
				if(porcentaje>=85)pantallaRegistros[11]="Sobresaliente";//calificacion evaluaciones
				if(porcentaje>=70&&porcentaje<85)pantallaRegistros[11]="Buena";
			    if(porcentaje>=55&porcentaje<70)pantallaRegistros[11]="Regular";
			    if(porcentaje<55)pantallaRegistros[11]="Insufiente";
			    listafacultades.add(pantallaRegistros);
			}
		}
		//periodos.MostrarTabla(listafacultades);
		if(periodo.equalsIgnoreCase("1"))periodo="PRIMERO"; else periodo="segundo";
		Reportes.ReporteFacultad(listafacultades, año, periodo, vinculaciones.getnombre(id_vinculaciones),titulaciones.getnombre(id_vinculaciones), facultades.getnombre(id_facultades),"Ni idea");
	}
		
	

	public static void main(String[] args) {
	
		Constancias obj=new Constancias();
		obj.ConstanciafacultadesUnillanos("2015","1","1","1","1");
	//	obj.ConstanciaProfesores("1");
		
	}
	
	
	
	
	
	
	
}

