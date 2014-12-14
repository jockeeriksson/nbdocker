package se.jocke.nb.docker.lexer.impl;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;

/**
 *
 * @author jocke
 */
@LanguageRegistration(mimeType = "text/docker")
public class DockerLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return DockerTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Docker";
    }
    
    

}
