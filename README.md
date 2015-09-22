# SCI_Billes
### Nicolas CACHERA et Samuel GRANDSIR

Cette application a pour but de simuler le comportement de particules (ou billes) dans un environnement 2D discret.

Les billes sont des agents qui se déplacent dans huit directions. Pour ce faire, nous avons donné deux vitesses à chaque bille : une en X et une en Y. La valeur de ces vitesses (entre -1 et 1) correspond au nombre de cases dont la bille va se déplacer en un tour dans l'axe correspondant. -1 correspond donc à une case vers la gauche (X) ou le haut (Y), 0 à aucun deplacement et 1 à une case vers la droite (X) ou le bas (Y). 

L'environnement est un tableau 2D discret ne pouvant pas contenir plus d'un agent dans une case. Ce tableau peut être torique ou non en fonction du choix de l'utilisateur.

A l'initialisation, toutes les billes sont ajoutées à l'environnement dans une case aléatoire non occupée. Elles ont aussi leurs vitesses attribuées aléatoirement. A chaque tour, la liste des agents est mélangée et chaque agent prendra une décision et effectuera une action chacun leur tour. Toutes les billes vont donc effectuer le même nombre d'action dans une simulation.

Lors de la prise de décision, l'agent va regarder la case où il est censé aller :
* Si cette case est vide il y va. 
* Si elle est hors-limite et que l'environnement est torique, l'agent se retrouve du côté opposé de l'environnement 
* Si elle est hors-limite et que l'environnement est non torique, l'agent rebondit contre un mur en opposant sa vitesse en X si le mur est vertical, en Y si il est horizontal, dans les deux si c'est un coin.
* Si la case contient un autre agent, il va prévenir cet agent de la collision puis, une fois que cet agent aura pris en compte cette collision, opposera sa vitesse en X et en Y. Il ne bouge pas ce tour.

Lorsqu'un agent est prévenu d'une collision provoquée par un autre agent, il la prend en compte en prenant la vitesse en X et en Y de cet agent, peut importe ses vitesses initiales.

##### Pour compiler :
* javac ./billes/*.java

##### Pour créer le jar :
* jar cvfe Billes.jar billes.Simulation ./billes/*.class

##### Pour exécuter :
* java -jar Billes.jar <nb_cases_largueur> <nb_cases_hauteur> <taille_billes> <toric (true/false)> <latence en ms> <nb_billes> [<nb_tours>]

##### Exemple :
* java -jar Billes.jar 50 50 10 false 1000 20 100 : Environnement non torique de 50 sur 50 cases de 10 pixels de côté contenant 20 billes. L'environnement fait 500 pixels sur 500 pixels. La simulation dure 100 tours et attends 1000 ms entre chaque tour.
* java -jar Billes.jar 50 50 10 false 1000 20 : Environnement non torique de 50 sur 50 cases de 10 pixels de côté contenant 20 billes. L'environnement fait 500 pixels sur 500 pixels. La simulation ne s'arrête jamais et attends 1000 ms entre chaque tour.
