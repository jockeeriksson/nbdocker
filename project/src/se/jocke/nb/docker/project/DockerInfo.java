package se.jocke.nb.docker.project;

import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.openide.util.ImageUtilities;

/**
 *
 * @author jocke
 */
public class DockerInfo implements ProjectInformation {

    private final Project project;

    @StaticResource()
    public static final String ICON = "se/jocke/nb/docker/project/wale.png";

    public DockerInfo(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return project.getProjectDirectory().getName();
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    @Override
    public Icon getIcon() {
        return new ImageIcon(ImageUtilities.loadImage(ICON));
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pl) {
        
    }

}
