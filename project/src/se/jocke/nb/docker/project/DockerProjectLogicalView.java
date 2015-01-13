package se.jocke.nb.docker.project;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.support.ProjectActionPerformer;
import org.netbeans.spi.project.ui.support.ProjectSensitiveActions;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import se.jocke.nb.docker.project.actions.BuildProjectActionPerformer;
import se.jocke.nb.docker.project.actions.RunProjectActionPerformer;

/**
 *
 * @author jocke
 */
public class DockerProjectLogicalView implements LogicalViewProvider {

    private final Project project;

    @StaticResource()
    public static final String ICON = "se/jocke/nb/docker/project/wale.png";

    public DockerProjectLogicalView(Project project) {
        this.project = project;
    }

    @Override
    public org.openide.nodes.Node createLogicalView() {
        try {
            FileObject projectDirectory = project.getProjectDirectory();
            DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
            Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
            return new ProjectNode(nodeOfProjectFolder, project);
        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            return new AbstractNode(Children.LEAF);
        }
    }

    @Override
    public org.openide.nodes.Node findPath(org.openide.nodes.Node node, Object o) {
        return null;
    }

    private final class ProjectNode extends FilterNode {

        private final Project project;

        private ProjectNode(Node node, Project project) throws DataObjectNotFoundException {
            super(node, new FilterNode.Children(node),
                    new ProxyLookup(
                            new Lookup[]{
                                Lookups.singleton(project),
                                node.getLookup()
                            }));
            this.project = project;
        }

        @Override
        public Action[] getActions(boolean arg0) {
            return new Action[]{
                CommonProjectActions.newFileAction(),
                CommonProjectActions.copyProjectAction(),
                CommonProjectActions.deleteProjectAction(),
                CommonProjectActions.customizeProjectAction(),
                CommonProjectActions.closeProjectAction(),
                ProjectSensitiveActions.projectSensitiveAction(new RunProjectActionPerformer() , ActionProvider.COMMAND_RUN, null),
                ProjectSensitiveActions.projectSensitiveAction(new BuildProjectActionPerformer() , ActionProvider.COMMAND_BUILD, null)
            };
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage(ICON);
        }

        @Override
        public Image getOpenedIcon(int type) {
            return getIcon(type);
        }

        @Override
        public String getDisplayName() {
            return project.getProjectDirectory().getName();
        }

    }

}
