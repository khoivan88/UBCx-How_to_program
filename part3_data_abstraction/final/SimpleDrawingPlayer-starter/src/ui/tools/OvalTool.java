package ui.tools;

import model.Oval;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool {

    public OvalTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
    }

    //EFFECTS: Constructs and returns the new shape
    protected void makeShape(MouseEvent e) {
        shape = new Oval(e.getPoint(), editor.getMidiSynth());
    }

    //EFFECTS: Returns the string for the label.
    protected String getLabel() {
        return "Oval";
    }
}

