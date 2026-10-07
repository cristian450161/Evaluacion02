package entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
 
public class Plato {

    private int idplato;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private int stock;
    private LocalDate fechaRegistro;
    private String estado;
    private TipoPlato tipoPlato;
    
    public void setTipoDirector(entity.TipoPlato objTipoPlato) {
		// TODO Auto-generated method stub
		
		
	}

}
