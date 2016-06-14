var miramapApp = angular.module('miramapApp', [
    // Dépendances du "module"
    'ngRoute',
    'miramapAppControllers',
    'ngMap']);

////////////////////////////////    DEBUT INSCRIPTION    /////////////////////////////////////////////

    miramapApp.controller('inscriptionCtrl', function($scope, $http) {

        // Perform the login action when the user submits the login form
        $scope.inscriptionAction = function() {

            var data = 
            {
                "email" : $scope.emailInscription,
                "password" : $scope.passwordInscription,
                "lastname" : $scope.lastnameInscription,
                "firstname" : $scope.firstnameInscription,
                "city" : $scope.cityInscription,
                "phone" : $scope.phoneInscription  
            };
            
            $http({
                method : 'post',
                url : "http://localhost:8080/inscription",
                data : data,
                dataType : 'application/json',
                headers : {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'},
            }).success(function (data) {

                window.location.href = '#/';
                alert('Bien inscrit ! Vous pouvez vous connecter.');
            
            }).error(function (data) {
            
                console.log(data);

                alert('L\'application n\'a pas pu mettre à jour le contenu : ' + data);

            });
        };

    });

////////////////////////////////    FIN INSCRIPTION    /////////////////////////////////////////////

////////////////////////////////    DEBUT LOGIN    /////////////////////////////////////////////

    miramapApp.controller('loginCtrl', function($scope, $http) {

        // Perform the login action when the user submits the login form
        $scope.inscriptionAction = function() {

            var data = 
            {
                "email" : $scope.emailLogin,
                "password" : $scope.passwordLogin,
            };
            
            $http({
                method : 'post',
                url : "http://localhost:8080/login",
                data : data,
                dataType : 'application/json',
                headers : {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'},
            }).success(function (data) {

                window.location.href = '#/';
                alert('Bien inscrit ! Vous pouvez vous connecter.');
            
            }).error(function (data) {
            
                console.log(data);

                alert('L\'application n\'a pas pu mettre à jour le contenu : ' + data);

            });
        };

    });

////////////////////////////////    FIN LOGIN    /////////////////////////////////////////////

////////////////////////////////    DEBUT ROUTING    /////////////////////////////////////////////

miramapApp.config(['$routeProvider',
    function($routeProvider) { 
        
        // Système de routage
        $routeProvider
        .when('/', {
            templateUrl: 'partials/home.html',
            controller: 'homeCtrl'
        })
        .when('/location', {
            templateUrl: 'partials/location.html',
            controller: 'locationCtrl'
        })
   	    .when('/about', {
            templateUrl: 'partials/about.html',
            controller: 'aboutCtrl'
        })
        .when('/contact', {
            templateUrl: 'partials/contact.html',
            controller: 'contactCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
    }
]);

/**
 * Définition des contrôleurs
 */
var miramapAppControllers = angular.module('miramapAppControllers', []);

// Contrôleur de la page d'accueil
miramapApp.controller('homeCtrl', function($scope) {
    $scope.pageId = 'home';
});

// Contrôleur de la page de localisation des points de vente
miramapApp.controller('locationCtrl', function($scope) {
    $scope.pageId = 'location';
});

// Contrôleur de la page de contact
miramapApp.controller('contactCtrl', function($scope) {
    $scope.pageId = 'contact';
});

////////////////////////////////    FIN ROUTING    /////////////////////////////////////////////
