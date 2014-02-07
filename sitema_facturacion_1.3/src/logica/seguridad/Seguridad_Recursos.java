package logica.seguridad;

	/**********CLASE DE GESTION DE RECURSO*******/
	import java.sql.*;

import javax.swing.table.DefaultTableModel;

import logica.roles.Recurso;
import conexion.*;


	public class Seguridad_Recursos {
		public DefaultTableModel datos;
		public String[] columnNames = {"Código", "Nombre", "Descripción","Ruta","Estado","Modulo"};
		public Conexion c = Conexion.getConn();
		//método que retorna el número de filas
		public int Count(){return datos.getRowCount();}

		//Constructor
	       public Seguridad_Recursos(){
			datos=new DefaultTableModel();
			//asignar etiquetas de columna al modelo de tabla
			for(int i=0;i<columnNames.length;i++)
				datos.addColumn(columnNames[i]);
		}

	       //Métodos que retornan valores de una celda según campos individuales
		public String get_codigo(int pos){
			return datos.getValueAt(pos, 0).toString();
		}

		public String get_nombre(int pos){
			return datos.getValueAt(pos, 1).toString();
		}
	
		public String get_descripcion(int pos){
			return datos.getValueAt(pos, 2).toString();
		}
		
		public String get_Ruta(int pos){
			return datos.getValueAt(pos, 3).toString();
		}
		
		public String get_Estado(int pos){
			if((boolean)datos.getValueAt(pos, 4)==true)
			return "Activo";
			else
			return "No Activo";	
		}
		
		public String get_Modulo(int pos){
			return datos.getValueAt(pos, 5).toString();
		}
		
		

	       //agrega la nueva fila
		public void addFila(Recurso ob){
			Object[] row={new Long(ob.rec_codigo),new String(ob.rec_nombre),new String(ob.rec_descripcion),new String(ob.rec_ruta),new Boolean(ob.rec_estado),new Long(ob.mod_codigo)};
			datos.addRow(row);
		}

		//limpia todos los datos del Modelo de tabla
		public void reset()
		{
			while(Count()>0)
				datos.removeRow(Count()-1);
		}

		//Retorna el modelo de tabla
		public DefaultTableModel getTablaDatos()
		{
		    return datos;
		}

		/********Métodos de acceso a la base de datos*/

		//rellena el modelo de table según los resultados obtenidos de la BD
	       public void rellenar(ResultSet rs)
		{
			try{
				Recurso ob=new Recurso();
				//reset();  //limpia la lista de productos
				while (rs.next()) {
					ob.rec_codigo=Integer.parseInt(rs.getObject("rec_codigo").toString());
					ob.rec_nombre=rs.getObject("rec_nombre").toString();
					ob.rec_descripcion=rs.getObject("rec_descripcion").toString();
					ob.rec_ruta=rs.getObject("rec_ruta").toString();
					ob.rec_estado=rs.getBoolean("rec_estado");
					ob.mod_codigo=Integer.parseInt(rs.getObject("mod_codigo").toString());		
					addFila(ob);
					System.out.println(ob.rec_nombre);
				}
				
			}
			catch(Exception ex){System.out.println("aqui"); }
		}

		//consulta todos los elementos de la tabla productos
		public void consultaAll()
		{
			String str="select * from \"Recurso\"";

			ResultSet rs = null;
			try{
				rs=c.consulta(str);
				rellenar(rs);
				rs.close();
			}
			catch(Exception ex){}
		}

		//consulta los elementos segun la descripción
		public void consulta_nombre(String Nombre)
		{
			String str="select * from \"Recurso\" where rec_codigo="+Nombre;
			ResultSet rs = null;
			try{
				rs=c.consulta(str);
				rellenar(rs);
				rs.close();
			}
			catch(Exception ex){}
		}

		//inserta un registro en la base de datos
		public boolean insertar(Recurso ob)
		{
			String str="insert into \"Recurso\" values(";
			str+="'" + ob.rec_codigo +"'";
			str+="'" + ob.rec_nombre +"'";
			str+="'" + ob.rec_descripcion +"'";
			str+="'" + ob.rec_ruta +"'";
			str+="'" + ob.rec_estado +"'";
			str+="'" + ob.mod_codigo +"'";
			str+=")";
			boolean estado=false;
			try{
				c.sentencia(str);
				estado=true;
			}
			catch(Exception ex){estado=false;}
			return estado;
		}

	}