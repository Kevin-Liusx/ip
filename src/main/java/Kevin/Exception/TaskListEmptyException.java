package Kevin.Exception;

public class TaskListEmptyException extends Exception{
    public TaskListEmptyException(String errorMessage) {
        super(errorMessage);
    }
}