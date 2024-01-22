package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.repository;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer> {
}
