package com.edusite.dao.custom;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.edusite.entity.Student;

@Repository
@Component

public interface TeacherCustomDAO {
	Optional<List<Student>> getByStudent(int employeeId);
}
