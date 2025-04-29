package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ProductLayoutForm extends FormLayout{
    public TextField name = new TextField("Name");
    public TextField price = new TextField("Price");
    public DatePicker available = new DatePicker("Available");
    public ProductLayoutForm( ) {
    }
    public TextField getName() {
        return name;
    }
    public TextField getPrice() {
        return price;
    }
    public DatePicker getAvailable() {
        return available;
    }
    
}
