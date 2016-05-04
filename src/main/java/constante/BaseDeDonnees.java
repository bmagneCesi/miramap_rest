package constante;

public enum BaseDeDonnees {
	
	//TODO user et mdp a remplir
    URL ("jdbc:mysql://localhost/miramap"), 
    USER (""),  
    PASSWD   ("") ;  



    private final String bdd;

    private BaseDeDonnees(String bdd) {
        this.bdd = bdd;
    }
    
    public String getBdd() {
        return this.bdd;
    }
}
