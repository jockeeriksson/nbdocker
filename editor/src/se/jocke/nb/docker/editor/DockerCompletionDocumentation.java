package se.jocke.nb.docker.editor;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Action;
import org.netbeans.spi.editor.completion.CompletionDocumentation;
import org.openide.util.Exceptions;

/**
 *
 * @author jocke
 */
public class DockerCompletionDocumentation implements CompletionDocumentation {

    private final String text;
    private final String url;

    public DockerCompletionDocumentation(String text, String url) {
        this.text = text;
        this.url = url;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public URL getURL() {
        try {
            return new URL(url);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }

    @Override
    public CompletionDocumentation resolveLink(String string) {
        return null;
    }

    @Override
    public Action getGotoSourceAction() {
        return null;
    }

}
