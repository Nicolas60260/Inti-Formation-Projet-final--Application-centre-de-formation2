package com.intiFormation.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Prospect;
import com.intiFormation.entity.Commercial;




public interface IappelDao extends JpaRepository<Appel, Integer>{
	public List<Appel> findByProspect(Prospect prospect);
	public Appel findByCommentaire(Commentaire commentaire);
	
	public List<Appel> findByCommentaireIsNull();
	
	public List<Appel> findByCommercial(Commercial commercial);
	
}
