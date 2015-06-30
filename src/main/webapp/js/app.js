var app = angular.module('app', [])

app.controller('BeverageController', function ($scope, $http) {
    $scope.total = 0;
    $scope.size_total = 0;
    $scope.syrup_total = 0;
    $scope.extra_total = 0;
    $scope.drink = null;
    $scope.message = "Order!!!";
    $http.get('/beverages').
        success(function (data) {
            $scope.beverages = data;
            $scope.drink = null;
            $scope.size = null;
            $scope.syrup = null;
            $scope.extra = null;
        });

    $http.get('/beverages/syrups').
        success(function (data) {
            $scope.syrups = data;
        });

    $scope.order = function () {
        var dataObj = {
            "beverage": $scope.drink.name,
            "size": $scope.size,
            "syrup": $scope.syrup,
            "extra": $scope.extra
        };
        var res = $http.post('/order', dataObj);
        res.success(function (data, status, headers, config) {
            $scope.message = "Order is taken, Enjoy it!!!";
        });
        res.error(function (data, status, headers, config) {
            alert("failure message: " + JSON.stringify({data: data}));
        });
    };

    $scope.addBeverage = function () {
        $scope.total = $scope.drink.price;
    };

    $scope.changeSize = function () {
        $http.get('/price/size/' + $scope.size).
            success(function (data) {
                if ($scope.size_total != 0) {
                    $scope.total -= $scope.size_total;
                    $scope.size_total = 0;
                }
                $scope.size_total = parseFloat(data);
                $scope.total += $scope.size_total;

            });
    };
    $scope.changeSyrup = function () {
        $http.get('/price/syrup/' + $scope.syrup).
            success(function (data) {
                if ($scope.syrup_total != 0) {
                    $scope.total -= $scope.syrup_total;
                    $scope.syrup_total = 0;
                }
                $scope.syrup_total = parseFloat(data);
                $scope.total += $scope.syrup_total;

            });
    };

    $scope.changeExtra = function () {
        $http.get('/price/extra/' + $scope.extra).
            success(function (data) {
                if ($scope.extra_total != 0) {
                    $scope.total -= $scope.extra_total;
                    $scope.extra_total = 0;
                }
                $scope.extra_total = parseFloat(data);
                $scope.total += $scope.extra_total;

            });
    };
});
