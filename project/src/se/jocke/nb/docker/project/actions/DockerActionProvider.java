package se.jocke.nb.docker.project.actions;

import org.netbeans.spi.project.ActionProvider;
import org.openide.util.Lookup;

/**
 *
 * @author jocke
 */
public class DockerActionProvider implements ActionProvider {

    @Override
    public String[] getSupportedActions() {
        return new String[]{
            ActionProvider.COMMAND_BUILD,
            ActionProvider.COMMAND_CLEAN,
            ActionProvider.COMMAND_RUN
        };
    }

    @Override
    public void invokeAction(String arg0, Lookup arg1) throws IllegalArgumentException {
        
    }

    @Override
    public boolean isActionEnabled(String arg0, Lookup arg1) throws IllegalArgumentException {
        return true;
    }

}
