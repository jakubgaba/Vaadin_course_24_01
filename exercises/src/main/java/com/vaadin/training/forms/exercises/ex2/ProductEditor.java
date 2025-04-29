package com.vaadin.training.forms.exercises.ex2;

import java.util.function.Consumer;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;

public class ProductEditor extends Composite<VerticalLayout> implements HasSize {

    public ProductEditor(Product product, Consumer<Product> productConsumer) {
        final ProductLayoutForm productLayout = new ProductLayoutForm();
        final Binder<Product> productBinder = new Binder<>();

        productBinder.forField(productLayout.getAvailable()).bind(Product::getAvailable,Product::setAvailable);
        productBinder.forField(productLayout.getPrice()).withConverter(new CurrencyConverter()).bind(Product::getPrice, Product::setPrice);

        
    }
}
