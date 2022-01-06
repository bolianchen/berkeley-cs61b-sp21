package capers;

import java.io.File;
import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD, ".capers");

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    static final File STORY_FILE = Utils.join(CAPERS_FOLDER, "story");
    static final File DOG_FOLDER = Utils.join(CAPERS_FOLDER, "dogs");

    public static void setupPersistence() {
        // TODO
        CAPERS_FOLDER.mkdir();
        try {
            STORY_FILE.createNewFile();
        } catch (Exception error) {
            System.out.println(".capers/story folder already exists");
        }
        DOG_FOLDER.mkdir();
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // TODO
        String story = Utils.readContentsAsString(STORY_FILE);
        if (!story.isEmpty()) {
            story = story + "\n" + text;
        } else {
            story = text;
        }
        System.out.println(story);
        Utils.writeContents(STORY_FILE, story);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog d = new Dog(name, breed, age);
        System.out.println(d);
        File outFile = Utils.join(DOG_FOLDER, name);
        try {
            outFile.createNewFile();
        } catch (Exception error) {
            System.out.println("dog " + name + "already exists");
        }
        Utils.writeObject(outFile, d);
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        //File inFile = Utils.join(DOG_FOLDER, name);
        //Dog d = Utils.readObject(inFile, Dog.class);
        Dog d = Dog.fromFile(name);
        d.haveBirthday();
        //Utils.writeObject(inFile, d);
        d.saveDog();
    }
}
