package com.projectx.client.models;

import com.projectx.client.Contract;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class ContractModel {
    private final SimpleStringProperty number;
    private final SimpleStringProperty dateCreation;
    private final SimpleStringProperty lastUpdate;

    public ContractModel(String number, String dateCreation, String lastUpdate) {
        this.number = new SimpleStringProperty(number);
        this.dateCreation = new SimpleStringProperty(dateCreation);
        this.lastUpdate = new SimpleStringProperty(lastUpdate);
    }

    public static ContractModel toModel(Contract contract){

        return new ContractModel(
                contract.getNumber() == null ? "" : contract.getNumber(),
                contract.getDateCreation() == null ? "" : contract.getDateCreation().toString(),
                contract.getLastUpdate() == null ? "" : contract.getLastUpdate().toString());
    }

    public static List<ContractModel> toModelList(List<Contract> contracts){
        List<ContractModel> contractModels = new ArrayList<>();
        contracts.forEach(c -> {
            contractModels.add(toModel(c));
        });
        return contractModels;
    }


    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getDateCreation() {
        return dateCreation.get();
    }

    public SimpleStringProperty dateCreationProperty() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation.set(dateCreation);
    }

    public String getLastUpdate() {
        return lastUpdate.get();
    }

    public SimpleStringProperty lastUpdateProperty() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate.set(lastUpdate);
    }
}
