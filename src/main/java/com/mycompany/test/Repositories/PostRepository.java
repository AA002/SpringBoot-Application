package com.mycompany.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.test.Entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
