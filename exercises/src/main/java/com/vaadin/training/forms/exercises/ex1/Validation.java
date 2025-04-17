package com.vaadin.training.forms.exercises.ex1;

import java.io.Serial;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.forms.exercises.MainLayout;

@Route(value = Validation.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class Validation extends VerticalLayout implements HasSize {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex1";
    public static final String TITLE = "Validation";

    public Validation() {
        // TODO Create a bean class to contain the data with fields, getters and
        // setters for each value needed to bind the three TextFields.
        Binder binder = new Binder<>(containerClassHolder.class);

        // TODO Create a Binder typed for the bean class you just created
        // TODO Bind field and add validation to check that the input is a
        // proper mail address.

        final TextField emailField = new TextField("Email validator");
        binder.forField(emailField).withValidator(new EmailValidator("Looks sus"))
                .bind(containerClassHolder.getEmailField, containerClassHolder::setEmailField);
				
        // TODO Bind field and add validation which accepts strings between 1
        // and 10 in length
        final TextField stringField = new TextField("String length validator");

        // TODO Bind field and add a custom Validator which only accepts
        // "Vaadin"
        final TextField vaadinField = new TextField("Vaadin validator");

        add(emailField, stringField, vaadinField);

    }

}

class containerClassHolder {

    private String emailField;
    private String stringField;
    private String vaadinField;

    containerClassHolder() {
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getVaadinField() {
        return vaadinField;
    }

    public void setVaadinField(String vaadinField) {
        this.vaadinField = vaadinField;
    }

}
