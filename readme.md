<h1 style="color: #E71D36;">Spring - Prof. Mustapha BELMOKHTAR </h1>
<h2 style="color: #2EC4B6">TP1 ENSAO 2022 - Génie Informtatique 4</h2> 
<h3 style="color: #2EC4B6">EL MESSOUAL EL MEHDI</h3> 
<h3 style="color: #2EC4B6">EL JARRUDI FAYCAL</h3>

<h3 style="color: #FF9F1C;">Spring Beans</h3>

- Database : contien un collection qui represente les données.
- MaterielFactory : instanciation des materiels.
- ChaiseDao : DAO de l'entité chaise.
- LivreDao : DAO de l'entité Livre.
- Services Spring : 
  - GestionMaterielService 
  - GestionChaiseServiceImpl
  - GestionLivreServiceImpl


<h3 style="color: #FF9F1C;">Architecture de projet</h3>

- **/beans** : Contient le context Spring.
- **/Controller** : BL responsable de traiter les entrées de l'utilisateur.
- **/database** : difference DAO des matériels + database.java
- **/modele** : Les POJO des matériels.
- **/service** :
  - /api : les interfaces des differents services.
  - /impl : les implémentaions des services.