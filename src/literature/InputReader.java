package literature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    public static AbstractCollection<String> readDictionary(String dictionaryFileName
            , boolean verbose) {
        AbstractCollection<String> words = new ArrayList<>();
        /* TODO Start this method by working out the mechanics of processing
                input robustly. Only once that is working should you look at the
                type of object being returned and whether that is "best."
                Remember that with generics you have two types per object: the
                apparent type and the actual type. In an assignment statement
                the apparent type is on the left and the actual type on the
                right:
                ApparentType<T> variable = new ActualType<>;
                for example:
                AbstractList<String> myList = new ArrayList<>;
                A method signature specifies the apparent type.
                We make the distinction so that a method or class can change the
                type that it actually uses (the actual type) without
                necessitating any changes to any code elsewhere. This is a type
                of loose coupling and is good coding practice.
                The apparent type is the one presented to the wider world and
                needs to be as high up the ontology of Collections as is
                practicable: remember the higher up, the more generic and the
                more flexible but at the cost of fewer methods and therefore
                utility.
                The actual type is he implementation and needs to be as far down
                the ontology of Collections as is practicable: making use of the
                implementation-specific advantages of a particular Collection.
                There about a million trillion classes and interfaces in the
                Java collections, so be prepared to spend a long time looking
                for the "best" choices.
        */

        /* TODO Look at this page especially the 'potential errors'
                https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html
                You don't need to worry too much about the concept of Exceptions
                at this stage but what you do need to think about what different
                things can go wrong when trying to read a file and why not just
                testing for them is important but why the order in which they
                are tested is critical.
        */

        /* This is a try-with-resources statement
           https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
           There are about a million trillion Java classes for reading and
           writing files. It is hugely confusing, hence I've provided the way
           for how to attach a String specifying a filename to a class that can
           *parse* input. One reason there are so many file Input/Ouput
           (abbreviated I/O or IO) Java classes is it depends on how you want to
           process that input because there are layers of sophistication that
           can be added. Scanner is a high-level one, so it offers sophisticated
           features such as providing the next floating point number. This
           convenience comes at the cost of execution speed. For tasks where you
           want to read the 'raw' input, there are lower-level classes that have
           fewer features than Scanner but more execution speed.
        */

        try ( final Scanner sc = new Scanner(new File(dictionaryFileName))) {
            while ( sc.hasNextLine() ) {
                String line = sc.nextLine().trim();
            /* TODO Study the sequence of statements carefully and think why
                    they are in this order.
            */


                if (verbose){
                    System.out.println("Processing line: " + line);
                }
                if (line.isEmpty()){
                    continue;
                }

                line = line.replaceAll("[^a-zA-Z0-9\\s]+", " ");

                String[] wordsInLine = line.split("\\s+");

                for (String word : wordsInLine){
                    if (!word.isEmpty()){
                        if (verbose){
                            System.out.println("Adding word: " + word);
                        }
                        words.add(word);
                    }
                }
                // TODO First get this working with input that is one word per line.
                /* TODO Second try it with input with multiple words per line
                        that need splitting:
                        This necessitates making the processing algorithm more
                        sophisticated. This means working your way through the
                        files in the input directory by setting the filename
                        parameter accordingly; or copying the contents of a
                        provided input file into another file that you always
                        read from. Remember to update the IntelliJ configuration:
                        Run > Edit Configurations...
                        so you can specify command-line parameters and
                        redirecting input from a file and saving the console
                        output to another file
                */
                /* TODO Note that 00-empty.txt is literally a file with no
                        content. You definitely don't want your program to crash
                        just because there is no input.
                */
                /* TODO Third before splitting, replace all the punctuation with
                        either a space or nothing (try each).
                        A more advanced version is to treat different
                        punctuation differently. You can try that but for this
                        assignment we'll stick to simply deleting punctuation
                        and closing our eyes to the noisy data that causes.
                 */
                /* TODO Make sure you program isn't defeated by having spaces at
                    the beginning or end of a line:
                        if your program is beaten by having whitespace at the
                        start of a line, your coding is going to look lame.
                */
                /* TODO Can you optimise anything such as avoiding doing too
                        much processing lines that are empty or only contain
                        whitespace?
                */
                /* TODO How are you handling "duplicates" as in words you've
                        seen before? There's no right or wrong answer at this
                        stage but it needs considering.
                */
                // TODO Make use of the verbose parameter to print out what is happening
                /* TODO Change the verbose parameter from a boolean to something
                        in VerbositySimple or Verbosity then ripple the changes
                        of this throughout this method.
                */
                /* TODO If you have time, it is worth investigating regular
                        expressions as these are really powerful for helping you
                        split the line into words and remove unwanted characters
                        (or maybe it's best to specify the characters you wish
                        to keep: there's more than one way to do it). Start with
                        https://regex101.com/ but make sure your browser window
                        is large enough that you can see the left-hand menu to
                        set the type of regex to be Java 8. Bear in mind that
                        Java requires some characters in regular expressions to
                        have an extra \ in front because of the way Java
                        processes Strings. You get used to it but it can be
                        massively confusing to learn.
                */
            }

            /* You will often see the bad practice of
               catch Exception e
               This is bad because it is so generic that it only tells you
               something went wrong but not what. Look again at the official
               Java documentation about the advantages of Exceptions and notice
               not just the list of Exceptions handled in the example but the
               sequence of them: as with switch statements, testing is processed
               in the order specified, so a more generic Exception that appears
               in the list before a more specific one will match the generic one
               and never reach the specific Exception.
            */
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        }
        if(verbose){
            System.out.println("Finished reading dictionary.");
        }
        return words;
    }
    public static void main(String[] args){
        readDictionary("input/01-one-word-per-line.txt", true);
    }
}
