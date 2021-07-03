package com.neonzoff.DemoTreeThymeleaf.dao;

import com.neonzoff.DemoTreeThymeleaf.model.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tseplyaev Dmitry
 */
@Repository
public interface NodeRepository extends CrudRepository<Node,Integer> {
}
