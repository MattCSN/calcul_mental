var angularApp = angular.module('calc', []);

angularApp.factory('UtilisateurWS', ['$resource', function ($resource) {
    return $resource('user/:id', null,
        {
            'update': {method: 'PUT'}
        });
}]);


