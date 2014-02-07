/**
 * 
 */
package logica.seguridad;

/**
 * @author Dell Inspiron
 * @version 1.0
 */
public class Seguridad_Permisos {
	protected int per_permiso;
	protected boolean per_estado;
	protected int rol_codigo;
	protected int rec_codigo;

	public Seguridad_Permisos() {
		this.per_permiso = 0;
		this.per_estado = true;
		this.rol_codigo = 0;
		this.rec_codigo = 0;
	
	}
	public Seguridad_Permisos(int per_permiso, boolean per_estado, int rol_codigo,
			int rec_codigo) {
		super();
		this.per_permiso = per_permiso;
		this.per_estado = per_estado;
		this.rol_codigo = rol_codigo;
		this.rec_codigo = rec_codigo;
	}

	public int getPer_permiso() {
		return per_permiso;
	}

	public void setPer_permiso(int per_permiso) {
		this.per_permiso = per_permiso;
	}

	public boolean isPer_estado() {
		return per_estado;
	}

	public void setPer_estado(boolean per_estado) {
		this.per_estado = per_estado;
	}

	public int getRol_codigo() {
		return rol_codigo;
	}

	public void setRol_codigo(int rol_codigo) {
		this.rol_codigo = rol_codigo;
	}

	public int getRec_codigo() {
		return rec_codigo;
	}

	public void setRec_codigo(int rec_codigo) {
		this.rec_codigo = rec_codigo;
	}

}
