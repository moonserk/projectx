module com.projectx.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    requires unirest.java;

    //needed for JSON
    requires com.google.gson;

    requires java.sql;

    opens com.projectx.client to javafx.fxml;
    exports com.projectx.client;
    exports com.projectx.client.models;
    opens com.projectx.client.models to javafx.fxml;
    exports com.projectx.client.controllers;
    opens com.projectx.client.controllers to javafx.fxml;
    exports com.projectx.client.helpers;
    opens com.projectx.client.helpers to javafx.fxml;
}