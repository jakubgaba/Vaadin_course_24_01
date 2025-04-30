package com.vaadin.training.forms.exercises.ex2;

import java.time.LocalDate;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;

public class ProductViewer extends Composite<FormLayout> implements HasComponents,HasSize{

    Paragraph paraTextField = new Paragraph();
    Paragraph paragraphPrice = new Paragraph();
    Paragraph paragraphAvailable = new Paragraph();
    Binder<Product> binder = new Binder<>(Product.class);

    public ProductViewer(Product product) {
        final FormLayout layout = getContent();
        
        layout.addFormItem(paraTextField, "Name");
        layout.addFormItem(paragraphPrice, "Price");
        layout.addFormItem(paragraphAvailable, "Date");

        
        
        binder.forField(new ReadOnlyHasValue<>(paraTextField::setText)).bind(Product::getName, null);
        binder.forField(new ReadOnlyHasValue<Double>(price -> paragraphPrice.setText(String.valueOf(price)))).bind(Product::getPrice, null);
        binder.forField(new ReadOnlyHasValue<LocalDate>(available -> paragraphAvailable.setText(String.valueOf(available)))).bind(Product::getAvailable, null);
      
        refresh(product);
        
    }

    void refresh(Product product){
       binder.readBean(product);
    }
}
