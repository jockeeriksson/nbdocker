package se.jocke.nb.docker.project;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author jocke
 */
public class DockerProject implements Project {

    private final FileObject root;
    private final ProjectState ps;
    private Lookup lkp;

    public DockerProject(FileObject root, ProjectState ps) {
        this.root = root;
        this.ps = ps;
    }

    @Override
    public FileObject getProjectDirectory() {
        return root;
    }

    @Override
    public Lookup getLookup() {
        if (lkp == null) {

            lkp = Lookups.fixed(new Object[]{
                new DockerInfo(this),
                new DockerProjectLogicalView(this),
                new DockerCustomizerProvider(this)
            });
        }

        return lkp;
    }

}
