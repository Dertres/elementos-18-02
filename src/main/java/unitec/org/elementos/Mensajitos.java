
package unitec.org.elementos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //Importar javax.persistence.Entity;
//Todas las entidades se mapearán con JPA

public class Mensajitos {//Marca error aquí porque no se ha indicado la primary key
    
    @Id//Importar javax.persistence.Id; Con esto se quita el error anterior (error en "Mensajitos"). Esto solo se hace para la Id
    //@Column(name="id") //Este es opcional, esto se hace en caso de que el nombre del id establecido aquí sea diferente a como está en la base de datos
    @GeneratedValue//Esto solo para las Id autogeneradas (autoincremental)
    private Integer id;
    private String titulo;
    private String cuerpo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Mensajitos() {
    }

    public Mensajitos(Integer id) {
        this.id = id;
    }

    public Mensajitos(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    
        
}
