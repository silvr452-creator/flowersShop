package com.example.flowersorder;

import java.io.Serializable;

public class Order implements Serializable {
    private String selectedFlower;
    private String checkboxSelection;
    private String radioSelection;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String customerDateDelivery;
    public Order() {

    }

    public Order(String selectedFlower, String checkboxSelection, String radioSelection, String customerName, String customerPhone,String customerAddress, String customerDateDelivery) {
        this.selectedFlower = selectedFlower;
        this.checkboxSelection = checkboxSelection;
        this.radioSelection = radioSelection;
    }

    public String getSelectedFlower() {
        return this.selectedFlower;
    }

    public void setSelectedFlower(String selectedFlower) {
        this.selectedFlower = selectedFlower;
    }

    public String getCheckboxSelection() {
        return checkboxSelection;
    }

    public void setCheckboxSelection(String checkboxSelection) {
        this.checkboxSelection = checkboxSelection;
    }

    public String getRadioSelection() {
        return radioSelection != null ? radioSelection : "Ничего не выбрано";
    }

    public void setRadioSelection(String radioSelection) {
        this.radioSelection = radioSelection;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerDateDelivery() {
        return customerDateDelivery;
    }

    public void setCustomerDateDelivery(String customerDateDelivery) {
        this.customerDateDelivery = customerDateDelivery;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "selectedFlower='" + selectedFlower + '\'' +
                ", checkboxSelection='" + checkboxSelection + '\'' +
                ", radioSelection='" + radioSelection + '\'' +
                '}';
    }
}