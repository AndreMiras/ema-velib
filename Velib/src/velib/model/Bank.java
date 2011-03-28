package velib.model;

import java.util.Date;

public class Bank
{
     private long id;
     private String numero;
     private Date dateExpiration;
    private String cardHolder;
     private String codeVerif;
    
    public Bank(long id, String numero, String cardHolder, String codeVerif)
    {
        this.id=id;
        this.numero=numero;
        this.cardHolder=cardHolder;
        this.codeVerif=codeVerif;
        dateExpiration = new Date();
    }

    public Bank()
    {
        this(0, "", "", "");
    }
    
    public long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCodeVerif() {
        return codeVerif;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getIdentifiant() {
        return cardHolder;
    }

    public String getNumero() {
        return numero;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

   

    @Override
    public String toString()
    {
        return numero;
    }

     

}
