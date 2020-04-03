package billionaires.springbootbillionaires.repositories;

import billionaires.springbootbillionaires.entities.Billionaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface BillionaireRepository extends CrudRepository<Billionaire, Long> {

    }


