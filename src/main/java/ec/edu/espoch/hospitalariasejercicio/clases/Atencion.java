
package ec.edu.espoch.hospitalariasejercicio.clases;

import ec.edu.espoch.hospitalariasejercicio.clases.Metodo;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.EstadoAtencion;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.CategoriaPrioridad;
  
public class Atencion {
    //Atributos
    public int identificadorAtencion;
    public EstadoAtencion estadoAtencion;
    public Metodo[] metodo=new Metodo[2];
    public CategoriaPrioridad prioridad;
    public String observacion;
    public String indicacion;
    public String medicacion;
    public String[] insumos= new String[2];
    public String motivoCancelacion;
    public double total;
    
    //Costructores
    public Atencion(int identificadorAtencion, EstadoAtencion estadoAtencion) {
        this.identificadorAtencion = identificadorAtencion;
        this.estadoAtencion = estadoAtencion;
    }
    
    //Metodos
    public boolean asignarPrioridad(CategoriaPrioridad prioridad){
        boolean respuesta=false;
        if(this.estadoAtencion==EstadoAtencion.EN_TRIAJE){
            this.prioridad=prioridad;
            respuesta=true;
        }
        return respuesta;
    }
    
     public String agregarIndicacion(String indicacion){
        return this.indicacion=indicacion;
    }
    
    public String añadirObservacion(String observacion){ 
        return this.observacion=observacion;
    }
    
    public boolean cambiarEstado(EstadoAtencion nuevoEstado){
        boolean respuesta=false;
        if(nuevoEstado==EstadoAtencion.ALTA_EMITIDA){
           if(this.estadoAtencion==EstadoAtencion.LISTA_PARA_ALTA){
               this.estadoAtencion=nuevoEstado;
               respuesta=true;
           }
        } else{
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        }
        return respuesta;
    }
    
    public boolean agregarMetodo(Metodo metodo){
        boolean respuesta=false;
        for(int i=0;i<metodo.length;i++){
  
            if (this.metodo[i]==null){ 
                this.metodo[i]=metodo;
                respuesta=true;
                break;
            }
        }
        return respuesta;
    }
    
    public boolean quitarMetodo(Metodo elimMetodo){
        // verifiar que existan espacios en el vector
        boolean respuesta=false;
        for(int i=0;i<metodo.length;i++){
            //SI hay espacion añadir el item y retornar true
            //si no hay retornar false
            if (metodo[i]==elimMetodo){
                metodo[i]=null;
                respuesta=true;
            }
        }
        return respuesta;
    }
    
    public boolean agregarInsumo(String insumo){
        boolean respuesta=false;
        for(int i=0;i<insumos.length;i++){
            if (insumos[i]==null){
                this.insumos[i]=insumo;
                respuesta=true;
            }
        }
        return respuesta;
    }
    
    public boolean quitarInsumo(String elimInsumo){
        boolean respuesta=false;
        for(int i=0;i<insumos.length;i++){
            if(insumos[i]!=elimInsumo){
            } else {
                this.insumos[i]=null;
                respuesta=true;
            }
        }
        return respuesta;
    }
    
    public String ordenarMedicacion(String dosis){
        return this.medicacion=dosis;
    }
    
    public boolean cambiarMedicacion(String dosisNueva, EstadoAtencion estadoActual){
        boolean respuesta=false;
        if(estadoActual!=EstadoAtencion.EN_ATENCION){
            this.medicacion=dosisNueva;
            respuesta=true;
        }else{
            System.out.println("No se puede cambiar la dosis en estado 'En Atencion'");
        }
        return respuesta;
    }
    
    public boolean cancelarAtencion(String motivo){
        boolean respuesta=false;
        if(this.estadoAtencion==EstadoAtencion.REGISTRADA || this.estadoAtencion==EstadoAtencion.EN_TRIAJE){
            this.motivoCancelacion=motivo;
            respuesta=true;
        }
        return respuesta;
    }
    
    public double calcCovertura(double cobertura){
        double descuento=0;
        total=calcTotal();
        descuento=total*cobertura;
        return this.total=total-descuento;
    }
    
    public double calcTotal(){
        double total=0;
        for(int i=0;i<metodo.length;i++){
            total=total+this.metodo[i].costo;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Atencion{" + "identificarAtencion=" + identificadorAtencion + ", estadoAtencion=" + estadoAtencion + ", metodo=" + metodo[0].categoriaMetodo + ", prioridad=" + prioridad + ", observacion=" + observacion + ", indicacion=" + indicacion + ", medicacion=" + medicacion + ", insumos=" + insumos[0] + ", motivoCancelacion=" + motivoCancelacion + ", total=" + total + '}';
    }
}