package com.greyog.transaqclientspring3.view.main;


import com.greyog.transaqclientspring3.entity.message.FortsPosition;
import com.greyog.transaqclientspring3.service.DataService;
import com.greyog.transaqclientspring3.service.MessageProcessorService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "")
@PageTitle("Contacts | Vaadin CRM")
public class MainView extends VerticalLayout {

    Grid<FortsPosition> grid = new Grid<>(FortsPosition.class);
    TextField filterText = new TextField();
    TextField statusText = new TextField();
    Icon serverStateIcon = new Icon();
    private final DataService dataService;
    long updateRate = -1L;
    private final MessageProcessorService messageProcessorService;

    public MainView(DataService dataService, MessageProcessorService messageProcessorService) { // (1)
        this.dataService = dataService;
        this.messageProcessorService = messageProcessorService;

        addClassName("list-view");
        setSizeFull();
        configureGrid();
//        configureForm();

        add(getToolbar(), getContent());
//        updateList(); // (2)
//        add(mainLayout);
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setFlexGrow(2, grid);
//        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        messageProcessorService.addListener(this::showNotification);
    }
//    private void configureForm() {
//        form = new ContactForm(dataService.findAllCompanies(), dataService.findAllStatuses()); // (3)
//        form.setWidth("25em");
//    }

    private void configureGrid() {
        grid.addClassNames("position-grid");
        grid.setSizeFull();
//        FortsPosition.class.
//        grid.setColumns("secid", "seccode", "startnet");
//        grid.addColumn(fortsPosition -> fortsPosition.secid).setHeader("Id");
//        grid.addColumn(fortsPosition -> fortsPosition.getSecCode()).setHeader("code");
//        grid.addColumn(fortsPosition -> fortsPosition.startnet).setHeader("net");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        serverStateIcon = VaadinIcon.AT.create();
        filterText.setPlaceholder("...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList()); // (4)

        Button reloadButton = new Button("Reload");
        reloadButton.addClickListener(event -> updateList());

        Button notifButton = new Button("Notif Test");
        notifButton.addClickListener(event -> showNotification("local"));

        statusText.setValue("initial");

        var toolbar = new HorizontalLayout(serverStateIcon, filterText, reloadButton, statusText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() { // (5)
        if (dataService.getAllFortsPositions().isEmpty()) {
            serverStateIcon.setColor("red");
        } else {
            serverStateIcon.setColor("green");
        }
        grid.setItems(dataService.getAllFortsPositions());
    }

    private void showNotification(String message) {
        getUI().ifPresent(ui -> ui.access(() -> {
            statusText.setValue(message);

            var n = Notification.show(message, 2000, Notification.Position.BOTTOM_START);

        }));
    }

}
