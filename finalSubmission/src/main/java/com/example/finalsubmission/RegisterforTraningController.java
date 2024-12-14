package com.example.finalsubmission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterforTraningController {

    @FXML
    private TextField emailTextfield;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField userNameTextField;
    @FXML
    private TableColumn<Register,String> usernameColumn;
    @FXML
    private TableView<Register> tableView;
    @FXML
    private TableColumn<Register,String> emailcolumn;
    @FXML
    private TableColumn<Register,String> phoneNumberColumn;

    @FXML
    public void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("userName"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory<Register,String>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("phone"));
        loadRegister();

    }

    @FXML
    void loadAllregisterButton(ActionEvent event) {
        tableView.getItems().clear();
        loadRegister();

    }

    @FXML
    void registerButton(ActionEvent event) {
        tableView.getItems().clear();
        String email=emailTextfield.getText();
        String phoneNumber= phonenumber.getText();
        String userName=userNameTextField.getText();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Register.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Register y=new Register(email,phoneNumber,userName);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(RegisterforTraningController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(RegisterforTraningController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void loadRegister(){
        ObjectInputStream ois = null;
        try {
            Register y;
            ois = new ObjectInputStream(new FileInputStream("Register.bin"));
            while (true){
                y= (Register) ois.readObject();
                tableView.getItems().add(y);
            }
        }catch (Exception ex){
            try{
                if(ois != null){
                    ois.close();
                }
            }catch(IOException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }

    }

}
