'use strict';

var mainApp = angular.module('inventory', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/generalInformation', {
                    templateUrl: 'inventory/generalInformation.html'

                }).when('/inventory2', {
                    templateUrl: 'inventory/inventory2.html'


                }).when('/inventory', {
                    templateUrl: 'inventory/inventory.html',
                    controller: 'inventoryController'


                }).when('/feesmanagement', {
                    templateUrl: 'inventory/feesmanagement.html'


                }).when('/profile', {
                    templateUrl: 'inventory/profile.html'


                }).when('/studentsmanagement', {
                    templateUrl: 'inventory/studentsmanagement.html'




                }).when('/gamesandsports', {
                    templateUrl: 'inventory/gamesandsports.html'




                }).when('/admin', {
                    templateUrl: 'inventory/admin.html'




                });
            }]);

mainApp.controller('inventoryController', ['$http', '$window', '$scope', function ($http, $window, $scope) {
        $scope.clicktest = function () {
            $window.alert("testing");
        };

        $scope.itemsList = function () {
            // $window.alert("itemcode is "+$scope.itemCode);
            $http({
                url: "/sms/inventory",
                method: "get"
//                    params: {
//                        "itemCode": $scope.itemCode,
//                        "itemName": $scope.itemName,
//                        "reorderPoint": $scope.reorderPoint
//                    }
            }).then(function (result) {
                //$window.alert("ajax success" + result.status + " " + result.data);
                $scope.itemsDataList = result.data;



            }, function (result) {
                // $window.alert("Ajax fail");

            });
        };

        //persisting items code
        $scope.itemSave = function () {
            //$window.alert($scope.cat.categoryName);
            $http({
                url: "/sms/inventory",
                method: "post",
                params: {
                    "itemCode": $scope.itemCode,
                    "itemName": $scope.itemName,
                    "reorderPoint": $scope.reorderPoint,
                    "categoryCode": $scope.cat.categoryCode
                }
            }).then(function (result) {
                // $window.alert("ajax success" + result.status + " " + result.data.message);
                $scope.saveMessage = result.data.message;
                document.getElementById("itemCode").value = "";
                document.getElementById("itemName").value = "";
                document.getElementById("reorderPoint").value = "";
                document.getElementById("categories").value = "";



            }, function (result) {
                // $window.alert("Ajax fail");

            });

        };
        //retrieving item categories
        $scope.categoriesSearch = function () {


            $http({
                url: "/sms/saveCategory",
                method: "get"

            }).then(function (result) {

                // $window.alert(result.data);
                $scope.categories = result.data;



            }, function (result) {
                //$window.alert("Ajax fail");

            });


        };
        //searcing and item code
        $scope.itemSearch = function () {

            var itemCode = document.getElementById("checkoutItemcode").value;
            //$window.alert(itemCode);
            $http({
                url: "/sms/inventorySearch",
                method: "get",
                params: {
                    "code": itemCode

                }
            }).then(function (result) {

                //$window.alert(result.data);
                $scope.singleItem = result.data;



            }, function (result) {
                $window.alert("Ajax fail");

            });


        };
        //searching for item to replenish
        $scope.replenishmentItemSearch = function () {

            var itemCode = document.getElementById("Replenishtemcode").value;
            //$window.alert(itemCode);
            $http({
                url: "/sms/inventorySearch",
                method: "get",
                params: {
                    "code": itemCode

                }
            }).then(function (result) {

                //$window.alert(result.data);
                //$scope.itemInfo = result.data;
                $scope.replenishItemName = result.data.itemName;
                $scope.remaining = result.data.remaining;



            }, function (result) {
                $window.alert("Ajax fail");

            });


        };
          //replenishing action
        $scope.inventoryReplenishment = function () {


            var itemCode = document.getElementById("Replenishtemcode").value;
            //alert(itemCode);
            //exit();
            $http({
                url: "/sms/inventoryReplenishment",
                method: "post",
                params: {
                    "code": itemCode,
                    "itemsToAdd": $scope.unitsToAdd

                }
            }).then(function (result) {
                $scope.saveMessage = result.data.message;

                // $window.alert(result.data);
                document.getElementById("Replenishtemcode").value = "";
                document.getElementById("replenishItemName").value = "";
                document.getElementById("runits").value = "";
                document.getElementById("replenishUnits").value = "";





            }, function (result) {
                $window.alert("Ajax fail");

            });


        };
        //replenishing action
        $scope.inventoryCheckout = function () {


            var itemCode = document.getElementById("checkoutItemcode").value;
            //alert(itemCode);
            //exit();
            $http({
                url: "/sms/inventoryCheckout",
                method: "post",
                params: {
                    "code": itemCode,
                    "unitsToCheckout": $scope.unitsToCheckout

                }
            }).then(function (result) {
                $scope.saveMessage = result.data.message;

                // $window.alert(result.data);
                document.getElementById("checkoutItemcode").value = "";
                document.getElementById("checkoutItemName1").value = "";
                document.getElementById("remainingUnits1").value = "";
                document.getElementById("checkoutUnits1").value = "";





            }, function (result) {
                $window.alert("Ajax fail");

            });


        };


        //saving a category code
        $scope.categorySave = function () {
            $http({
                url: "/sms/saveCategory",
                method: "post",
                params: {
                    "categoryCode": $scope.categoryCode,
                    "categoryName": $scope.categoryName

                }
            }).then(function (result) {
                // $window.alert("ajax success" + result.status + " " + result.data.message);
                $scope.saveMessage = result.data.message;
                document.getElementById("categoryCode").value = "";
                document.getElementById("categoryName").value = "";




            }, function (result) {
                // $window.alert("Ajax fail");

            });

        };






    }]);

