# SCI_Billes
### Nicolas CACHERA et Samuel Grandsir

Notre application simule un déplacement de billes dans un environnement discret. 

Ces billes agissent l'une après l'autre dans un ordre aléatoire, une fois par tour, et peuvent entrer en collision avec les bords de l'environnement (si celui-ci n'est pas torique) ou avec une autre bille. En effet, lorsqu'une bille doit prendre une décision, elle vérifie si une bille se trouve dans sa case de destination ou si cette case de destination sort de l'environnement et provoque une collision dans l'un de ces deux cas. Lors d'une collision entre deux billes, la bille ayant provoqué cette collision donne sa direction à la seconde tandis qu'elle oppose sa direction mais ne bouge pas ce tour-ci.

##### Pour compiler :
* javac ./billes/*.java

##### Pour créer le jar :
* jar cvfe Billes.jar billes.Simulation ./billes/*.class

##### Pour exécuter :
* java -jar Billes.jar <nb_cases_largueur> <nb_cases_hauteur> <taille_billes> <toric (true/false)> <latence en ms> <nb_billes> [<nb_tours>]

