import java.util.*;
import java.io.*;

/*
TreeSet
Keeps the elements sorted and prevents duplicates.

$ HashMap
Lets you store and access elements as name/value pairs.

$ LinkedList
Makes it easy to create structures like stacks or queues.

$ HashSet
Prevents duplicates in the collection, and given an element, can find that element in the collection quickly.

$ LinkedHashMap
Like a regular HashMap, except it can remember the order in which elements (name/value pairs) were inserted, or it can be configured to remember the order in which elements were last accessed.
----------
This:
    public <T extends Animal> void takeThing(ArrayList<T> list) // Here we can use <T> because we declared "T" earlier in the method declaration.
Is NOT the same as this:
    public void takeThing(ArrayList<Animal> list)

The first one, where <T extends Animal> is part of the method declaration,
means that any ArrayList declared of a type that is Animal, or one of Animal’s subtypes (like Dog or Cat), is legal.
So you could invoke the top method using an ArrayList<Dog>, ArrayList<Cat>, or ArrayList<Animal>.

But... the one on the bottom, where the method argument is (ArrayList<Animal> list) means that only an ArrayList<Animal> is legal.
In other words, while the first version takes an ArrayList of any type that is a type of Animal (Animal, Dog, Cat, etc.),
the second version takes only an ArrayList of type Animal. Not ArrayList<Dog>, or ArrayList<Cat> but only ArrayList<Animal>.
----------
public static <T extends Comparable<? super T>> void sort(List<T> list)

"T extends Comparable" = This says "Whatever 'T' is must be of type Comparable."
"? super T" = it just means that the type parameter for Comparable must be of type T or one of T's supertypes
"List<T>" = You can pass in only a List (or subtype of list, like ArrayList) that uses a parameterized type that "extends Comparable".
----------
LIST - when sequence matters
Collections that know about index position. Lists know where something is in the list. You can have more than one element referencing the same object.

SET - when uniqueness matters
Collections that do not allow duplicates. Sets know whether something is already in the collection.
You can never have more than one element referencing the same object (or more than one element referencing two objects that are considered equal—we’ll look at what object equality means in a moment).

MAP - when finding something by key matters
Collections that use key-value pairs. Maps know the value associated with a given key.
You can have two keys that reference the same value, but you cannot have duplicate keys.
Although keys are typically String names (so that you can make name/value property lists, for example), a key can be any object.
----------
Reference equality
Two references, one object on the heap.

Object equality
Two references, two objects on the heap, but the objects are considered meaningfully equivalent.
If you want to treat two different Song objects as equal (for example if you decided that two Songs are the same if they have matching title variables), you must override both the hashCode() and equals() methods inherited from class Object.
----------
Java Object Law For HashCode() and equals()

The API docs for class Object state the rules you MUST follow:
$ If two objects are equal, they MUST have matching hashcodes.
$ If two objects are equal, calling equals() on either object MUST return true. In other words, if (a.equals(b)) then (b.equals(a)).
$ If two objects have the same hashcode value, they are NOT required to be equal. But if they’re equal, they MUST have the same hashcode value.
$ So, if you override equals(), you MUST override hashCode().
$ The default behavior of hashCode() is to generate a unique integer for each object on the heap. So if you don’t override hashCode() in a class, no two objects of that type can EVER be considered equal.
$ The default behavior of equals() is to do an == comparison. In other words, to test whether the two references refer to a single object on the heap.
So if you don’t override equals() in a class, no two objects can EVER be considered equal since references to two different objects will always contain a different bit pattern.
a.equals(b) must also mean that a.hashCode() == b.hashCode() But a.hashCode() == b.hashCode() does NOT have to mean a.equals(b)
* */
public class Jukebox {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList); // This is where it breaks! It worked fine when passed in an ArrayList<String>, but as soon as we tried to sort an ArrayList<Song>, it failed.
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare(); // custom comparator
        Collections.sort(songList, artistCompare);
        System.out.println(songList);

        // HashSet has a simple addAll() method that can take another collection and use it to populate the HashSet. It's the same as if we added each song one at a time (except much simpler).
        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);

        // And if we want the set to stay sorted, we’ve got TreeSet
        TreeSet<Song> songSet = new TreeSet<Song>(); // Instantiate a TreeSet instead of HashSet. Calling the no-arg TreeSet constructor means the set will use the Song object's compareTo() method for the sort. (We could have passed in a Comparator.)
        songSet.addAll(songList);
        System.out.println(songSet);
    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}

// Usually these match...we’re specifying the type that the implementing class can be compared against. This means that Song objects can be compared to other Song objects, for the purpose of sorting.
class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    // The sort() method sends a Song to compareTo() to see how that Song compares to the Song on which the method was invoked.
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    // The HashSet (or anyone else calling this method) sends it another Song.
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    // Same deal here... the String class has an overridden hashCode() method, so you can just return the result of calling hashCode() on the title. Notice how hashCode() and equals() are using the SAME instance variable.
    public int hashCode() {
        return title.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }
}

class ArtistCompare implements Comparator<Song> {
    public int compare(Song one, Song two) {
        return one.getArtist().compareTo(two.getArtist());
    }
}