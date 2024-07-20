package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import tm.CustomerTM;



public class CustomerController {
     

    @FXML
    private JFXButton btnSave;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TableColumn<CustomerTM, String> colAddress;

    @FXML
    private TableColumn<CustomerTM, Integer> colId;

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<CustomerTM, Double> colSalary;

    @FXML
    private TableColumn<CustomerTM, Button> colAction;

    public void getAllCustomer()throws ClassNotFoundException,SQLException{

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT*FROM customer");
       ResultSet customerSet = statement.executeQuery();

       ArrayList<Customer> CustomerList = new ArrayList<Customer>();

       while(customerSet.next()){
            Customer customer = new Customer(
            customerSet.getInt(1),
            customerSet.getString(2),
            customerSet.getString(3),
            customerSet.getDouble(4)
        );
            CustomerList.add(customer);

      
        }
        System.out.println(CustomerList);

      ObservableList<CustomerTM> CustomerTMList = FXCollections.observableArrayList();

      for(Customer cust:CustomerList){
        Button button = new Button("Delete");
        CustomerTM customerTM = new CustomerTM(
                    cust.getCustId(),
                    cust.getCustName(),
                    cust.getAddress(),
                    cust.getSalary(),
                    button
                );
        CustomerTMList.add(customerTM);

      }
      System.out.println(CustomerTMList);
      tblCustomer.setItems(CustomerTMList);
    
    }

    public void initialize() throws ClassNotFoundException, SQLException{
        colId.setCellValueFactory(new PropertyValueFactory<>("CustId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllCustomer();
    }



    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) throws ClassNotFoundException,SQLException{
        // System.out.println("ID:"+txtId.getText());
        // System.out.println("Name:"+txtName.getText());
        // System.out.println("Address:"+txtAddress.getText());
        // System.out.printf("Salary:"+ txtSalary.getText());

        int id=Integer.parseInt(txtId.getText());
        String name=txtName.getText();
        String address=txtAddress.getText();
        double salary=Double.parseDouble(txtSalary.getText());

        Customer  customer = new Customer(id,name,address,salary);

        // System.out.println(customer);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
        statement.setObject(1, customer.getCustId());
        statement.setObject(2, customer.getCustName());
        statement.setObject(3, customer.getAddress());
        statement.setObject(4, customer.getSalary());

        int rows=statement.executeUpdate();
        if(rows>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved Successfully").show();
            System.out.println("Customer saved successfully");
        }
        else{
            System.out.println("Error in Customer Save");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved Error").show();

        }
    }

    @FXML
    void btnLoadTableOnAction(ActionEvent event)throws ClassNotFoundException,SQLException {
        getAllCustomer();      


    }

}
       




    

