package za.ac.tut4life.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long taskID;
    @Column(name = "taskName")
    String taskName;
    @Column(name = "taskStartDate")
    Date taskStartDate;
    @Column(name = "taskEndDate")
    Date taskEndDate;
    @Column(name = "taskDescription")
    String taskDescription;
    @Column(name = "taskStatus")
    Boolean taskStatus;


}

