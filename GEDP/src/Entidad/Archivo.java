package Entidad;
import java.io.*;       
import javax.swing.*;



public class Archivo {
	
	//declaraciones
File archivo;
FileReader leerArchivo;
BufferedReader canallectura;
int lineas,contador;


// la clase hace crea el archivo si no esta creado y crea una facilidad para acceder a lor achivos
public Archivo(String nombre){
archivo=new File("/home/sandok/Documentos/Eclipseproyectos/generarSQL/"+nombre+".txt");	
try {
	if(!archivo.exists()){
		archivo.createNewFile();
	}
} catch (Exception e) {
	JOptionPane.showMessageDialog(null, "No se pudo crear archivo","ERROR",JOptionPane.WARNING_MESSAGE);
}
lineas=contarlineas();
contador=0;
}
public int contarlineas(){
	contador=0;
	try {
	leerArchivo=new FileReader(archivo);
	canallectura=new BufferedReader(leerArchivo);
	while(canallectura.readLine()!=null)contador++;
	} catch (Exception e) {
		
	}
		return contador;	
}
// lee el archivo y retorna una matris String con todos los datos del archivo
public String[][] leer(){
	
	contador=0;
	String info[][]=new String[lineas][2],linea;
	if (lineas!=0) {
		try {
			leerArchivo=new FileReader(archivo);
			canallectura=new BufferedReader(leerArchivo);
			
			while((linea=canallectura.readLine())!=null){
				String aux[]=linea.split(",");
				info[contador][0]=aux[0];	
				contador++;
			}
		} catch (Exception e) {
			System.out.println("ERROR EN EL LEER DE ARCHIVO");
		}
	}


	
return info;
}
// guarda el vector q resibe en archivo
public void guardar(String datos){
	
	String info[]=new String[(lineas+1)];
		if(lineas!=0){
			String aux[][]=leer();
		for (int i = 0; i <lineas; i++) {
        info[i]=aux[i][0];
		}
		info[lineas]=datos;
		}
		else{info[0]=datos;
		}
	try {
		
	PrintWriter archivoSalida=new PrintWriter(new FileWriter(archivo));
	for (int i = 0; i < info.length; i++) {
       archivoSalida.println(info[i]);
	}
	
	archivoSalida.flush();
	archivoSalida.close();
	} catch (Exception e) {
	
	}
}

}
	



