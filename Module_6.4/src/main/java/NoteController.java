import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {

    @FXML private TextField titleField;
    @FXML private TextArea contentArea;
    @FXML private ListView<Note> noteListView;

    private Notebook notebook;

    @FXML
    public void initialize() {
        notebook = new Notebook();
        noteListView.setItems(notebook.getNotes());
        noteListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        titleField.setText(newValue.getTitle());
                        contentArea.setText(newValue.getContent());
                    }
                }
        );
    }

    @FXML
    public void handleAdd() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.trim().isEmpty() || !content.trim().isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            clearFields();
        }
    }

    @FXML
    public void handleUpdate() {
        Note selectedNote = noteListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            selectedNote.setTitle(titleField.getText());
            selectedNote.setContent(contentArea.getText());
            noteListView.refresh();
            clearFields();
        }
    }

    @FXML
    public void handleDelete() {
        Note selectedNote = noteListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            notebook.removeNote(selectedNote);
            clearFields();
        }
    }

    private void clearFields() {
        titleField.clear();
        contentArea.clear();
        noteListView.getSelectionModel().clearSelection();
    }
}