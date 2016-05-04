package constante;

public enum BaseDeDonnees {
	
    URL ("jdbc:mysql://localhost/miramap"), 
    USER ("root"),  
    PASSWD   ("ggagni42") ;  



    private final String bdd;

    private BaseDeDonnees(String bdd) {
        this.bdd = bdd;
    }
    
    public String getBdd() {
        return this.bdd;
    }
}
