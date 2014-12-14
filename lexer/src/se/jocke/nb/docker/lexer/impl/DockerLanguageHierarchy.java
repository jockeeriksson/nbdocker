package se.jocke.nb.docker.lexer.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author jocke
 */
public class DockerLanguageHierarchy extends LanguageHierarchy<DockerTokenId> {

    private static List<DockerTokenId> tokens;

    private static Map<Integer, DockerTokenId> idToToken;

    private static void init() {
        tokens = Arrays.<DockerTokenId>asList(new DockerTokenId[]{
            new DockerTokenId("EOF", "whitespace", 0),
            new DockerTokenId("WHITESPACE", "whitespace", 1),
            new DockerTokenId("SINGLE_LINE_COMMENT", "comment", 2),
            new DockerTokenId("FORMAL_COMMENT", "comment", 3),
            new DockerTokenId("MULTI_LINE_COMMENT", "comment", 4),
            new DockerTokenId("FROM", "keyword", 5),
            new DockerTokenId("MAINTAINER", "keyword", 6),
            new DockerTokenId("RUN", "keyword", 7),
            new DockerTokenId("CMD", "keyword", 8),
            new DockerTokenId("EXPOSE", "keyword", 9),
            new DockerTokenId("ENV", "keyword", 10),
            new DockerTokenId("ADD", "keyword", 11),
            new DockerTokenId("COPY", "keyword", 12),
            new DockerTokenId("ENTRYPOINT", "keyword", 13),
            new DockerTokenId("VOLUME", "keyword", 14),
            new DockerTokenId("USER", "keyword", 15),
            new DockerTokenId("WORKDIR", "keyword", 16),
            new DockerTokenId("ONBUILD", "keyword", 17),
            new DockerTokenId("STRING", "string", 18)
        });

        idToToken = new HashMap<Integer, DockerTokenId>();
        for (DockerTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    public static DockerTokenId getToken(int kind) {

        if (idToToken.containsKey(kind)) {
            return idToToken.get(kind);
        } else {
            throw new IllegalStateException("Token of id " + kind + " not found");
        }

    }

    @Override
    protected synchronized Collection<DockerTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<DockerTokenId> createLexer(LexerRestartInfo<DockerTokenId> info) {
        return new DockerLexer(info);
    }

    @Override
    protected LanguageEmbedding<?> embedding(Token<DockerTokenId> token, LanguagePath languagePath, InputAttributes inputAttributes) {
        return super.embedding(token, languagePath, inputAttributes); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    protected String mimeType() {
        return "text/docker";
    }

}
