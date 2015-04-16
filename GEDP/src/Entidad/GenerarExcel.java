package Entidad;

import java.awt.Desktop;
import java.io.File; 
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;



import javax.xml.ws.spi.http.HttpHandler;

public class GenerarExcel {

	HSSFWorkbook libro;
	HSSFSheet hoja;
	CellStyle headerStyle;
	FileOutputStream archivo;
	File archivoXLS;
	public GenerarExcel(){}
	public void Cerarestructura(String rutaArchivo ){
		archivoXLS = new File(rutaArchivo);
		if(archivoXLS.exists()) archivoXLS.delete();
		
		try {
			archivoXLS.createNewFile();
		    libro = new HSSFWorkbook();//crear libro excel
			archivo = new FileOutputStream(archivoXLS);//crear conecion
			hoja = libro.createSheet("hoja 1");//Crear hoja excel
			headerStyle = libro.createCellStyle();//crear estilo
            headerStyle.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());//color del estilo
            Font hfont = libro.createFont();//crear fuente
            hfont.setFontHeightInPoints((short)10);//tamaño de la fuente
            hfont.setBoldweight(Font.BOLDWEIGHT_BOLD);//definir fuente
            headerStyle.setFont(hfont);//agregar fuente al estilo
            headerStyle.setAlignment(CellStyle.ALIGN_CENTER);//Para centrar
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void ReporteDocente(ArrayList<String[]> lista,String nombreDocumento){
		
		
		Cerarestructura(System.getProperty("user.home")+"/"+nombreDocumento+" Ev Doc.xls");
            
            UnirCeldas(hoja, 0, 0, 0, 11);//unit celdas :D
            UnirCeldas(hoja,1,2,0,0);
            UnirCeldas(hoja,1,2,1,1);
            UnirCeldas(hoja,1,2,2,2);
            UnirCeldas(hoja,1,2,3,3);
            UnirCeldas(hoja,1,1,4,7);
            UnirCeldas(hoja,1,2,8,8);
            UnirCeldas(hoja,1,2,9,9);
            UnirCeldas(hoja,1,2,10,10);
            UnirCeldas(hoja,1,2,11,11);
           
          int tamaño=lista.size()+3;
			for(int filas=0;filas<tamaño;filas++){
				
				  
				HSSFRow fila = hoja.createRow(filas);
				
				for(int columnas=0;columnas<12;columnas++){
					
					   HSSFCell celda = fila.createCell(columnas);
					   hoja.autoSizeColumn((short)columnas);//MUY IMPORTANTE GRADUA EL TAMAÑO DE LA COLUMNA 
					  
					   if(filas==0&&columnas==0) celda.setCellValue("Resultados de EvaluaciónDocente de "+nombreDocumento);
					   else if(filas==1&&columnas==0) celda.setCellValue("Año");
					   else if(filas==1&&columnas==1) celda.setCellValue("PA");
					   else if(filas==1&&columnas==2) celda.setCellValue("AUTO \n (25%)");
					   else if(filas==1&&columnas==3) celda.setCellValue("CONCEJO \n (35%)");
					   else if(filas==1&&columnas==4) celda.setCellValue("CURSO");
					   else if(filas==1&&columnas==8) celda.setCellValue("ESTUDIANTES \n (40%)");
					   else if(filas==1&&columnas==9) celda.setCellValue("PROM. \n EST.");
					   else if(filas==1&&columnas==10) celda.setCellValue("%");
					   else if(filas==1&&columnas==11) celda.setCellValue("EVALUACION \n CUALITATIVA");
					   else if(filas==2&&columnas==4) celda.setCellValue("CODIGO");
					   else if(filas==2&&columnas==5) celda.setCellValue("G.");
					   else if(filas==2&&columnas==6) celda.setCellValue("NOBPRE");
					   else if(filas==2&&columnas==7) celda.setCellValue("PRG.");
					   else if(filas>2){ String[] info=lista.get(filas-3); for (int i = 0; i < info.length; i++) if(columnas==i)celda.setCellValue(info[i]);}
					 			
					   else celda.setCellValue("Valor celda "+columnas+","+filas);
					   
					   
					 
					
					celda.setCellStyle(headerStyle);
					
				}
				   
						
			}
			try {
			libro.write(archivo);
			archivo.close();
			Desktop.getDesktop().open(archivoXLS);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	
public void ReporteFacultad(ArrayList<String[]> lista,String año,String periodo,String nombrevinculacion,String nombretitulacion,String nombrefacultad,String nombreDocumento){
				
		Cerarestructura(System.getProperty("user.home")+"/"+nombreDocumento+" Ev Doc.xls");
            UnirCeldas(hoja,0,1,0,8);
            UnirCeldas(hoja,2,2,0,8);
            UnirCeldas(hoja,3,3,0,8);
            UnirCeldas(hoja,4,4,0,11);
            UnirCeldas(hoja,5,5,0,11);
            UnirCeldas(hoja,6,6,0,11);
            UnirCeldas(hoja,7,7,0,11);
            UnirCeldas(hoja,8,8,0,11);
            UnirCeldas(hoja,9,9,0,11);
            
            
            UnirCeldas(hoja,10,11,0,0);
            UnirCeldas(hoja,10,11,1,1);
            UnirCeldas(hoja,10,11,2,2);
            UnirCeldas(hoja,10,11,3,3);
            UnirCeldas(hoja,10,10,4,7);
            UnirCeldas(hoja,10,11,8,8);
            UnirCeldas(hoja,10,11,9,9);
            UnirCeldas(hoja,10,11,10,10);
            UnirCeldas(hoja,10,11,11,11);
            
            int tamaño=lista.size()+12;
            int filaini=11;
            int filafin=11;
            String puestodocente="";
            
        
			for(int filas=0;filas<tamaño;filas++){
				
				  
				HSSFRow fila = hoja.createRow(filas);
				
				for(int columnas=0;columnas<12;columnas++){
					
					   HSSFCell celda = fila.createCell(columnas);
					   hoja.autoSizeColumn((short)columnas);//MUY IMPORTANTE GRADUA EL TAMAÑO DE LA COLUMNA 
					  
					   if(filas==0&&columnas==0) celda.setCellValue(" UNIVERSIDAD DE LOS LLANOS ");
					   else if(filas==2&&columnas==0) celda.setCellValue("PROCESO DE GESTION DE TALENTO HUMANO");
					   else if(filas==3&&columnas==0) celda.setCellValue("FORMATO DE RESULTADOS DE EVALUACION DOCENTES "+nombretitulacion);
					   else if(filas==0&&columnas==9) celda.setCellValue("CODIGO: FO-GTH-73");
					   else if(filas==1&&columnas==9) celda.setCellValue("VERSION: 01");
					   else if(filas==1&&columnas==11) celda.setCellValue("PAGINAS 1 *");
					   else if(filas==2&&columnas==9) celda.setCellValue("FECHA HOY");
					   else if(filas==3&&columnas==9) celda.setCellValue("VIGENCIA PENDIENTE ");
					   else if(filas==5&&columnas==0) celda.setCellValue("VICE RECTORIA ACADEMICA");
					   else if(filas==6&&columnas==0) celda.setCellValue("COMITE DE EVALUACION Y PROMOCION DOCENTE");
					   else if(filas==7&&columnas==0) celda.setCellValue("DOCENTES DE "+nombrevinculacion+" - "+nombrefacultad);
					   else if(filas==8&&columnas==0) celda.setCellValue(periodo+" PERIODO ACADEMICO DE "+año);
					
					   else if(filas==10&&columnas==0) celda.setCellValue("No. ");
					   else if(filas==10&&columnas==1) celda.setCellValue("Docente");
					   else if(filas==10&&columnas==2) celda.setCellValue("AUTO \n (25%)");
					   else if(filas==10&&columnas==3) celda.setCellValue("CONCEJO \n (35%)");
					   else if(filas==10&&columnas==4) celda.setCellValue("CURSO");
					   else if(filas==10&&columnas==8) celda.setCellValue("ESTUDIANTES \n (40%)");
					   else if(filas==10&&columnas==9) celda.setCellValue("PROM. \n EST.");
					   else if(filas==10&&columnas==10) celda.setCellValue("%");
					   else if(filas==10&&columnas==11) celda.setCellValue("EVALUACION \n CUALITATIVA");
					   else if(filas==11&&columnas==4) celda.setCellValue("CODIGO");
					   else if(filas==11&&columnas==5) celda.setCellValue("G.");
					   else if(filas==11&&columnas==6) celda.setCellValue("NOMBRE");
					   else if(filas==11&&columnas==7) celda.setCellValue("PRG.");
					   else if(filas>11){
						   String[] info=lista.get(filas-12);
						
						if(columnas==0){
							  
							
							   if(puestodocente.equalsIgnoreCase(info[0])){filafin++;}
							   else {puestodocente=info[0];filaini=filafin+1;filafin=filaini;}
							   UnirCeldas(hoja,filaini,filafin,0,0);
							   UnirCeldas(hoja,filaini,filafin,1,1);
							   UnirCeldas(hoja,filaini,filafin,2,2);
							   UnirCeldas(hoja,filaini,filafin,3,3);
							   UnirCeldas(hoja,filaini,filafin,9,9);
							   UnirCeldas(hoja,filaini,filafin,10,10);
							   UnirCeldas(hoja,filaini,filafin,11,11);
						}
						   for (int i = 0; i < info.length; i++){
							   
							   
							   if(columnas==i){ 
								   
								   
								   celda.setCellValue(info[i]);
								   }
							   
						      }
						   }
					 
					 			
					  // else celda.setCellValue("Valor celda "+columnas+","+filas);//para puebas de ubicacion 
					   else celda.setCellValue("             ");
					   
					   
					 
					
					celda.setCellStyle(headerStyle);
					
				}
				   
						
			}
			
		try{	
			libro.write(archivo);
			archivo.close();
			Desktop.getDesktop().open(archivoXLS);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
public void ReporteFacultadCeres(ArrayList<String[]> lista,String año,String periodo,String nombrefacultad,String nombreDocumento){
	
	Cerarestructura(System.getProperty("user.home")+"/"+nombreDocumento+" Ev Doc.xls");
        UnirCeldas(hoja,0,1,0,8);
        UnirCeldas(hoja,2,2,0,8);
        UnirCeldas(hoja,3,3,0,8);
        UnirCeldas(hoja,4,4,0,11);
        UnirCeldas(hoja,5,5,0,11);
        UnirCeldas(hoja,6,6,0,11);
        UnirCeldas(hoja,7,7,0,11);
        UnirCeldas(hoja,8,8,0,11);
        UnirCeldas(hoja,9,9,0,11);
        
        
        UnirCeldas(hoja,10,11,0,0);
        UnirCeldas(hoja,10,11,1,1);
        UnirCeldas(hoja,10,11,2,2);
        UnirCeldas(hoja,10,11,3,3);
        UnirCeldas(hoja,10,10,4,7);
        UnirCeldas(hoja,10,11,8,8);
        UnirCeldas(hoja,10,11,9,9);
        UnirCeldas(hoja,10,11,10,10);
        UnirCeldas(hoja,10,11,11,11);
        
        int tamaño=lista.size()+12;
        int filaini=11;
        int filafin=11;
        String puestodocente="";
        
    
		for(int filas=0;filas<tamaño;filas++){
			
			  
			HSSFRow fila = hoja.createRow(filas);
			
			for(int columnas=0;columnas<12;columnas++){
				
				   HSSFCell celda = fila.createCell(columnas);
				   hoja.autoSizeColumn((short)columnas);//MUY IMPORTANTE GRADUA EL TAMAÑO DE LA COLUMNA 
				  
				   if(filas==0&&columnas==0) celda.setCellValue(" UNIVERSIDAD DE LOS LLANOS ");
				   else if(filas==2&&columnas==0) celda.setCellValue("PROCESO DE GESTION DE TALENTO HUMANO");
				   else if(filas==3&&columnas==0) celda.setCellValue("FORMATO DE RESULTADOS DE EVALUACION DOCENTES TUTORES CERES");
				   else if(filas==0&&columnas==9) celda.setCellValue("CODIGO: FO-GTH-73");
				   else if(filas==1&&columnas==9) celda.setCellValue("VERSION: 01");
				   else if(filas==1&&columnas==11) celda.setCellValue("PAGINAS 1 *");
				   else if(filas==2&&columnas==9) celda.setCellValue("FECHA HOY");
				   else if(filas==3&&columnas==9) celda.setCellValue("VIGENCIA PENDIENTE ");
				   else if(filas==5&&columnas==0) celda.setCellValue("VICERECTORIA ACADEMICA");
				   else if(filas==6&&columnas==0) celda.setCellValue("COMITE DE EVALUACION Y PROMOCION DOCENTE");
				   else if(filas==7&&columnas==0) celda.setCellValue(nombrefacultad+" - "+periodo+" PERIODO ACADEMICO DE "+año);
				
				   else if(filas==10&&columnas==0) celda.setCellValue("No. ");
				   else if(filas==10&&columnas==1) celda.setCellValue("Docente");
				   else if(filas==10&&columnas==2) celda.setCellValue("AUTO \n (25%)");
				   else if(filas==10&&columnas==3) celda.setCellValue("CONCEJO \n (35%)");
				   else if(filas==10&&columnas==4) celda.setCellValue("CURSO");
				   else if(filas==10&&columnas==8) celda.setCellValue("CERES");
				   else if(filas==10&&columnas==9) celda.setCellValue("ESTUDIANTES \n (40%)");
				   else if(filas==10&&columnas==10) celda.setCellValue("PROM. \n EST.");
				   else if(filas==10&&columnas==11) celda.setCellValue("%");
				   else if(filas==10&&columnas==12) celda.setCellValue("EVALUACION \n CUALITATIVA");
				   else if(filas==11&&columnas==4) celda.setCellValue("CODIGO");
				   else if(filas==11&&columnas==5) celda.setCellValue("G.");
				   else if(filas==11&&columnas==6) celda.setCellValue("NOMBRE");
				   else if(filas==11&&columnas==7) celda.setCellValue("PRG.");
				 else if(filas>11){
					   String[] info=lista.get(filas-12);
					
					if(columnas==0){
						  
						
						   if(puestodocente.equalsIgnoreCase(info[0])){filafin++;}
						   else {puestodocente=info[0];filaini=filafin+1;filafin=filaini;}
						   UnirCeldas(hoja,filaini,filafin,0,0);
						   UnirCeldas(hoja,filaini,filafin,1,1);
						   UnirCeldas(hoja,filaini,filafin,2,2);
						   UnirCeldas(hoja,filaini,filafin,3,3);
						   UnirCeldas(hoja,filaini,filafin,9,9);
						   UnirCeldas(hoja,filaini,filafin,10,10);
						   UnirCeldas(hoja,filaini,filafin,11,11);
					}
					   for (int i = 0; i < info.length; i++){
						   
						   
						   if(columnas==i){ 
							   
							   
							   celda.setCellValue(info[i]);
							   }
						   
					      }
					   }
				 
				 		
				   else celda.setCellValue("Valor celda "+columnas+","+filas);//para puebas de ubicacion 
				  // else celda.setCellValue("             ");
				   
				   
				 
				
				celda.setCellStyle(headerStyle);
				
			}
			   
					
		}
		
	try{	
		libro.write(archivo);
		archivo.close();
		Desktop.getDesktop().open(archivoXLS);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}



	public void UnirCeldas(HSSFSheet hoja,int filainicio,int filafinal,int columnainicio,int columnafinal){
		hoja.addMergedRegion(new CellRangeAddress(filainicio,filafinal,columnainicio,columnafinal));		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		GenerarExcel obj=new GenerarExcel();
		//obj.ReporteFacultad("sad");
	}
	
	
	
}
