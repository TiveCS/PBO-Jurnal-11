package pbo.mod.pkg11;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.time.LocalDate;

public class Email implements Email_IO, Serializable {

    private int id;
    private String sender;
    private String subject;
    private String content;
    private LocalDate date;
    private boolean starred;

    public Email() {
    }

    public Email(int id, String sender, String subject, String content, LocalDate date, boolean starred) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.starred = starred;
    }

    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                ", starred=" + starred +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    @Override
    public void save(ObjectOutput out) throws IOException {
        out.writeObject(this);
        out.flush();
    }

    @Override
    public void load(ObjectInput input) throws IOException, ClassNotFoundException {
        Object obj = input.readObject();
        Email e = (Email) obj;

        setId(e.id);
        setContent(e.content);
        setSubject(e.subject);
        setSender(e.sender);
        setDate(e.date);
        setStarred(e.starred);
    }
}
