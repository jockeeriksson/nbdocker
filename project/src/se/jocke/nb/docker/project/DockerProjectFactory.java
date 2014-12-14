package se.jocke.nb.docker.project;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jocke
 */
@ServiceProvider(service=ProjectFactory.class)
public class DockerProjectFactory implements ProjectFactory {
    
    public static final String PROJECT_FILE = "docker.properties";

    @Override
    public boolean isProject(FileObject projectDirectory) {
        return projectDirectory.getFileObject(PROJECT_FILE) != null;
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState ps) throws IOException {
        return isProject(dir) ? new DockerProject(dir, ps) : null;
    }

    @Override
    public void saveProject(Project project) throws IOException, ClassCastException {
    }
    
}
