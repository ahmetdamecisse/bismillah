var tps = 1000; // Temps d'attente entre chaque défilement (en ms)
var pas = 2; // Pas du défilement (en px)
var vit = 50; // Vitesse du défilement (en ms) (1 pas toutes les vit ms)
 
var cur_news = 0; // Numéro de la news en cours/ciblée
var news; // Element div scrollant encadrant les news
var target; // Offset Top de la news ciblée
 
function defil() { // Fonction de défilement
    news.scrollTop = parseInt(news.scrollTop,10) + pas; // On fait défiler le div
    if((news.scrollTop < target) && ((news.scrollTop+news.offsetHeight)<news.scrollHeight)) { // Si on n'a pas encore atteint la news ciblée et qu'on n'est pas encore en bas
        setTimeout(defil,vit); // On relance la fonction
    } else { // Sinon
        cur_news++; // On passe à la news suivante
        if(cur_news >= news.getElementsByTagName("p").length) { // Si on est à la dernière news
            cur_news = 0; // On revient à la première
            setTimeout(function() { // Et on relance la fonction, en repartant du haut
                news.scrollTop = 0;
                defil();
                },tps);
        } else { // Sinon
            setTimeout(defil,tps); // On relance la fonction
        }
        target = news.getElementsByTagName("p")[cur_news].offsetTop-10; // On met à jour l'offset de la news ciblée
    }
}
 
window.onload=function() { // Au chargement (initialisation)
news = document.getElementById("news"); // On récupère l'élément div
target = news.getElementsByTagName("p")[cur_news].offsetTop-10; // On récupère l'offset de la news ciblée
defil(); // On démarre le défilement
};

