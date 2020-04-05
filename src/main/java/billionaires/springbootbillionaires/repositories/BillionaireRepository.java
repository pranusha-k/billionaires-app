package billionaires.springbootbillionaires.repositories;

import billionaires.springbootbillionaires.entities.Billionaire;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface BillionaireRepository extends CrudRepository<Billionaire, Long> {

        public List<Billionaire> findAll(Sort sort);

    }


