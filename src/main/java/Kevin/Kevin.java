package Kevin;

import Kevin.Parser.Parser;
import Kevin.Storage.Storage;
import Kevin.TaskList.TaskList;
import Kevin.Ui.Ui;

import java.io.FileNotFoundException;

/**
 * Encapsulates the chatbot.
 */
public class Kevin{
    private  static final String filePath = "src/main/java/Database.txt";
    private Ui ui;
    private TaskList taskList;
    private Storage storage;

    /**
     * Default constructor for this chabot.
     *
     * @param filePath This is the file path to which the tasks will be stored at.
     */
    public Kevin(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath, this.taskList);
        try {
            taskList = new TaskList(storage.load(), this.storage);
        } catch (FileNotFoundException fileException) {
            storage.createNewFile();
        }
    }

    /**
     * This method is automatically called to
     * start the conversation with the bot.
     */
    public void run() {
        this.ui.printGreetMessage();
        boolean isExit = false;

        while (!isExit) {
            String userCommand = ui.readUserCommand();
            Parser.parse(userCommand, this.taskList, this.ui);
            isExit = Parser.getIsExit();
        }
    }
    public static void main(String[] args) {
        new Kevin(filePath).run();
    }
}