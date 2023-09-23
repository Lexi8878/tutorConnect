package model;

public abstract class User {
    protected String username;
    protected String realName;
    protected String school;
    protected String subject;

    public User(String username, String realName, String school, String subject) {
        this.username = username;
        this.realName = realName;
        this.school = school;
        this.subject = subject;
    }
}
