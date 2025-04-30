package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;


public class ProductLayoutForm extends FormLayout{

    
    public TextField Name = new TextField("Name");
    public TextField Price = new TextField("Price");
    public DatePicker Available = new DatePicker("Available");


    public ProductLayoutForm() {
        add(Name,Price,Available);
    }

    public TextField getName() {
        return Name;
    }

    public TextField getPrice() {
        return Price;
    }

    public DatePicker getAvailable() {
        return Available;
    }
    
    
}
