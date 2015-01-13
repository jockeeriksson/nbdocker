package se.jocke.nb.docker.project.actions;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.ProjectActionPerformer;

/**
 *
 * @author jocke
 */
public class RunProjectActionPerformer implements ProjectActionPerformer{

    @Override
    public boolean enable(Project project) {
        return true;
    }

    @Override
    public void perform(Project project) {
    }
    
}
