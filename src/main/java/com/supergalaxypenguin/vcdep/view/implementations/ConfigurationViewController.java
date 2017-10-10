package com.supergalaxypenguin.vcdep.view.implementations;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ConfigurationViewController implements Initializable {
    
    private String gitTxt;
    private String branchTxt;
    private String jenkinsTxt;
    
    @FXML
    private ChoiceBox<String> lang;
    @FXML
    private Label label;
    @FXML
    private Label testLabel;
    @FXML
    private TextField gitUrl;
    @FXML
    private TextField branch;
    @FXML
    private TextField jenkins;
    @FXML
    private Button submit;
    @FXML
    private Button browse;
    @FXML
    private ImageView penguin;
    @FXML
    private ImageView background;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        testLabel.setText(gitUrl.getText()+"\n"+branch.getText()+"\n"+jenkins.getText());
        // this area will change
        gitTxt = gitUrl.getText();
        branchTxt = branch.getText();
        jenkinsTxt = jenkins.getText();
        
        System.out.println(gitTxt+"\n"+branchTxt+"\n"+jenkinsTxt);
        
    }
    @FXML
    private void handleBrowseButton(ActionEvent event) {
        System.out.println("Opening File Directory");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     lang.getItems().add("PHP");
     lang.getItems().add("Java");
     lang.setValue("Java");
    //this is initialization//   

// TODO
    }    
}