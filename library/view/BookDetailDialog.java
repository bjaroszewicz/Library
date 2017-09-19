package pl.bj.library.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.bj.library.controller.BookControllerIf;
import pl.bj.library.model.Type;

public class BookDetailDialog {

	protected BookControllerIf bookController;
	private GridPane gridPane;

	protected Stage stage;
	protected TextField addTitle;
	protected TextField addAuthorName;
	protected TextField addAuthorSurname;
	protected ChoiceBox<Type> choiceBoxType;
	protected TextField addPublishingHouse;
	protected TextField addPrice;
	protected TextField addNumberPages;
	protected CheckBox checkBoxHardCover;
	protected CheckBox checkBoxWithPictures;
	protected Button saveBookButton;
	protected Button cancelButton;

	public BookDetailDialog(BookControllerIf bookController) {
		this.bookController = bookController;
	}

	public void show() {

		gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(5, 5, 5, 5));

		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(new Scene(gridPane, 600, 400));
		stage.show();

		Label addEditDataBookLabel = new Label("Add or edit data of book");
		addEditDataBookLabel.setFont(new Font("Arial", 20));

		gridPane.add(addEditDataBookLabel, 0, 0, 2, 1);

		Label titleLabel = new Label("Title: ");
		titleLabel.setFont(new Font("Arial", 15));

		gridPane.add(titleLabel, 0, 2, 1, 1);

		Label authorLabel = new Label("Author: ");
		authorLabel.setFont(new Font("Arial", 17));

		gridPane.add(authorLabel, 0, 3);

		Label authorNameLabel = new Label("Name: ");
		authorNameLabel.setFont(new Font("Arial", 15));

		gridPane.add(authorNameLabel, 0, 4);

		Label authorSurnameLabel = new Label("Surname: ");
		authorSurnameLabel.setFont(new Font("Arial", 15));

		gridPane.add(authorSurnameLabel, 2, 4);

		Label typeLabel = new Label("Type: ");
		typeLabel.setFont(new Font("Arial", 15));

		gridPane.add(typeLabel, 0, 5);

		Label publishingHouseLabel = new Label("Publishing house: ");
		publishingHouseLabel.setFont(new Font("Arial", 15));

		gridPane.add(publishingHouseLabel, 0, 6);

		Label priceLabel = new Label("Price: ");
		priceLabel.setFont(new Font("Arial", 15));

		gridPane.add(priceLabel, 0, 7);

		Label numberPagesLabel = new Label("Number Pages: ");
		numberPagesLabel.setFont(new Font("Arial", 15));

		gridPane.add(numberPagesLabel, 0, 8);

		Label hardCoverLabel = new Label("Hard Cover");
		hardCoverLabel.setFont(new Font("Arial", 15));

		gridPane.add(hardCoverLabel, 0, 9);

		Label withPicturesLabel = new Label("With Pictures");
		withPicturesLabel.setFont(new Font("Arial", 15));

		gridPane.add(withPicturesLabel, 0, 10);

		addTitle = new TextField();

		gridPane.add(addTitle, 1, 2);

		addAuthorName = new TextField();

		gridPane.add(addAuthorName, 1, 4);

		addAuthorSurname = new TextField();

		gridPane.add(addAuthorSurname, 3, 4);

		choiceBoxType = new ChoiceBox<Type>();

		gridPane.add(choiceBoxType, 1, 5);

		addPublishingHouse = new TextField();

		gridPane.add(addPublishingHouse, 1, 6);

		addPrice = new TextField();

		gridPane.add(addPrice, 1, 7);

		addNumberPages = new TextField();

		gridPane.add(addNumberPages, 1, 8);

		checkBoxHardCover = new CheckBox();

		gridPane.add(checkBoxHardCover, 1, 9);

		checkBoxWithPictures = new CheckBox();

		gridPane.add(checkBoxWithPictures, 1, 10);

		saveBookButton = new Button();
		saveBookButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				bookController.addBook(addTitle.getText(),
						addAuthorName.getText(), addAuthorSurname.getText(),
						choiceBoxType.getValue(), addPublishingHouse.getText(),
						addPrice.getText().equals("") ? null
								: Double.parseDouble(addPrice.getText()),
						addNumberPages.getText().equals("") ? null
								: Integer.parseInt(addNumberPages.getText()),
						checkBoxHardCover.isSelected(),
						checkBoxWithPictures.isSelected());
				stage.close();
			}
		});

		gridPane.add(saveBookButton, 0, 12);

		cancelButton = new Button();
		cancelButton.setText("cancel");
		cancelButton.setOnAction(event -> {
			stage.close();
		});

		gridPane.add(cancelButton, 1, 12);
	}
}
