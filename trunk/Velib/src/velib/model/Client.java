package velib.model;

import java.util.Date;

public class Client extends User {
    private long client_id;
    private String firstname;
    private String lastname;
    private Date dateNaissance;
    private String adresse;
    private long codePostal;
    private String ville;

    private Subscription abonnement;

    /*
     * plusieurs clients peuvent avoir la meme carte mais on considere qu'un
     * client n'a qu'une carte
     */
    private Bank banque;


    public Client()
    {
    }

    public Client(long idClient, String firstname, String lastname, User user)
    {
        super(user.getUserId(), user.getIdentifiant(), user.getPassword());
        this.setQuestionSecrete(user.getQuestionSecrete());
        this.setReponseSecrete(user.getReponseSecrete());
        this.client_id = idClient;
        this.firstname = firstname;
        this.lastname = lastname;
        
        this.dateNaissance = new Date();
        this.abonnement = new Subscription();
        this.banque = new Bank();
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getFullName()
    {
        return firstname + " " + lastname;
    }

    public String getAdresse() {
        return adresse;
    }

    public long getCodePostal() {
        return codePostal;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    

    public long getClientId() {
        return client_id;
    }


    public Subscription getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Subscription abonnement) {
        this.abonnement = abonnement;
    }


    public Bank getBanque() {
        return banque;
    }

    public void setBanque(Bank banque) {
        this.banque = banque;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(long codePostal) {
        this.codePostal = codePostal;
    }
    




    @Override
    public String toString()
    {
        return getFullName();
    }

    public User getUser()
    {
        return this;
    }

    public void setUser(User user)
    {
        setUserId(user.getUserId());
        setIdentifiant(user.getIdentifiant());
        setPassword(user.getPassword());
    }

    /*
    @Override
    public int getId()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
     * 
     */
}
