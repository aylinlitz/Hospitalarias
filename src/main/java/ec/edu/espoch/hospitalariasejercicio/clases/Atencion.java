
package ec.edu.espoch.hospitalariasejercicio.clases;

import ec.edu.espoch.hospitalariasejercicio.clases.Metodo;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.EstadoAtencion;
import ec.edu.espoch.hospitalariasejercicio.enumeracion.CategoriaPrioridad;
  
public class Atencion {

    // Atributos
    public int identificadorAtencion;
    public EstadoAtencion estadoAtencion;
    public Metodo[] metodo = new Metodo[2];
    public CategoriaPrioridad prioridad;
    public String observacion;
    public String indicacion;
    public String medicacion;
    public String[] insumos = new String[2];
    public String motivoCancelacion;
    public double total;

  
    public Atencion(int identificadorAtencion, EstadoAtencion estadoAtencion) {
        this.identificadorAtencion = identificadorAtencion;
        this.estadoAtencion = estadoAtencion;
    }

    public boolean asignarPrioridad(CategoriaPrioridad prioridad) {
        if (this.estadoAtencion == EstadoAtencion.EN_TRIAJE) {
            this.prioridad = prioridad;
            return true;
        }
        return false;
    }

    public String agregarIndicacion(String indicacion) {
        this.indicacion = indicacion;
        return this.indicacion;
    }

    public String añadirObservacion(String observacion) {
        this.observacion = observacion;
        return this.observacion;
    }

    public boolean cambiarEstado(EstadoAtencion nuevoEstado) {

        switch (nuevoEstado) {
            case REGISTRADA:
                if (estadoAtencion == EstadoAtencion.EN_TRIAJE || estadoAtencion == EstadoAtencion.REGISTRADA) {
                    estadoAtencion = nuevoEstado;
                    return true;
                }
                break;

            case EN_TRIAJE:
                if (estadoAtencion == EstadoAtencion.REGISTRADA) {
                    estadoAtencion = nuevoEstado;
                    return true;
                }
                break;

            case EN_ATENCION:
                if (estadoAtencion == EstadoAtencion.EN_TRIAJE) {
                    estadoAtencion = nuevoEstado;
                    return true;
                }
                break;

            case LISTA_PARA_ALTA:
                if (estadoAtencion == EstadoAtencion.EN_ATENCION) {
                    estadoAtencion = nuevoEstado;
                    return true;
                }
                break;

            case ALTA_EMITIDA:
                if (estadoAtencion == EstadoAtencion.LISTA_PARA_ALTA) {
                    estadoAtencion = nuevoEstado;
                    return true;
                }
                break;

            case CANCELADA:
                estadoAtencion = nuevoEstado;
                return true;
        }
        return false;
    }

    // AGREGAR METODO
    public boolean agregarMetodo(Metodo nuevoMetodo) {
        for (int i = 0; i < metodo.length; i++) {
            if (metodo[i] == null) {
                metodo[i] = nuevoMetodo;
                return true;
            }
        }
        return false;
    }

    public boolean quitarMetodo(Metodo elimMetodo) {
        for (int i = 0; i < metodo.length; i++) {
            if (metodo[i] == elimMetodo) {
                metodo[i] = null;
                return true;
            }
        }
        return false;
    }

    // AGREGAR INSUMO
    public boolean agregarInsumo(String insumo) {
        for (int i = 0; i < insumos.length; i++) {
            if (insumos[i] == null) {
                insumos[i] = insumo;
                return true;
            }
        }
        return false;
    }

    public boolean quitarInsumo(String elimInsumo) {
        for (int i = 0; i < insumos.length; i++) {
            if (elimInsumo.equals(insumos[i])) {
                insumos[i] = null;
                return true;
            }
        }
        return false;
    }

    public String ordenarMedicacion(String dosis) {
        medicacion = dosis;
        return medicacion;
    }

    public boolean cambiarMedicacion(String dosisNueva, EstadoAtencion estadoActual) {
        if (estadoActual != EstadoAtencion.EN_ATENCION) {
            medicacion = dosisNueva;
            return true;
        } else {
            System.out.println("No se puede cambiar la dosis en estado 'EN_ATENCION'");
            return false;
        }
    }

    public boolean cancelarAtencion(String motivo) {
        if (estadoAtencion == EstadoAtencion.REGISTRADA || estadoAtencion == EstadoAtencion.EN_TRIAJE) {
            motivoCancelacion = motivo;
            estadoAtencion = EstadoAtencion.CANCELADA;
            return true;
        }
        return false;
    }

    public double calcCovertura(double cobertura) {
        total = calcTotal();
        double descuento = total * cobertura;
        total = total - descuento;
        return total;
    }

    public double calcTotal() {
        double suma = 0;
        for (Metodo m : metodo) {
            if (m != null) suma += m.costo;
        }
        return suma;
    }

    @Override
    public String toString() {
        return "Atencion{" +
                "identificadorAtencion=" + identificadorAtencion +
                ", estadoAtencion=" + estadoAtencion +
                ", metodo=" + (metodo[0] != null ? metodo[0].categoriaMetodo : "N/A") +
                ", prioridad=" + prioridad +
                ", observacion='" + observacion + '\'' +
                ", indicacion='" + indicacion + '\'' +
                ", medicacion='" + medicacion + '\'' +
                ", insumos=" + (insumos[0] != null ? insumos[0] : "N/A") +
                ", motivoCancelacion='" + motivoCancelacion + '\'' +
                ", total=" + total +
                '}';
    }
}