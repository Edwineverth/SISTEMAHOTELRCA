package logica.seguridad;
/**********CLASE DE GESTION DE ROLES*******/
import java.sql.*;

import javax.swing.table.DefaultTableModel;

import logica.roles.Rol;
import conexion.*;

public class Seguridad_Roles {
	public DefaultTableModel datos;
	public String[] columnNames = {"Código", "Nombre", "Descripción"};
	public Conexion c = Conexion.getConn();
	//método que retorna el número de filas
	public int Count(){return datos.getRowCount();}

	//Constructor
       public Seguridad_Roles(){
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

       //agrega la nueva fila
	public void addFila(Rol ob){
		Object[] row={new Long(ob.rol_codigo),new String(ob.rol_nombre),new String(ob.rol_descripcion)};
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
			Rol ob=new Rol();
			reset();  //limpia la lista de productos
			while (rs.next()) {
				ob.rol_codigo=Integer.parseInt(rs.getObject("rol_codigo").toString());
				ob.rol_nombre=rs.getObject("rol_nombre").toString();
				ob.rol_descripcion=rs.getObject("rol_descripcion").toString();
				addFila(ob);

				System.out.println(ob.rol_nombre);
			}
			
		}
		catch(Exception ex){}
	}

	//consulta todos los elementos de la tabla productos
	public void consultaAll()
	{
		String str="select * from \"Rol\"";

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
		String str="select * from \"Rol\" where rol_codigo="+Nombre;
		ResultSet rs = null;
		try{
			rs=c.consulta(str);
			rellenar(rs);
			rs.close();
		}
		catch(Exception ex){}
	}

	//inserta un registro en la base de datos
	public boolean insertar(Rol ob)
	{
		String str="insert into \"Rol\"(rol_codigo,rol_nombre,rol_descripcion)values(";
		str+="'" + ob.rol_codigo +"'";
		str+="'" + ob.rol_nombre +"'";
		str+="'" + ob.rol_descripcion +"'";
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