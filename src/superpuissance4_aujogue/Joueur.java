
package superpuissance4_aujogue;

public class Joueur {
    String nom;
    String couleur;
    Jeton listejetons [] = new Jeton [21];
    int nbDesintegrateurs;
    int nbJetonsRestants;
    
public void Joueur (String unNom){
    nom = unNom;    
}

public void affecterCouleur (String uneCouleur){
    couleur = uneCouleur;
}

public boolean ajouterJeton (Jeton JetonAPoser){
    if (nbJetonsRestants<21){
        listejetons[nbJetonsRestants] = JetonAPoser;
        nbJetonsRestants++;
        return true;
    }else{
        return false;
    }
}    

public void obtenirDesintegrateur (){
    nbDesintegrateurs = nbDesintegrateurs + 1;
}

public boolean utiliserDesintegrateur (){
    if (nbDesintegrateurs > 0){
        nbDesintegrateurs = nbDesintegrateurs - 1;
        return true;
    } else{
        return false;
    }
}
}
