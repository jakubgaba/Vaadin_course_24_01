package com.vaadin.training.forms.exercises.ex2;

import java.util.function.Consumer;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

public class ProductEditor extends Composite<VerticalLayout> implements HasComponents,HasSize {

    public ProductEditor(Product product, Consumer<Product> productConsumer) {
        final ProductLayoutForm productLayout = new ProductLayoutForm();
        final Binder<Product> productBinder = new Binder<>();

        productBinder.forField(productLayout.getAvailable()).bind(Product::getAvailable,Product::setAvailable);
        productBinder.forField(productLayout.getPrice()).withConverter(new CurrencyConverter()).bind(Product::getPrice, Product::setPrice);
        productBinder.forField(productLayout.getName()).bind(Product::getName, Product::setName);
    

        productBinder.readBean(product);

      HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.add(new Button("Save", saveVal -> {
        try {
            productBinder.writeBean(product);
            productConsumer.accept(product);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        }));

        add(productLayout,horizontalLayout);
    }
}
