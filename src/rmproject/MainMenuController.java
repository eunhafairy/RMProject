
package rmproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import models.Food;
import models.Order;
import models.Table;


public class MainMenuController implements Initializable {

    //configure the food list table
    @FXML private TableView<Food> tableViewFood;
    @FXML private TableColumn<Food, String> foodNameCol;
    @FXML private TableColumn<Food, Double> foodPriceCol;
    @FXML private TableColumn<Food, String> foodDescCol;
    
    //configure the order list table
    @FXML private TableView<Order> tableViewOrder;
    @FXML private TableColumn<Order, String> nameOrder;
    @FXML private TableColumn<Order, Double> priceOrder;
    @FXML private TableColumn<Order, Integer> qtyOrder;
    @FXML private TableColumn<Order, Double> totalOrder;
    
    //configure the tables in tableview
    @FXML private TableView<Table> tableTableView;
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        //init of order table view
        nameOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        priceOrder.setCellValueFactory(new PropertyValueFactory<Order, Double>("price"));
        qtyOrder.setCellValueFactory(new PropertyValueFactory<Order, Integer>("qty"));
        totalOrder.setCellValueFactory(new PropertyValueFactory<Order, Double>("total"));
      
        
        //set the table view of food and order editable
      tableViewFood.setEditable(true);
      tableViewOrder.setEditable(true);
    
        foodNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewFood.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        qtyOrder.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())
        );
         
    }    
    

    
 //GET FOODS
    public ObservableList<Food> getMainDishFood(){
    
        ObservableList<Food> foods = FXCollections.observableArrayList();
        foods.add(new Food("Tuna Paella", 2.00, "Description here","Main Dish"));
        foods.add(new Food("Chiken Biryani", 2.00, "Description here","Main Dish"));
        foods.add(new Food("Masarap na food", 2.00, "Description here","Main Dish"));
        return foods;
        
    }
      public ObservableList<Food> getAppFood(){
    
        ObservableList<Food> foods = FXCollections.observableArrayList();
        foods.add(new Food("Mash Potato", 4.50, "Patatas Power","Appetizer"));
        foods.add(new Food("Appetizer 2", 3.00, "Description here2","Appetizer"));
        foods.add(new Food("Appetizer 3", 2.345, "Description here3","Appetizer"));
        return foods;
        
    }
       public ObservableList<Food> getDesFood(){
    
        ObservableList<Food> foods = FXCollections.observableArrayList();
        foods.add(new Food("Dessert 1", 4.50, "desserrt desc 1","Dessert"));
        foods.add(new Food("Dessert 2", 3.00, "Description here2","Dessert"));
        foods.add(new Food("dessert 3", 2.345, "Description here3","Dessert"));
        return foods;
        
    }
        public ObservableList<Food> getDrinks(){
    
        ObservableList<Food> foods = FXCollections.observableArrayList();
        foods.add(new Food("Drinks 1", 5.50, "Drinks 1 desc","Drinks"));
        foods.add(new Food("Drinks 2", 6.00, "Drinks 2 desc","Drinks"));
        foods.add(new Food("Drinks 3", 9.345, "drinks desc3","Drinks"));
        return foods;
        
    }
      
      
      
      
      
    //BUTTONS 
    public void mainDishBtn(){
      //set columns in the table
            foodNameCol.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
            foodPriceCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
            foodDescCol.setCellValueFactory(new PropertyValueFactory<Food, String>("description"));
           
            //load dummy data
            tableViewFood.setItems(getMainDishFood());
    }
    
     public void appBtn(){
      //set columns in the table
            foodNameCol.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
            foodPriceCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
            foodDescCol.setCellValueFactory(new PropertyValueFactory<Food, String>("description"));
           
            //load dummy data
            tableViewFood.setItems(getAppFood());
    }
     public void desBtn(){
      //set columns in the table
            foodNameCol.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
            foodPriceCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
            foodDescCol.setCellValueFactory(new PropertyValueFactory<Food, String>("description"));
           
            //load dummy data
            tableViewFood.setItems(getDesFood());
    }
    
     public void drinksBtn(){
      //set columns in the table
            foodNameCol.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
            foodPriceCol.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
            foodDescCol.setCellValueFactory(new PropertyValueFactory<Food, String>("description"));
           
            //load dummy data
            tableViewFood.setItems(getDrinks());
    }
     
     //add highlighted row to order
     public void addOrderbtn(){
     Food selectedFood = tableViewFood.getSelectionModel().getSelectedItem();
     double total = selectedFood.getPrice();
     Order newOrder = new Order(selectedFood.getName(), selectedFood.getPrice(),1, total);
     tableViewOrder.getItems().add(newOrder);
     
     }
     
     
     
     public void checkoutBtn(){
     double total;
     
     
     }
     
   //edit cells 
     
    public void changeQtyCellEvent(CellEditEvent eventNew){
    Order rowselected = tableViewOrder.getSelectionModel().getSelectedItem();
    rowselected.setQty(Integer.parseInt(eventNew.getNewValue().toString()));
    rowselected.setTotal(rowselected.getPrice()*rowselected.getQty());
    
  
    tableViewOrder.getColumns().get(0).setVisible(false);
    tableViewOrder.getColumns().get(0).setVisible(true);
       
   }
  //to delete rows
    public void removeItem(){
        
        
    Order selectedrow = tableViewOrder.getSelectionModel().getSelectedItem();
    tableViewOrder.getItems().remove(selectedrow);
    
    }

    
    
}
