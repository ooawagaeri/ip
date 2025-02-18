package duke.command;

import duke.exception.DukeException;
import duke.exception.Messages;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Represents a done user command.
 * Inherits from command class.
 */
public class DoneCommand extends Command {
    /**
     * Constructs DoneCommand object.
     *
     * @param cmd task command to be completed.
     */
    public DoneCommand(String cmd) {
        super(cmd);
    }

    /**
     * Executes command.
     * Marks task as done.
     *
     * @param tasks list of tasks within chat bot.
     * @param ui user interface of chat bot.
     * @param storage file directory manager.
     * @return chat bot response message.
     * @throws DukeException If unable to done task.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            int index = getIndex();
            String commandResult = tasks.done(index);

            String output = ui.showDone(commandResult);
            super.execute(tasks, ui, storage);

            return output;
        } catch (Exception e) {
            throw new DukeException(Messages.EXIST.toString());
        }
    }

    /**
     * Returns if command exits program.
     *
     * @return true if command exists program.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
