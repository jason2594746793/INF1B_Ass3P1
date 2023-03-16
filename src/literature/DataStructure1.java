package literature;

public class DataStructure1 {
    /* TODO A programming system that handles data needs a mechanism of
            collecting, storing, and manipulating data.
            One classic way in Object-Oriented programming is to use an object
            to hold in one place the constituent pieces of data that comprise
            a single element. For example all the attributes that make a student
            in a student-record system.
    */
    /* TODO You need to evolve this class into one suitable for storing the
            pieces of data related to a single word so that usage statistics
            can be processed about this word and some of all of the other words
            in a set of one or more documents. For Part 1, you have free choice
            over how you do this. Have a second attempt using a different
            approach in DataStructure2. Thinking about the same problem in
            different ways is essential in becoming a skilled programmer.
            If you feel you have "solved" this, then consider whether your
            choice of data structure scales to thousands or millions of words.
    */
    /* TODO Think about the data items you need to store and the data structures
            that support this. To achieve that you need to think in advance what
            kinds of operation you might need to support, even though you don't
            yet know what those operations will be. This is a deliberate
            strategy of this assignment: not to "keep you guessing" but to make
            you be flexible. Some data structures support some operations easier
            than others. There might not be a single data structure that does
            everything you want, so think about workarounds, such as temporarily
            using a new data structure to perform an operation and then copying
            the results back. Also think about doing some operations the other
            way round: do you need to make a different attribute the main
            attribute for an operation? Think about the use of special terms in
            a book and what page number they appear on: in particular think
            about a specific instance on a particular page. However the index of
            a book lists each term with an ordered set of all the pages it
            appears on. Multiple instances on the same page don't result in the
            page number being repeated in that particular index item. The page
            numbers also appear sorted ascending.
    */
    /* TODO You need to have a way to store different forms of the same word,
            for example the original form and a normalised form. You need to
            allow code in other classes the functionality to work on each of the
            word forms you store.
    */
    /* TODO If you want to get more advanced with word forms, then research
            stemming https://en.wikipedia.org/wiki/Stemming
            semantic classes
            http://wordnetweb.princeton.edu/perl/webwn?s=set&sub=Search+WordNet&o2=&o0=1&o8=1&o1=1&o7=&o5=&o9=&o6=&o3=&o4=&h=
            Those are advanced topics and won't be covered in this assignment at
            all, so you must NOT pressure yourself to consider them. All you
            need to do is, when pre-processing input, separate words and
            punctuation.
    */
    /* TODO Remember the principles of data hiding, also known as information
            hiding. You rarely want to expose the underlying data structure you
            use because that makes it much harder to change that data structure
            in future because potentially lots of code in other places has been
            written specifically for that data structure. That bad practice is
            known as close coupling. You want loose coupling which is good
            practice. This means that the programmer specifies methods which
            form the only way to interact with the underlying data structure.
            Therefore you need to create getters and setters and probably other
            methods and functions that allow your data structures to be read
            from and written to in a way so that the calling code from another
            class (and ideally within this class) does not need to change at
            all. Sometimes you do have to make changes to the calling code in
            the early days of designing a new program.
     */
}
