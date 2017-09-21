
// Problem 4 - Singleton Pattern Implementation 
public class SingletonPattern {

    private static SingletonPattern instance;

    private SingletonPattern() {
        // needed so that object can be feteched by getInstance only
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }

        return instance;
    }
}

