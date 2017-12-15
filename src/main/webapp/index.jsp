<%-- 
    Document   : index
    Created on : Oct 22, 2017, 4:21:23 PM
    Author     : ekaranja
--%>

<%@page import="com.sms.inventorymodels.YesNo"%>
<%@page import="com.sms.inventorymodels.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="smsModule">>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>ISMS</title>

        <meta name="viewport" content="width=device-width" />



        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!--        <link href="assets/css/animate.min.css" rel="stylesheet"/>-->


        <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>



        <link href="assets/css/demo.css" rel="stylesheet" />


        Fonts and icons     
        <!--        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
                <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>-->
        <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />


        <style type="text/css">
            .navbar{
                margin-bottom: 0;
                border-radius: 0;
                /*background-color: #5E4485;*/
                background-color:green;

                padding: 1% 0;
                font-size: 1.2em;
                border: 0;
            }

        </style>
    </head>
    <body ng-controller="inventoryController">
        <% User currentUser = (User) (session.getAttribute("currentSessionUser"));
            if (currentUser == null) {
                currentUser = new User();
            }

        %> 

        <div class="wrapper">
            <div class="sidebar" data-color="red" data-image="" style="margin-top:65px">




                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="" class="simple-text">
                            School Logo
                        </a>
                    </div>

                    <ul class="nav">
                        <li class="active">
                            <a href="#!/generalInformation">

                                <p>General Information</p>
                            </a>
                        </li>

                        <%                            if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getInventoryAccess() == YesNo.YES) {
                        %>
                        <li><a href="#!/inventory">
                                <p>Inventory Management</p>
                            </a>
                        </li>
                        <%
                            }


                        %>

                        <%                            if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getInventoryAccess() == YesNo.YES) {
                        %>
                        <li >
                            <a href="#!/profile">

                                <p>My Profile</p>
                            </a>
                        </li>
                        <%
                            }


                        %>


                        <%                              if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getFeesManagementAccess() == YesNo.YES) {
                        %>
                        <li>
                            <a href="#!/feesmanagement">

                                <p>Fees Management</p>
                            </a>
                        </li>
                        <%
                            }


                        %>


                        <%                                        if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getStudentManagementAccess() == YesNo.YES) {
                        %>
                        <li>
                            <a href="#!/studentsmanagement">

                                <p>Students Management</p>
                            </a>
                        </li>
                        <%
                            }


                        %>

                        <%                                                                if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getGamesAndSportsAccess() == YesNo.YES) {
                        %>

                        <li>
                            <a href="#!/gamesandsports">

                                <p>Games and Sports Management</p>
                            </a>
                        </li>
                        <%
                            }


                        %>
                        <%                            if (currentUser.getUserProfile() != null && currentUser.getUserProfile().getGamesAndSportsAccess() == YesNo.YES) {
                        %>

                        <li>
                            <a href="#!/admin">

                                <p>Admin Panel</p>
                            </a>
                        </li>

                        <%                            }


                        %>




                    </ul>
                </div>
            </div>

            <div class="main-panel">
                <nav class="navbar navbar-default navbar-fixed-top">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#" style="color:#f2e7e7;">Integrated School Management System</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-left " >
                                <li>
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-dashboard"></i>
                                    </a>
                                </li>

                                <li>
                                    <a href="">
                                        <i class="fa fa-search"></i>
                                    </a>
                                </li>
                            </ul>

                            <ul class="nav navbar-nav navbar-right">
                                <%                                                                                      if (currentUser.getUserProfile()
                                            != null) {
                                %>

                                <li>
                                    <a style="color: #F9E9E9">
                                        Logged In As: <%= currentUser.getUserName() + " =>" + currentUser.getUserProfile().getProfileName()%>
                                    </a>
                                </li>

                                <li>
                                    <a href="Logout" style="color: #F9E9E9">
                                        Log Out
                                    </a>
                                </li>
                                <%
                                } else {
                                %>
                                <li>
                                    <a href="" style="color: #F9E9E9" data-toggle="modal" data-target="#loginModal">
                                        Log In
                                    </a>
                                </li>
                                <%
                                    }


                                %>



                                <!--                                <li class="dropdown">
                                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                                        Dropdown
                                                                        <b class="caret"></b>
                                                                    </a>
                                                                    <ul class="dropdown-menu">
                                                                        <li><a href="#">Action</a></li>
                                                                        <li><a href="#">Another action</a></li>
                                                                        <li><a href="#">Something</a></li>
                                                                        <li><a href="#">Another action</a></li>
                                                                        <li><a href="#">Something</a></li>
                                                                        <li class="divider"></li>
                                                                        <li><a href="#">Separated link</a></li>
                                                                    </ul>
                                                                </li>-->
                                <li>
                                    <a href="" style="color: #F9E9E9">
                                        Sign Up
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>


                <div class="content" ng-view>


                </div>


                <footer class="footer">
                    <div class="container-fluid">
                        <nav class="pull-left">
                            <ul>
                                <li>
                                    <a href="#">
                                        System Documentation
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Contact Us
                                    </a>
                                </li>

                            </ul>
                        </nav>
                        <p class="copyright pull-right">
                            &copy; 2017 <a href="http://www.creative-tim.com">Eric Karanja && Dr.Chepken</a>
                        </p>
                    </div>
                </footer>

            </div>
        </div>



        <!--        inventory replenishment Modal -->
        <div id="replenishStockModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!--                 Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Inventory Replenishment</h4>
                    </div>
                    <div class="modal-body">
                           <div class="row alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            {{saveMessage}}
                        </div>
                        <span class="result"></span>
                        
                            <div class="form-group">
                                Item Code:
                                <input type="text" ng-model="replenishCode" id="Replenishtemcode" name="itemCode" ng-blur="replenishmentItemSearch()" class="form-control" required>

                            </div>
                            <div class="form-group"> 
                                Item Name:
                                <input type="text" name="RitemName" id="replenishItemName" ng-model="replenishItemName" class="form-control" readonly="readonly">

                            </div>
                            <div class="form-group">
                                Remaining Units:
                                <input type="number" ng-model="remaining" required name="currentUnits" id="runits" class="form-control" readonly="readonly">

                            </div>
                            <div class="form-group">
                                Units to Add:
                                <input type="number" ng-model="unitsToAdd" id="replenishUnits" name="unitsToAdd" class="form-control" >

                            </div>
                            <div>
                                <button  class="btn btn-primary" ng-click="inventoryReplenishment()">Replenish</button>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>


        <!--        inventory checkout Modal -->
        <div id="inventoryCheckoutModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                Modal content
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Inventory Checkout</h4>
                    </div>
                    <div class="modal-body">
                             <div class="row alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            {{saveMessage}}
                        </div>
                        <span class="result"></span>
                        <!--<form method="post" action="inventory/inventory/checkout"  id="checkoutFormData">-->
                            <div class="form-group">
                                Item Code:
                                <input type="text" ng-model="checkoutItemCode" id="checkoutItemcode" name="itemCode" ng-blur="itemSearch()" class="form-control" required>

                            </div>
                            <div class="form-group"> 
                                Item Name:
                                <input type="text" value="{{singleItem.itemName}}" required name="itemName" id="checkoutItemName1" class="form-control" readonly="readonly">

                            </div>
                            <div class="form-group">
                                Remaining Units:
                                <input type="number" ng-model="checkoutRemainingItems" value="{{singleItem.remaining}}" required name="currentUnits" id="remainingUnits1" class="form-control" readonly="readonly">

                            </div>
                            <div class="form-group">
                                Units to Checkout:
                                <input type="number" id="checkoutUnits1" ng-model="unitsToCheckout" class="form-control" onblur="unitsCompare()" >

                            </div>
                            <div>
                                <button class="btn btn-primary" ng-click="inventoryCheckout()">Checkout</button>
                            </div>



                        <!--</form>-->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
        
        
                <!--Category Addition Modal -->
        <div id="categoryModal" class="modal fade" role="dialog" >
            <div class="modal-dialog">

                <!--                 Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add Category</h4>
                    </div>
                    <div class="modal-body">

                        <div class="row alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            {{saveMessage}}
                        </div>

                        <div class="form-group">
                            Category Code:
                            <input type="text" id="categoryCode" ng-model="categoryCode" class="form-control">

                        </div>
                        <div class="form-group">
                           Category Name:
                            <input type="text" id="categoryName"  ng-model="categoryName" class="form-control">

                        </div>
                      
                        <div>
                            <button ng-click="categorySave()"  class="btn btn-primary">Save</button>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
                
                
        <!--         Item Addition Modal -->
        <div id="myModal" class="modal fade" role="dialog" >
            <div class="modal-dialog">

                <!--                 Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add Item</h4>
                    </div>
                    <div class="modal-body">

                        <div class="row alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            {{saveMessage}}
                        </div>

                        <div class="form-group">
                            Item Code:
                            <input type="text" id="itemCode" ng-model="itemCode" class="form-control">

                        </div>
                        <div class="form-group">
                            Item Name:
                            <input type="text" id="itemName"  ng-model="itemName" class="form-control">

                        </div>
                          <div class="form-group">
                              <label for="categories">
                            Item Category:
                              </label>
                              <select id="categories"ng-focus="categoriesSearch()" class="form-control" ng-model="cat" ng-options="category.categoryName for category in categories"ng-value="category.categoryCode">
                                 
                                  {{cat.categoryName}}
                            </select>
                                
                        </div>
                        <div class="form-group">
                            Reorder Point:
                            <input type="text" id="reorderPoint" ng-model="reorderPoint" class="form-control">

                        </div>  
                        <div>
                            <button ng-click="itemSave()"  class="btn btn-primary">Save</button>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>


        <!--         Modal -->
        <div class="modal fade" id="loginModal" role="dialog">
            <div class="modal-dialog">

                <!--                 Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span> Login</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" method="post" action="LoginServlet">
                            <div class="form-group">
                                <label for="username"><span class="glyphicon glyphicon-user"></span> Username</label>
                                <input type="text" class="form-control" id="username" placeholder="Enter username"name="username">
                            </div>
                            <div class="form-group">
                                <label for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="password">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="" checked>Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>

                    </div>
                </div>
            </div>
        </div>




        <!--    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>-->
        <script  src="assets/js/jquerydev.js"></script>
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="angular.js"></script>


        <script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>


        <!--    <script src="assets/js/chartist.min.js"></script>-->


        <script src="assets/js/bootstrap-notify.js"></script>
        <script src="inventory/inventory.js"></script>


        <!--    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>-->


        <script src="assets/js/light-bootstrap-dashboard.js"></script>


        <!--    <script src="assets/js/demo.js"></script>-->
        <script src="angular-route.js"></script>
        <!--
            <script type="text/javascript">
                                        $(document).ready(function () {
        
                                            demo.initChartist();
        
                                            $.notify({
                                                icon: 'pe-7s-gift',
                                                message: "Welcome to <b>Integrated Mnagement System(IMS)</b> - Helps you manage your school efficiently."
        
                                            }, {
                                                type: 'info',
                                                timer: 4000
                                            });
        
                                        });
            </script>-->

        <script>
                                        var app = angular.module("smsModule", ['ngRoute', 'inventory']);

                                        app.controller("itemsContoller", ['$scope', '$window', '$http', function ($scope, $window, $http) {
                                                $scope.itemsList = function () {
                                                    // $window.alert("itemcode is "+$scope.itemCode);
                                                    $http({
                                                        url: "/sms/inventory",
                                                        method: "get",
                                                        params: {
                                                            "itemCode": $scope.itemCode,
                                                            "itemName": $scope.itemName,
                                                            "reorderPoint": $scope.reorderPoint
                                                        }
                                                    }).then(function (result) {
                                                        $window.alert("ajax success" + result.status + " " + result.data);
                                                        $scope.itemsDataList = result.data;



                                                    }, function (result) {
                                                        $window.alert("Ajax fail");

                                                    });
                                                };

                                            }]);
                                        app.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
                                                $locationProvider.hashPrefix('!');

                                                $routeProvider.otherwise({redirectTo: '/generalInformation'});
                                            }]);

                                        function itemSearch(itemCode) {
                                            $.get({
                                                url: 'inventory/inventory/itemSearch',
                                                data: {itemCode: itemCode},
                                                success: function (data) {
                                                    //alert(data);
                                                    var itemData = JSON.parse(data);
                                                    document.getElementById('checkoutItemName').value = itemData.data[0].itemName;
                                                    document.getElementById('remainingUnits').value = itemData.data[0].units;
                                                }
                                            });
                                        }
                                        function itemSearch1(itemCode) {
                                            $.get({
                                                url: 'inventory/inventory/itemSearch',
                                                data: {itemCode: itemCode},
                                                success: function (data) {
                                                    //alert(data);
                                                    var itemData = JSON.parse(data);
                                                    document.getElementById('checkoutItemName1').value = itemData.data[0].itemName;
                                                    document.getElementById('remainingUnits1').value = itemData.data[0].units;
                                                }
                                            });
                                        }
                                        function unitsCompare() {

                                            var remainingUnits = parseInt(document.getElementById('remainingUnits1').value);
                                            var units = parseInt(document.getElementById('checkoutUnits1').value);


                                            if (remainingUnits < units) {
                                                alert("Remaining Units are less than the units To Checkout");
                                                document.getElementById('checkoutUnits1').value = "";
                                            }


                                        }

        </script>
    </body>


