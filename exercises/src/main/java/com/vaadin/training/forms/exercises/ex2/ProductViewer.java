package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProductViewer extends Composite<FormLayout> implements HasSize{

    TextField paraTextField = new TextField();
    TextField paragraphPrice = new TextField();
    DatePicker paragraphAvailable = new DatePicker();
    Binder<Product> binder = new Binder<>(Product.class);

    public ProductViewer(Product product) {
        final FormLayout layout = getContent();
        
        layout.addFormItem(paraTextField, "Name");
        layout.addFormItem(paragraphPrice, "Price");
        layout.addFormItem(paragraphAvailable, "Date");

        


        refresh(product);
    }

    void refresh(Product product){
       binder.readBean(product);
    }
}
