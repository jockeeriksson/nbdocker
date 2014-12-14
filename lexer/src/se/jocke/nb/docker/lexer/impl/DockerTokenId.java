package se.jocke.nb.docker.lexer.impl;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author jocke
 */
public class DockerTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    public DockerTokenId(String name, String primaryCategory, int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public static Language<DockerTokenId> getLanguage() {
        return new DockerLanguageHierarchy().language();
    }

}
