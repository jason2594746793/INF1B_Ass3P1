package literature;

public enum Verbosity {
    SILENT(false),
    VERBOSE(true);
    boolean verbose;

    Verbosity(boolean verbose)
    {
        setVerbose(verbose);
    }

    public boolean isVerbose()
    {
        return verbose;
    }

    public void setVerbose(boolean verbose)
    {
        this.verbose = verbose;
    }
}
