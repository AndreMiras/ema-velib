package velib.model;

import sun.security.util.Password;

public class User implements IModel {

    private long user_id;
    private String identifiant;
    private String password;
    private String questionSecrete;
    private String reponseSecrete;

    public User()
    {
        this.user_id = 0;
        this.password = "";
        this.identifiant="";
    }   

    public User(long id, String identifiant, String password) {
        this.user_id = id;
        this.identifiant=identifiant;
        this.password = password;
    }

    public long getUserId()
    {
        return user_id;
    }

    public void setUserId(long user_id)
    {
        this.user_id = user_id;
    }

    public String getIdentifiant()
    {
        return identifiant;
    }

    public void setIdentifiant(String identifiant)
    {
        this.identifiant = identifiant;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return identifiant;
    }

    public String getQuestionSecrete()
    {
        return questionSecrete;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }


    public String getReponseSecrete()
    {
        return reponseSecrete;
    }

    public void setReponseSecrete(String reponseSecrete) {
        this.reponseSecrete = reponseSecrete;
    }

    


}
