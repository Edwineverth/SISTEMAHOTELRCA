/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

public class ModeloNodoArbol {
        private String nod_codigo;
        private String nod_name;
        private String nod_flagIcon;
        private String nod_rutaRecurso;      
       
        
        public ModeloNodoArbol() {
            nod_name = "";
            nod_name = "";
            nod_rutaRecurso = "";
        }
        
    public ModeloNodoArbol(String key, String value) {
        this.nod_codigo=key;
        this.nod_name = value;
    }

    
    public ModeloNodoArbol(String nod_codigo, String nod_name, String nod_flagIcon, String nod_rutaRecurso) {
            this.nod_codigo = nod_codigo;
            this.nod_name = nod_name;
            this.nod_flagIcon = nod_flagIcon;
            this.nod_rutaRecurso = nod_rutaRecurso;
        }
 
     public ModeloNodoArbol( String nod_name, String nod_flagIcon, String nod_rutaRecurso) {
            this.nod_name = nod_name;
            this.nod_flagIcon = nod_flagIcon;
            this.nod_rutaRecurso = nod_rutaRecurso;
        }
 
        
     
        public String getName() {
            return nod_name;
        }
 
        public void setName(String name) {
            this.nod_name = name;
        }
 
        public String getFlagIcon() {
            return nod_flagIcon;
        }
 
        public void setFlagIcon(String flagIcon) {
            this.nod_flagIcon = flagIcon;
        }

        public String getNod_rutaRecurso() {
            return nod_rutaRecurso;
        }

        public void setNod_rutaRecurso(String nod_rutaRecurso) {
            this.nod_rutaRecurso = nod_rutaRecurso;
        }
        
    public String getNod_flagIcon() {
        return nod_flagIcon;
    }

    public void setNod_flagIcon(String nod_flagIcon) {
        this.nod_flagIcon = nod_flagIcon;
    }

    public String getNod_name() {
        return nod_name;
    }

    public void setNod_name(String nod_name) {
        this.nod_name = nod_name;
    }

    public String getNod_codigo() {
        return nod_codigo;
    }

    public void setNod_codigo(String nod_codigo) {
        this.nod_codigo = nod_codigo;
    }

}
