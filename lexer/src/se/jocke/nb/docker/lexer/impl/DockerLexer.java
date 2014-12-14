package se.jocke.nb.docker.lexer.impl;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import se.jocke.nb.docker.lexer.DockerParserTokenManager;
import se.jocke.nb.docker.lexer.JavaCharStream;

/**
 *
 * @author jocke
 */
public class DockerLexer implements Lexer<DockerTokenId> {

    private final LexerRestartInfo<DockerTokenId> info;
    private final DockerParserTokenManager dockerParserTokenManager;

    DockerLexer(LexerRestartInfo<DockerTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        dockerParserTokenManager = new DockerParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<DockerTokenId> nextToken() {
        se.jocke.nb.docker.lexer.Token token = dockerParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(DockerLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}
