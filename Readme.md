# Bank
****
*Réalisation d'un projet personnel graphique à l'aide d'une collection de comptes et 
de transactions bancaires*

*Ce fichier sera suivi complété oar un diagramme UML au format plantUML ainsi que par des schémas
et esquisses qui montreront l'idée genéral ainsi que son développement.*

***
## Cahier des Charges

+ **Affichage globale** -> Affiche une collection plus ou moins grande pour visualiser tous les elements
+ **Affichage ciblé** -> Affiche un élément de la collection à visualiser (voir tous les détails)
+ **Fonction d'ajout** -> Permet d'ajouter d'un ou plusieurs objet(s) dans la collection
+ **Fonction de suppression** -> Permet de supprimer un ou plusieurs objet(s) dans la collection
+ **Fonction de modification** -> Permet de modifier les données d'un ou plusieurs objet(s) dans la collection
+ **Import/Export** -> On peut importer une collection depuis un fichier ainsi que l'exporter
+ **Option de Filtrage** -> Permet de filtrer la collection
+ **Option de Tri** -> Permet de trier la collection
    >*Le tri et le filtre doivent être complémentaire et non supérieur l'un à l'autre !*
+ **Touche Personnel** -> Ajout d'une fonctionnalité non-trivial

***
## Phase de développement 
**I.** Configuration de l'interface **Projet Structure > libraries** ainsi que les paramètres de javaFx tel 
que **Edit configuration > Application** pour faire démarrer correctement l'interface graphique de l'application 
bancaire en cours de développement.
+ *AJout d'un Icon personnalisé*
+ *Fond avec le logo de l'application mis en commentaire pour des raisons de fonctionnalités*

**II.**
Implémentation des classes de type modele : 
+ **Transaction** *(montant, date, libelle, categorie)*
+ **Compte** *(iban, solde, transactions)*
+ **Client** *(id, nom, prenom, dateNaissance, comptes)* **OU**  
**Client** *(id, nom, prenom, dateNaissances, comptes, adresse, email, telephone)* 
  >La classe **Client** contient deux constructeurs qui permettent d'ajouter des informations complémentaires ou non
+ **Banque** *(nom, clients)*

Ainsi, il y a aussi le maintient à jour du diagramme UML pour les classes de modèles.


**III.**  
1. Implementation des interfaces 'XxxxViewModel' :
* **TransactionViewModel**
* **CompteViewModel**
* **ClientDetailsViewModel**
* **BanqueViewModel**
2. Implementation des interfaces 'XxxxViewModel' les classes 'StubXxxxViewModel' :
+ **StubTransactionViewModel**
+ **StubCompteViewModel**
+ **StubClientDetailsViewModel**
+ **StubBanqueViewModel**
>*Toutes les classes et interfaces sont pensées pour être structurée et simple à comprendre en cas d'erreur.*

**IV.**
*Début de l'implémentation du menu **File** dans la classe **MenuView**.*
