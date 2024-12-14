package com.example.finalsubmission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineQuizController {

    @FXML
    private TextField idTExtField;

    @FXML
    private TableColumn<onlineQuiz, String > idcolumn;

    @FXML
    private TableColumn<onlineQuiz, String> markColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<onlineQuiz, String> namecolumn;

    @FXML
    private TableColumn<onlineQuiz, String> subjectColumn;

    @FXML
    private ComboBox<String> subjectcombobox;

    @FXML
    private TableView<onlineQuiz> tableview;
    @FXML
    private TextField marlsTexts;


    @javafx.fxml.FXML
    public void initialize() {
        subjectcombobox.getItems().addAll("English","Math","Physics");
        idcolumn.setCellValueFactory(new PropertyValueFactory<onlineQuiz,String>("id"));
        markColumn.setCellValueFactory(new PropertyValueFactory<onlineQuiz,String>("marks"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<onlineQuiz,String>("name"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<onlineQuiz,String>("subject"));
        loadOnline();

    }

    @FXML
    void submitButton(ActionEvent event) {
        String name=nameTextField.getText();
        String id=idTExtField.getText();
        String subject=subjectcombobox.getValue();
        String marks=marlsTexts.getText();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("OnlineQuiz.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            onlineQuiz y=new onlineQuiz(name,id,subject,marks);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(OnlineQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(OnlineQuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public void loadOnline(){
        ObjectInputStream ois = null;
        try {
            onlineQuiz y;
            ois = new ObjectInputStream(new FileInputStream("OnlineQuiz.bin"));
            while (true){
                y= (onlineQuiz) ois.readObject();
                tableview.getItems().add(y);
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
