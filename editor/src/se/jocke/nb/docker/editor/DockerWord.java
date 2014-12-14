package se.jocke.nb.docker.editor;

/**
 *
 * @author jocke
 */
public enum DockerWord {

    FROM(new DockerCompletionDocumentation("The FROM instruction sets the Base Image for subsequent instructions."
            + " As such, a valid Dockerfile must have FROM as its first instruction."
            + " The image can be any valid image – it is especially easy to start by pulling an"
            + " image from the Public Repositories.", "http://docs.docker.com/reference/builder/#from")),
    MAINTAINER(new DockerCompletionDocumentation("The MAINTAINER instruction allows you to set"
            + " the Author field of the generated image", "http://docs.docker.com/reference/builder/#maintainer")),
    RUN(new DockerCompletionDocumentation("The RUN instruction will execute any commands in a new layer on top of"
            + " the current image and commit the results. The resulting committed image will be used"
            + " for the next step in the Dockerfile.", "http://docs.docker.com/reference/builder/#run")),
    CMD(new DockerCompletionDocumentation("The main purpose of a CMD is to provide defaults for an executing container."
            + " These defaults can include an executable, or they can omit the executable,"
            + " in which case you must specify an ENTRYPOINT instruction as well.", "http://docs.docker.com/reference/builder/#cmd")),
    EXPOSE(new DockerCompletionDocumentation("The EXPOSE instructions informs Docker that the container"
            + " will listen on the specified network ports at runtime. Docker uses"
            + " this information to interconnect containers", "http://docs.docker.com/reference/builder/#expose")),
    ENV(new DockerCompletionDocumentation("The ENV instruction sets the environment variable <key> to the value <value>."
            + " This value will be passed to all future RUN instructions. This is functionally"
            + " equivalent to prefixing the command with <key>=<value>", "http://docs.docker.com/reference/builder/#env")),
    ADD(new DockerCompletionDocumentation("The ADD instruction copies new files,directories or remote file URLs to the filesystem of the container"
            + " from <src> and add them to the at path <dest>", "http://docs.docker.com/reference/builder/#add")),
    COPY(new DockerCompletionDocumentation("The COPY instruction copies new files,directories or remote file URLs to the"
            + " filesystem of the container from <src> and add them to the at path <dest>.", "http://docs.docker.com/reference/builder/#copy")),
    ENTRYPOINT(new DockerCompletionDocumentation("An ENTRYPOINT helps you to configure a container that you can run as an executable."
            + " That is, when you specify an ENTRYPOINT, then the whole container runs as"
            + " if it was just that executable.", "http://docs.docker.com/reference/builder/#entrypoint")),
    VOLUME(new DockerCompletionDocumentation("The VOLUME instruction will create a mount point with the specified name"
            + " and mark it as holding externally mounted volumes from native host or other containers."
            + " The value can be a JSON array, VOLUME [\"/var/log/\"], or a plain string with multiple"
            + " arguments, such as VOLUME /var/log or VOLUME /var/log /var/db. For more information/examples"
            + " and mounting instructions via the Docker client,"
            + " refer to Share Directories via Volumes documentation.", "http://docs.docker.com/reference/builder/#volume")),
    USER(new DockerCompletionDocumentation("The USER instruction sets the user name or UID"
            + " to use when running the image and for any following RUN directives.", "http://docs.docker.com/reference/builder/#user")),
    WORKDIR(new DockerCompletionDocumentation("The WORKDIR instruction sets the working directory"
            + " for any RUN, CMD and ENTRYPOINT instructions that follow it in the Dockerfile.", "http://docs.docker.com/reference/builder/#workdir")),
    ONBUILD(new DockerCompletionDocumentation("The ONBUILD instruction adds to the image a trigger instruction to be executed"
            + " at a later time, when the image is used as the base for another build."
            + " The trigger will be executed in the context of the downstream build, as"
            + " if it had been inserted immediately after the FROM"
            + " instruction in the downstream Dockerfile.", "http://docs.docker.com/reference/builder/#onbuild"));

    private DockerWord(DockerCompletionDocumentation documentation) {
        this.documentation = documentation;
    }

    private final DockerCompletionDocumentation documentation;

    public DockerCompletionDocumentation getDocumentation() {
        return documentation;
    }
}
