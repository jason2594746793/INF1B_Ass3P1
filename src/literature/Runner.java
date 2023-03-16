package literature;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.IntStream;

public class Runner {
    public static final Verbosity VERBOSE = Verbosity.VERBOSE;

    public static final String LOG_PREFIX = "Log: ";

    public static final int JDK_MINIMUM = 11;

    private static final boolean[] PRELIMINARY_CHECKS =
            new boolean[]{
                    jdkAcceptable()
            };

    /* DONE PRELIMINARY_CHECKS_PASSED uses several advanced features of Java
            as short-hand for collapsing an array of boolean values,
            whose length isn't explicitly specified, into a single result.
            There is NO requirement to be able to write this nor even
            to understand how this works. But it is here for your further study
            if you are interested. Look at the official Oracle java
            documentation for lambda expressions (the -> symbol), IntStream,
            and filtering (in this case allMatch).
    */
    private static final boolean PRELIMINARY_CHECKS_PASSED =
            IntStream.range(0, PRELIMINARY_CHECKS.length)
                     .allMatch(i -> PRELIMINARY_CHECKS[i]);

    private static String[] args;


    private static String getCallingMethodName() {

        /* DONE 1: examine the StackTrace from a Throwable
                2: get the name of the method you want
                   hint: it is not at the end of the stack
                3: define a suitable constant for the offset
                4: return the name of the method
        */
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int Index = 3;
        return stackTraceElements[Index].getMethodName();
    }

    private static void log(boolean ok) {
        if (VERBOSE.isVerbose()) {
            System.out.printf("%s%s: %S%n", LOG_PREFIX, getCallingMethodName(), ok);
        }

        // DONE First: create an if based on the verbosity level
            /* DONE format print the LOG_PREFIX,
                                 the name of the calling method, and
                                 the value of parameter
                    using the format String "%s%s: %S%n"
            */
    }

    private static int getJavaVersion() {
        return Integer.parseInt(System.getProperty("java.version").split("\\.")[0]);
    }

    private static boolean jdkAcceptable() {

        /* DONE set the boolean ok if the retrieved JDK is at least
                                   that specified in the minimum acceptable version
                log the boolean ok and return it.
        */
        boolean ok = getJavaVersion() >= JDK_MINIMUM;
        log(ok);
        return ok;
    }

    private static boolean argsLengthOK(String[] args) {
        /* DONE set the boolean ok according to the Engineering Requirements
                log the boolean ok and return it.
        */
        boolean ok = args.length > 0;
        log(ok);
        return ok;
    }

    private static boolean fileOK(String filename) {
        // DONE work out where to set the boolean ok appropriately and without redundant assignments.
        boolean ok = false;
        try (final FileInputStream fis = new FileInputStream(filename))
        {
            int ignored = fis.read(); // check file is not empty by reading something
            ok = ignored != -1;
        }
        catch ( IOException e )
        {
            log(ok);
        }
        log(ok);
        return(ok);
    }

    private static boolean checksPassed() {
        /* DONE There are currently 2 checks to be passed
                Think how to run these efficiently and about the order of testing.
        */
        return argsLengthOK(args) && fileOK(args[0]);
    }


    public static void main(String[] clArgs) {
        args = clArgs;
        log(true);
        /* DONE Enclose this line:
                System.out.println("Good to go");
                so that both sets of checks are passed first.
                Note: that's two *sets* of checks, not just two individual checks.
        */
        /* Done Once everything is (more or less working) change from
                VerbositySimple to Verbosity and see how making use of Verbosity's
                different levels and its isVerbose() method can help readability
                in your code. Think about how enums or booleans can be used in
                the readability of code especially with respect to parameters
                and conditions.
        */
        if (PRELIMINARY_CHECKS_PASSED && checksPassed()) {
            System.out.println("Good to go");
        }
        else
        {
            System.out.println("Error");
        }
    }
}
