package unitec.org.elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //esto es una notación (se pueden poner antes de una clase, un atributo o un método) Gracias a esto, se convierte en una aplicación springboot
public class ElementosApplication implements CommandLineRunner{
    
    @Autowired RepositorioMensajitos repomensa;

	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        
        //Probando a guardar en la base de datos
        //Mensajitos m=new Mensajitos("Primero", "mensajito con hibernate");
        //repomensa.save(m);
        
        //Probamos el de buscar
        //ArrayList<Mensajitos> mensajitos =(ArrayList<Mensajitos>) repomensa.findAll(); //casting necesario
        //for(Mensajitos m: mensajitos){
           // System.out.println(m.getTitulo());
        }
        
        //Probamos buscar por ID
        //Mensajitos m1= repomensa.findOne(1);
        //System.out.println(m1.getTitulo());
        
        //Actualización
        //repomensa.save(new Mensajitos(1, "Otro", "Malo"));
        
        //Borrar
        //repomensa.delete(1);
        
    }
//}
//aquí solo se deberá hacer una vez "Run file", ya que si se hace, el puerto asignado por esta aplicación lo considerará ocupado por la PC
//Para visualizar los cambios solo se debe de guardar (con los disquitos)