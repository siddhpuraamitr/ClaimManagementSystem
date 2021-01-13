package claim.management.system.crudrestfulwebservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import claim.management.system.crudrestfulwebservice.exception.ResourceNotFoundException;
import claim.management.system.crudrestfulwebservice.model.Claim;
import claim.management.system.crudrestfulwebservice.repository.ClaimRepository;

@RestController
@RequestMapping("/api/v1")
public class ClaimController {

	@Autowired
	private ClaimRepository claimRepository;
	
	//create get all claims api
	@GetMapping("/claims")
	public List<Claim> getAllClaims(){
		return claimRepository.findAll();
	}
	
	//create claim
	@PostMapping("/claims")
	public Map<String, String> createClaim(@Valid @RequestBody Claim claim) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("Claim = "+claim);
		map.put("claimNumber", claimRepository.save(claim).getClaimNumber());
		return map;
	}
	
	//get claim by id
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable(value = "id") long claimId) throws ResourceNotFoundException{
		Claim claim = claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: "+claimId));
		return ResponseEntity.ok().body(claim);
		
	}
	
	//update claim
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable(value = "id") long claimId,
			@RequestBody Claim claimDetails) throws ResourceNotFoundException {
		Claim claim = claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: "+claimId));
		claim.setAmount(claimDetails.getAmount());
		claim.setClaimId(claimDetails.getClaimId());
		claim.setDateCreated(claimDetails.getDateCreated());
//		claim.setDocs(claimDetails.getDocs());
		claim.setPolicyNumber(claimDetails.getPolicyNumber());
		claim.setUserName(claimDetails.getUserName());
		claimRepository.save(claim);
		return ResponseEntity.ok().body(claim);
	}
	
	//delete claim by id
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<Claim> deleteClaim(@PathVariable(value = "id") long claimId)  throws ResourceNotFoundException {
		claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: "+claimId));
		claimRepository.deleteById(claimId);
		return ResponseEntity.ok().build();
		
	}
}
