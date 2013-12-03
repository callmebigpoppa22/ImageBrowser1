package imagebrowser;

import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {
    
    private final ImageViewer viewer;

    public NextImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
    
    

}
