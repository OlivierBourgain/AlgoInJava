package com.obourgain.algo.tortoiseandhare;

/**
 * Implémentation de l'algorithme de Floyd de détection de cycle.
 * Egalement appelé 'algorithme du lièvre et de la tortue'.
 */
public class TurtoiseAndHare {

   /**
    * Vérifie s'il existe un cycle dans la liste chainée passée en paramètre.
    * 
    * @param root
    *           La racine de la liste.
    * @return true si la liste contient un cycle, false sinon.
    */
   public boolean containsLoop(Node root) {
      Node tortue = root.getNext();
      Node lievre = root.getNext().getNext();

      while (tortue != lievre) {
         if (lievre == null || lievre.getNext() == null) return false;
         tortue = tortue.getNext();
         lievre = lievre.getNext().getNext();
      }
      return true;
   }

   /**
    * Recherche d'un cycle dans une liste chainée.
    * 
    * @param root
    *           La racine de la liste.
    * @return "No loop" si aucun cycle n'est détecté, sinon
    *         les valeurs de lambda et mu.
    */
   public String checkLoop(Node root) {

      Node tortue = root.getNext();
      Node lievre = root.getNext().getNext();

      // Recherche de la boucle
      while (tortue != lievre) {
         if (lievre == null || lievre.getNext() == null) return "No loop";
         tortue = tortue.getNext();
         lievre = lievre.getNext().getNext();
      }

      // A ce stade, la tortue est à la position i,
      // et le lièvre à la position 2*i.
      // On sait que i = k * lambda.

      // Pour trouver mu, on fait repartir la tortue du début de la liste.
      // Lorsque la tortue sera en position mu,
      // le lievre sera en position
      // 2 * i + mu
      // = 2 * k*lambda + mu

      int mu = 0;
      tortue = root;
      while (tortue != lievre) {
         tortue = tortue.getNext();
         lievre = lievre.getNext();
         mu++;
      }

      // Pour trouver lambda, on laisse le lievre faire un tour dans le cycle
      int lambda = 1;
      lievre = lievre.getNext();
      while (tortue != lievre) {
         lievre = lievre.getNext();
         lambda++;
      }

      return "lambda = " + lambda + ", mu = " + mu;

   }
}
