/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

/**
 *
 * @author andre
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import velib.model.Client;
import com.developpez.bean.Langage;
import com.developpez.dao.AbstractDAOFactory;
import com.developpez.dao.DAO;
import com.developpez.dao.FactoryType;

public class ClientDAO extends DAO<Client> {

	public Client create(Client obj) {

		try {

			//Si le langage n'existe pas en base, on le créé
			if(obj.getLangage().getId() == 0){
				DAO<Langage> langageDAO = AbstractDAOFactory    .getFactory(FactoryType.DAO_FACTORY)
                                                                              .getLangageDAO();
				obj.setLangage(langageDAO.create(obj.getLangage()));
			}
			//Vu que nous sommes sous postgres, nous allons chercher manuellement
			//la prochaine valeur de la séquence correspondant à l'id de notre table
            ResultSet result = this	.connect
                                    .createStatement(
                                    		ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                    		"SELECT NEXTVAL('developpeur_dev_id_seq') as id"
                                    );
			if(result.first()){
				long id = result.getLong("id");
                PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                            			"INSERT INTO developpeur (dev_id, dev_nom, dev_prenom, dev_lan_k)"+
                                            			"VALUES(?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
				prepare.setString(2, obj.getNom());
				prepare.setString(3, obj.getPrenom());
				prepare.setLong(4, obj.getLangage().getId());

				prepare.executeUpdate();
				obj = this.find(id);

			}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}

	public Developpeur find(long id) {

		Developpeur dev = new Developpeur();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM developpeur WHERE dev_id = " + id
                                     );
            if(result.first())
                    dev = new Developpeur(
                                        	id,
                                        	result.getString("dev_nom"),
                                        	result.getString("dev_prenom"),
                                        	new LangageDAO().find(result.getLong("dev_lan_k"))
                                        );

		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return dev;

	}
	public Developpeur update(Developpeur obj) {

		try{
			DAO<Langage> langageDAO = AbstractDAOFactory    .getFactory(FactoryType.DAO_FACTORY)
                                                                       .getLangageDAO();
			//Si le langage n'existe pas en base, on le créé
			if(obj.getLangage().getId() == 0){
				obj.setLangage(langageDAO.create(obj.getLangage()));
			}
			//On met à jours l'objet Langage
			langageDAO.update(obj.getLangage());

			this.connect
                .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                	"UPDATE developpeur SET dev_nom = '" + obj.getNom() + "',"+
                	" dev_prenom = '" + obj.getPrenom() + "',"+
                	" dev_lan_k = '" + obj.getLangage().getId() + "'"+
                	" WHERE dev_id = " + obj.getId()
                 );

			obj = this.find(obj.getId());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }

		return obj;
	}


	public void delete(Developpeur obj) {
		try {

			this.connect
                .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE,
                	ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                	"DELETE FROM developpeur WHERE dev_id = " + obj.getId()
                 );

	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}

}