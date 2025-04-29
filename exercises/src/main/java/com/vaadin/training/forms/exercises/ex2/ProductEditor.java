package com.vaadin.training.forms.exercises.ex2;

import java.util.function.Consumer;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProductEditor extends Composite<VerticalLayout> implements HasSize {

    private final TextField nameField = new TextField("Name");
    private final TextField priceField = new TextField("Price");
    private final TextField ValidationField = new TextField("Validation");

    private final Binder<Product> binder = new Binder<>(Product.class);

    public ProductEditor(Product product, Consumer<Product> productConsumer) {
        VerticalLayout layout = getContent();

        layout.add(nameField, priceField, ValidationField);

        // Binds Product fields to UI fields
        binder.bind(nameField, Product::getName, Product::setName);
        binder.forField(priceField)
            .withConverter(Double::valueOf, String::valueOf, "Must be a number")
            .bind(Product::getPrice, Product::setPrice);
        

        binder.readBean(product);

        Button save = new Button("Save", event -> {
            if (binder.writeBeanIfValid(product)) {
                productConsumer.accept(product); // Callback on success
            }
        });

        Button cancel = new Button("Cancel", event -> {
            binder.readBean(product); // Reset form
        });

        layout.add(save, cancel);
    }
}
