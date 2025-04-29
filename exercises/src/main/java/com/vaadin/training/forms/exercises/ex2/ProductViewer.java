package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;

public class ProductViewer extends Composite<FormLayout> implements HasSize{

    Paragraph paragraphName = new Paragraph();
    Paragraph paragraphPrice = new Paragraph();
    Paragraph paragraphAvailable = new Paragraph();


    public ProductViewer(Product product) {
        final FormLayout layout = getContent();
        layout.add(paragraphName,paragraphPrice,paragraphAvailable);

    }

    void refresh(Product product){
        paragraphName.setText(product.getName());
        paragraphPrice.setText(String.valueOf(product.getPrice()));
        paragraphAvailable.setText(String.valueOf(product.getAvailable()));
    }
}
