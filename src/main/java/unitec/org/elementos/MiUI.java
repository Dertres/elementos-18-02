package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringUI   //convierte en página index a la clase MiUI
@Theme("valo")  //Le asigna el tema a la index

public class MiUI extends UI{
    
    String n1;
    String n2;
    Integer id;
    
@Autowired RepositorioMensajitos repositorioMensajitos;
    @Override
    protected void init(VaadinRequest request) {
        
        //Agregaremos un layout vertical, y dentro de él las componentes que quedarán en orden descendente
        VerticalLayout layout = new VerticalLayout();
        Label e1= new Label("Mi nombre");
        Button b1 = new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_DANGER);
        e1.addStyleName(ValoTheme.LABEL_H1);
        //Vamos a  programar el evento del botón, usando programación funcional
        b1.addClickListener(algo->{
            
            //Aquí ponemos el evento
            // e1.setValue("Mi primer programación funcional");
            n1="";
            n2="";
            MiVentanaGuardar sub=new MiVentanaGuardar();
            UI.getCurrent().addWindow(sub);
            
        });
        
        
        //Agregamos las componentes al layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        
        List<Mensajitos> men=(List<Mensajitos>) repositorioMensajitos.findAll();
        
        Grid<Mensajitos> grid = new Grid<>();
        grid.setItems(men);
        grid.addColumn(Mensajitos::getId).setCaption("ID");
        grid.addColumn(Mensajitos::getTitulo).setCaption("Título");
        grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo");
        
        //grid.setSelectionMode(SelectionMode.MULTI);
        grid.setSelectionMode(SelectionMode.SINGLE);
        
        //grid.addItemClickListener(event ->)
        
        
        grid.addItemClickListener(evento -> {
        
        Notification.show("Valor: "+evento.getItem().getTitulo());
        n1=evento.getItem().getTitulo();//n1.setValue(evento.getItem().getTitulo());
        n2=evento.getItem().getCuerpo();//n2.setValue(evento.getItem().getCuerpo());
        id=evento.getItem().getId();
        MiVentana sub=new MiVentana();
        UI.getCurrent().addWindow(sub);
        
        });
        
        
        layout.addComponent(grid);
        
        
        
        
//        grid.addSelectionListener(event -> {
//        Set<Mensajitos> selected = event.getAllSelectedItems();
//        Notification.show(selected.size() + " filas seleccionadas");
//        });
//        layout.addComponent(grid);
//        
//        // Content for the PopupView
//        VerticalLayout popupContent = new VerticalLayout();
//        popupContent.addComponent(new TextField("Textfield"));
//        popupContent.addComponent(new Button("Button"));
//
//        // The component itself
//        PopupView popup = new PopupView("Pop it up", popupContent);
//        layout.addComponent(popup);
//        





        
        //Esto solo se hace una vez (agregar el layout a la index)
        setContent(layout);
    }
    
    
    //class MiVentana extends Window{public MiVentana(){}}
    class MiVentana extends Window {

    public MiVentana() {
        super("Actualizar o borrar");
        center();
        VerticalLayout vl2 = new VerticalLayout();
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        t1.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
        t2.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
        
        Button boton = new Button("Actualizar");
        Button boton2 = new Button("Borrar");
        boton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        boton2.addStyleName(ValoTheme.BUTTON_DANGER);
        boton2.addClickListener(evento->{
            
            repositorioMensajitos.delete(id);
        
        
        
        });
        boton.addClickListener(evento -> {
            
            //repomensa.save(new Mensajitos(1, "Otro", "Malo"));
            repositorioMensajitos.save(new Mensajitos(id, t1.getValue(), t2.getValue()));
            
            //Hace la función del F5 en el navegador
            Page.getCurrent().reload();
            //close();
        });
        vl2.addComponent(t1);
        t1.setValue(n1);
        t1.setCaption("Título:");
        vl2.addComponent(t2);
        t2.setValue(n2);
        t2.setCaption("Cuerpo:");
        HorizontalLayout hl = new HorizontalLayout();
        
        hl.addComponent(boton);
        hl.addComponent(boton2);
        vl2.addComponent(hl);

        setContent(vl2);
    }
    }
    
    class MiVentanaGuardar extends Window {

    public MiVentanaGuardar() {
        super("Guardar");
        center();
        VerticalLayout vl2 = new VerticalLayout();

        TextField t1 = new TextField();
        TextField t2 = new TextField();
        
        

        Button boton = new Button("Guardar");
        boton.addClickListener(evento -> {
            
            //repomensa.save(new Mensajitos(1, "Otro", "Malo"));
            repositorioMensajitos.save(new Mensajitos(t1.getValue(), t2.getValue()));
            
            //Hace la función del F5 en el navegador
            Page.getCurrent().reload();
            //close();
        });
        vl2.addComponent(t1);
        t1.setValue(n1);
        t1.setCaption("Título:");
        vl2.addComponent(t2);
        t2.setValue(n2);
        t2.setCaption("Cuerpo:");
        vl2.addComponent(boton);

        setContent(vl2);
    }
    }
    
    
    
}