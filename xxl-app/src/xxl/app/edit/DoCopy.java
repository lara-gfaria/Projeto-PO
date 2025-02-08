package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.Spreadsheet;
import xxl.exceptions.UnrecognizedEntryException;

/**
 * Copy command.
 */
class DoCopy extends Command<Spreadsheet> {

    DoCopy(Spreadsheet receiver) {
        super(Label.COPY, receiver);
        addStringField("address", Prompt.address());

    }

    @Override
    protected final void execute() throws CommandException {
        try{
            _receiver.copy(stringField("address"));
        }
        catch (UnrecognizedEntryException e){
            throw new InvalidCellRangeException(e.getEntrySpecification());
        }
    }

}
