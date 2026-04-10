package coreJavaVersion;

public class User {
    int id;
    String name;
    String role;

    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
}
