package billionaires.springbootbillionaires.service;

import billionaires.springbootbillionaires.entities.Billionaire;
import billionaires.springbootbillionaires.repositories.BillionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BillionaireService {
    private final BillionaireRepository billionaireRepository;

    @Autowired
    public BillionaireService(BillionaireRepository billionaireRepository) {
        this.billionaireRepository = billionaireRepository;
    }
   public List<Billionaire> sortBillionaires(){
        return billionaireRepository.findAll(Sort.by(Sort.Direction.DESC,"networth"));
   }
   public void saveBillionaire(Billionaire billionaire){
        billionaireRepository.save(billionaire);
   }
   public Billionaire findBillionaire(long id){
      return billionaireRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid billionaire Id:" + id));
   }
   public void deleteBillionaire(Billionaire billionaire){
        billionaireRepository.delete(billionaire);
   }
}