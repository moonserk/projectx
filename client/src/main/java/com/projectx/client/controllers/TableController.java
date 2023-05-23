package com.projectx.client.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.projectx.client.helpers.AbstractConvertCellFactory;
import com.projectx.client.Contract;
import com.projectx.client.services.ContractService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Collectors;

public class TableController {
    private final ObservableList<Contract> tableData = FXCollections.observableArrayList();

    @FXML
    public Button button;
    @FXML
    private TableView<Contract> tableContracts;

    @FXML
    private TableColumn<Contract, String> numberColumn;

    @FXML
    private TableColumn<Contract, Date> dateCreationColumn;

    @FXML
    private TableColumn<Contract, Date> lastUpdateColumn;
    @FXML
    private CheckBox checkBox;

    @FXML
    private Label label;
    
    @FXML
    private void initialize() {
        initData();

        numberColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("number"));

        dateCreationColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        dateCreationColumn.setCellFactory((AbstractConvertCellFactory<Contract, Date>) value -> new SimpleDateFormat("dd-MM-yyyy").format(value));

        lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        lastUpdateColumn.setCellFactory((AbstractConvertCellFactory<Contract, Date>) value -> new SimpleDateFormat("dd-MM-yyyy").format(value));

        tableContracts.setItems(tableData);
    }

    private void initData() {
        tableData.addAll(ContractService.getAll());
        label.setVisible(tableData.isEmpty());
    }

    public void onButtonRefreshClick(ActionEvent event)  {
        tableData.clear();
        this.initialize();
    }

    public void change(ActionEvent event){
        if(checkBox.isSelected()) {
            ObservableList<Contract> td = FXCollections.observableArrayList();
            td.addAll(tableData.stream().filter(f -> {
                Date currentDate = new Date();
                Date oneDayFromCurrentDate = new Date(currentDate.getTime() - Duration.ofDays(60).toMillis());
                return f.getDateCreation() != null && f.getDateCreation().compareTo(oneDayFromCurrentDate) == 1;
            }).collect(Collectors.toList()));
            tableContracts.setItems(td);
        } else {
            tableContracts.setItems(tableData);
        }

        tableContracts.refresh();
    }
}
