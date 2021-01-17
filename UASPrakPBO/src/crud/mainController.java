/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ASUS
 */
public class mainController implements Initializable {
    
    private Label label;
    @FXML
    private TextField nama;
    @FXML
    private TextField ttl;
    @FXML
    private ComboBox<?> kelamin;
    @FXML
    private TextField alamat;
    @FXML
    private ComboBox<?> agama;
    @FXML
    private ComboBox<?> status;
    @FXML
    private ComboBox<?> jabatan;
    @FXML
    private ComboBox<?> divisi;
    @FXML
    private TableView<?> colom;
    @FXML
    private TableColumn<books, String> cnama;
    @FXML
    private TableColumn<books, String> cttl;
    @FXML
    private TableColumn<books, String> cjk;
    @FXML
    private TableColumn<books, String> calamat;
    @FXML
    private TableColumn<books, String> cagama;
    @FXML
    private TableColumn<books, String> cstatus;
    @FXML
    private TableColumn<books, String> cjabatan;
    @FXML
    private TableColumn<books, String> cdivisi;
    @FXML
    private Button input;
    @FXML
    private Button edit;
    @FXML
    private Button hapus;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("odbc:mysql://localhost:3306/karyawan", "root","");
            return conn;
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
            return null;
        }
        
    }
    public ObservableList<books>getBooksList() throws SQLException{
        ObservableList<books> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM books";
        Statement st;
        ResultSet rs;
        
        try{
            st = (Statement) conn.createStatement ();
            rs = (ResultSet) st;
            books Books;
            while(rs.next()){
                Books = new books (rs.getString("nama"),rs.getString("ttl"),rs.getString("kelamin"),rs.getString("alamat"),rs.getString("agama"),rs.getString("status"),rs.getString("jabatan"),rs.getString("divisi"));
                BooksList.add(Books);
            }
          
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return bookList;
        
    }
    public void showBooks(){
        ObservableList<books> list= getbookList();
        
        cnama.setCellValueFactory(new PropertyValueFactory<books,String>("nama"));
        cttl.setCellValueFactory(new PropertyValueFactory<books,String>("ttl"));
        cjk.setCellValueFactory(new PropertyValueFactory<books,String>("kelamin"));
        calamat.setCellValueFactory(new PropertyValueFactory<books,String>("alamat"));
        cagama.setCellValueFactory(new PropertyValueFactory<books,String>("agama"));
        cstatus.setCellValueFactory(new PropertyValueFactory<books,String>("status"));
        cjabatan.setCellValueFactory(new PropertyValueFactory<books,String>("jabatan"));
        cdivisi.setCellValueFactory(new PropertyValueFactory<books,String>("divisi"));
        
    }

    private ObservableList<books> getbookList() {
        return null;
    }

    
}
