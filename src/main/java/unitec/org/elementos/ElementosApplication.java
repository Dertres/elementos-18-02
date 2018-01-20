package unitec.org.elementos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //esto es una notación (se pueden poner antes de una clase, un atributo o un método) Gracias a esto, se convierte en una aplicación springboot
public class ElementosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}
}
//aquí solo se deberá hacer una vez "Run file", ya que si se hace, el puerto asignado por esta aplicación lo considerará ocupado por la PC
//Para visualizar los cambios solo se debe de guardar (con los disquitos)