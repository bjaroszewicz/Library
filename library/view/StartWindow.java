package pl.bj.library.view;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.bj.library.controller.BookControllerIf;
import pl.bj.library.controller.DatabaseController;
import pl.bj.library.model.Book;

public class StartWindow extends Application {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private BookControllerIf bookController = new DatabaseController(sessionFactory);

	private final TableView<Book> table = new TableView<Book>();
	private GridPane gridPane;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage primaryStage) {

		gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(5, 5, 5, 5));

		Scene scene = new Scene(gridPane, 650, 500);

		Button addBook = new Button();
		addBook.setText("Add Book");
		addBook.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new AddBookDialog(bookController).show();
			}
		});
		gridPane.add(addBook, 0, 0, 1, 1);

		Button deleteBook = new Button();
		deleteBook.setText("Delete Book");
		deleteBook.setOnAction(event -> {
			Book selectedItem = table.getSelectionModel().getSelectedItem();
			bookController.removeBook(selectedItem);
		});
		gridPane.add(deleteBook, 1, 0);

		Button editBook = new Button();
		editBook.setText("Edit Book");
		editBook.setOnAction(event -> {
			Book selectedItem = table.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				new EditBookDialog(bookController, selectedItem).show();
			}
		});
		gridPane.add(editBook, 2, 0);

		TableColumn title = new TableColumn("title");
		title.setCellValueFactory(new PropertyValueFactory<>("title"));

		TableColumn author = new TableColumn("author");
		author.setCellValueFactory(new PropertyValueFactory<>("author"));

		TableColumn type = new TableColumn("type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));

		TableColumn publishingHouse = new TableColumn("publishingHouse");
		publishingHouse.setCellValueFactory(new PropertyValueFactory<>("publishingHouse"));

		TableColumn price = new TableColumn("price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn numberPages = new TableColumn("numberPages");
		numberPages.setCellValueFactory(new PropertyValueFactory<>("numberPages"));

		TableColumn hardCover = new TableColumn("hardCover");
		hardCover.setCellValueFactory(new PropertyValueFactory<>("hardCover"));

		TableColumn withPictures = new TableColumn("withPictures");
		withPictures.setCellValueFactory(new PropertyValueFactory<>("withPictures"));

		table.getColumns().addAll(title, author, type, publishingHouse, price, numberPages, hardCover,
				withPictures);
		table.setItems(bookController.getBooks());

		gridPane.add(table, 0, 1, 3, 1);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		sessionFactory.close();
	}

}
