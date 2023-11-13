package com.greyog.transaqclientspring3.view.main;


import com.greyog.transaqclientspring3.component.Server;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    @Autowired
    private Server server;

    public MainView() {
        var data = new TextField("Your name");
        var button = new Button("Refresh");
        button.addClickListener(e -> {
            data.setValue(server.getPositions().toString());
        });
        button.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, data, button);

        add(data, button);

    }

}
