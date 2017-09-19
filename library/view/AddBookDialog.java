package pl.bj.library.view;

import javafx.collections.FXCollections;
import pl.bj.library.controller.BookControllerIf;
import pl.bj.library.model.Type;

public class AddBookDialog extends BookDetailDialog {

	public AddBookDialog(BookControllerIf bookController) {
		super(bookController);
	}

	public void show() {
		super.show();

		stage.setTitle("Add book");

		addTitle.setPromptText("Title");

		addAuthorName.setPromptText("Author Name");

		addAuthorSurname.setPromptText("Author Surame");

		choiceBoxType
				.setItems(FXCollections.observableArrayList(Type.values()));

		addPublishingHouse.setPromptText("Publishing house");

		addPrice.setPromptText("Price");

		addNumberPages.setPromptText("Number pages");

		saveBookButton.setText("add book");
	}
}
