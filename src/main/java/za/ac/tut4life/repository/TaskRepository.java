package za.ac.tut4life.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut4life.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

