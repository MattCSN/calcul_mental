var angularApp = angular.module('calc', ['ngResource']);

angularApp.factory('UtilisateurWS', ['$resource', function ($resource) {
    return $resource('user/:id', null,
        {
            'update': {method: 'PUT'}
        });
}]);


