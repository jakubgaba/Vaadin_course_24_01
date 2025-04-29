package com.vaadin.training.forms.exercises.ex2;

import java.util.function.Consumer;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProductEditor extends Composite<VerticalLayout> implements HasSize {

    private final TextField nameField = new TextField("Name");
    private final TextField priceField = new TextField("Price");
    private final DatePicker validationField = new DatePicker("Validation");

    private final Binder<Product> binder = new Binder<>(Product.class); //Bind with DAO 

    public ProductEditor(Product product, Consumer<Product> productConsumer) {
        VerticalLayout layout = getContent();

        layout.add(nameField, priceField, validationField); //Adding into simple Layout


        //Binding is happening !
        binder.bind(nameField, Product::getName, Product::setName);
        binder.forField(priceField)
            .withConverter(Double::valueOf, String::valueOf, "Must be a number") // Checking that it will gonna be number and then its converts it into String
            .bind(Product::getPrice, Product::setPrice);
        binder.bind(validationField, Product::getAvailable, Product::setAvailable);

        Button save = new Button("Save", event -> {
            if (binder.writeBeanIfValid(product)) {
                productConsumer.accept(product);
            }
        });

        Button cancel = new Button("Cancel", event -> {
            binder.readBean(product); 
        });
        layout.add(save, cancel);
    }
}
