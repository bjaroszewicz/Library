package pl.bj.library.view;

import javafx.collections.FXCollections;
import pl.bj.library.controller.BookControllerIf;
import pl.bj.library.model.Book;
import pl.bj.library.model.Type;

public class EditBookDialog extends BookDetailDialog {

	Book book;

	public EditBookDialog(BookControllerIf bookController, Book book) {
		super(bookController);
		this.book = book;
	}

	public void show() {
		super.show();

		stage.setTitle("Edit book");

		String title = book.getTitle();
		addTitle.setText(title);
		addTitle.setPromptText("Title");

		String authorName = book.getAuthor().getName();
		addAuthorName.setText(authorName);
		addAuthorName.setPromptText("Author Name");

		String authorSurname = book.getAuthor().getSurname();
		addAuthorSurname.setText(authorSurname);
		addAuthorSurname.setPromptText("Author Surame");

		Type type = book.getType();
		choiceBoxType.setValue(type);
		choiceBoxType
				.setItems(FXCollections.observableArrayList(Type.values()));

		String publishingHouse = book.getPublishingHouse();
		addPublishingHouse.setText(publishingHouse);
		addPublishingHouse.setPromptText("Publishing house");

		Double price = book.getPrice();
		if (price == null) {
			addPrice.setText("");
		} else {
			addPrice.setText(String.valueOf(price));
		}
		addPrice.setPromptText("Price");

		Integer numberPages = book.getNumberPages();
		if (numberPages == null) {
			addNumberPages.setText("");
		} else {
			addNumberPages.setText(String.valueOf(numberPages));
		}
		addNumberPages.setPromptText("Number pages");

		Boolean hardCover = book.getHardCover();
		checkBoxHardCover.setSelected(hardCover);

		Boolean withPictures = book.getWithPictures();
		checkBoxWithPictures.setSelected(withPictures);

		saveBookButton.setText("edit book");
		saveBookButton.setOnAction(event -> {
			bookController.addBook(addTitle.getText(), addAuthorName.getText(),
					addAuthorSurname.getText(), choiceBoxType.getValue(),
					addPublishingHouse.getText(),
					addPrice.getText().equals("") ? null
							: Double.parseDouble(addPrice.getText()),
					addNumberPages.getText().equals("") ? null
							: Integer.parseInt(addNumberPages.getText()),
					checkBoxHardCover.isSelected(),
					checkBoxWithPictures.isSelected());
			bookController.removeBook(book);
			stage.close();
		});
	}
}
