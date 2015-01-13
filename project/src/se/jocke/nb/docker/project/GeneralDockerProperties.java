package se.jocke.nb.docker.project;

import javax.swing.JComponent;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import se.jocke.nb.docker.project.panels.BuildPanel;
import se.jocke.nb.docker.project.panels.RunPanel;

/**
 *
 * @author jocke
 */
public class GeneralDockerProperties implements ProjectCustomizer.CompositeCategoryProvider {

    private static final String RUN = "Run";

    private static final String BUILD = "Build";

    private final String name;

    public GeneralDockerProperties(String name) {
        this.name = name;
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = "org-docker-project", position = 10)
    public static GeneralDockerProperties createRunCategory() {
        return new GeneralDockerProperties(RUN);
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = "org-docker-project", position = 10)
    public static GeneralDockerProperties createBuildCategory() {
        return new GeneralDockerProperties(BUILD);
    }

    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(this.name, this.name, null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category ctgr, Lookup lkp) {
        if (RUN.equals(ctgr.getName())) {
            return new RunPanel();
        } else {
            return new BuildPanel();
        }
    }
}
