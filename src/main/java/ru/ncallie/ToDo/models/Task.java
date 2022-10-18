package ru.ncallie.ToDo.models;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String header;
    private String text;

    private LocalDateTime dateCreation;
    private LocalDateTime DateChange;
    private boolean isPin;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    public Task(Long id, String header, String text, User owner) {
        this.id = id;
        this.header = header;
        this.text = text;
        dateCreation = LocalDateTime.now();
        DateChange = LocalDateTime.now();
        this.owner = owner;
    }

    public Task() {
        dateCreation = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        DateChange = LocalDateTime.now();
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        DateChange = LocalDateTime.now();
        this.text = text;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateChange() {
        return DateChange;
    }
    public boolean isPin() {
        return isPin;
    }

    public void setPin(boolean pin) {
        DateChange = LocalDateTime.now();
        isPin = pin;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id) && dateCreation.equals(task.dateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreation);
    }
}
