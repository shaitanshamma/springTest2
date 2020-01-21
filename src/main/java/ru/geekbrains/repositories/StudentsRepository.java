package ru.geekbrains.repositories;

import ru.geekbrains.entities.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {
}
