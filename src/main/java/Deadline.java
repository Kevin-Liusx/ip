public class Deadline extends Task{
    private String day;


    private Deadline(String description, String day) {
        super(description);
        this.day = day;
    }

    public static Deadline createNewDeadlineTask(String description) {
        String[] splitMessage = description.split(" /by ");
        return new Deadline(splitMessage[0], splitMessage[1]);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.day + ")";
    }
}
