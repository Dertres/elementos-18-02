package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI   //convierte en página index a la clase MiUI
@Theme("valo")  //Le asigna el tema a la index

public class MiUI extends UI{

    @Override
    protected void init(VaadinRequest request) {
        
        //Agregaremos un layout vertical, y dentro de él las componentes que quedarán en orden descendente
        VerticalLayout layout = new VerticalLayout();
        Label e1= new Label("Mi nombre");
        Button b1 = new Button("Login");
        b1.addStyleName(ValoTheme.BUTTON_DANGER);
        e1.addStyleName(ValoTheme.LABEL_H1);
        //Vamos a  programar el evento del botón, usando programación funcional
        b1.addClickListener(algo->{
            
            //Aquí ponemos el evento
            e1.setValue("Mi primer programación funcional");
            
        
        });
                
        
        //Agregamos las componentes al layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        
        //Esto solo se hace una vez (agregar el layout a la index)
        setContent(layout);
    }
    
}
