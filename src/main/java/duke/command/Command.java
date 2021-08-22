package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public abstract class Command {
    String line;

    public Command(String cmd) {
        line = cmd;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
//        tasks.execute();
//        ui.showBye();
    }

    public boolean isExit() {
        return false;
    }
}
