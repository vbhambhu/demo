$.fn.exists = function(callback) {
    var args = [].slice.call(arguments, 1);

    if (this.length) {
        callback.call(this, args);
    }
    return this;
};

var app = angular.module('bookIt', []);


Date.prototype.yyyymmdd = function() {
    // getMonth() is zero-based
    var mm = this.getMonth();
    var dd = this.getDate();
    var month_str = new Array('Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec');

    return [ (dd>9 ? '' : '0') + dd,
        month_str[this.getMonth()],
        this.getFullYear(),
    ].join(' ');
};




app.controller('bookingForm', function($scope, $http) {

    var date = new Date();

    var h = date.getHours();
    var m = date.getMinutes();
    var ft = '0800';
    var tt = '0900'
    h = (h < 23) ? h  : 0;
    var nh = (h < 23) ? h+1  : 0;
    if(m >= 0 && m < 15){
        ft = ("0"+(h)).slice(-2)+'15';
        tt = ("0"+nh).slice(-2)+'15';
    } else if (m >= 15 && m < 30) {
        ft = ("0"+(h)).slice(-2)+'30';
        tt = ("0"+nh).slice(-2)+'30';
    } else if (m >= 30 && m < 45) {
        ft = ("0"+(h)).slice(-2)+'45';
        tt = ("0"+nh).slice(-2)+'45';
    } else if (m >= 45) {
        ft = ("0"+h).slice(-2)+'00';
        tt = ("0"+nh).slice(-2)+'00';
    }

    $scope.form = {};
    $scope.formData = {};
    $scope.formData.resource_id = '58eff677a7659611600f583b';
    $scope.formData.bookingDate = date.yyyymmdd();
    $scope.formData.to  = tt;
    $scope.formData.from  = ft;

    $scope.times  = function() {

        var x = 15;
        var times = {};
        var tt = 0;

        for (var i=0;tt<24*60; i++) {
            var hh = Math.floor(tt/60);
            var mm = (tt%60);
            var ind = ("0"+hh).slice(-2)+("0" + mm).slice(-2);
            times[ind] = ("0"+hh).slice(-2)+':'+("0" + mm).slice(-2);
            tt = tt + x;
        }

        return times;

    }





    $scope.times = $scope.times();





    $scope.updateform = function() {

        $http.get('/api/booking/form', {params: {rid: $scope.formData.resource_id}}).then(function successCallback(response) {


            $scope.form = response.data;

            $scope.formData.project_id = response.data.projects[0].id;


            var ndate = new Date($scope.bookingDate);
            var day_str = new Array('SUN', 'MON','TUE','WED','THR','FRI','SAT');

            var selected_day  = day_str[ndate.getDay()];

            if(response.data.selectedResource.availableSlots){
                $scope.form.slots = response.data.selectedResource.availableSlots[selected_day];
            }

        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    $scope.updateform()






});




app.controller('resEditor', function($scope, $http) {


    $scope.rid = document.getElementById('res_id').value;


    $scope.fieldType = "text";



    $http.get('/api/resource', {params: {rid:$scope.rid}}).then(function successCallback(response) {

        $scope.resource = response.data;
        $scope.lastAddedID = response.data.fields.length;

    }, function errorCallback(response) {
    });


    $scope.addField = function(fieldType) {


        $scope.lastAddedID++;

        var newField = {
            "fieldId" : $scope.lastAddedID,
            "type" : fieldType,
            "name" : createIdentifier(),
            "label" : "New field - " + $scope.lastAddedID,
            "value": null,
            "hasError": null,
            "errMsg": null,
            "helpText": null,
            "options": [],
            "validations": []
        };

        if(fieldType == "radio" || fieldType == "check" || fieldType == "select"){
            newField.options = [{id:1,label:"Choice 1", value:"1"}, {id:2,label:"Choice 2", value:"2"}, {id:3,label:"Choice 3", value:"3"}];
        }

        $scope.resource.fields.push(newField);



    }


    $scope.saveResource = function() {

        var token = $("meta[name='_csrf']").attr("content");

        $http({
            url: '/api/resource/update',
            dataType: 'json',
            method: 'POST',
            data: $scope.resource,
            headers: {
                "Content-Type": "application/json",
                'X-CSRF-TOKEN': token
            }
        }).success(function(response){
            $scope.response = response;
        }).error(function(error){
            $scope.error = error;
        });



    }



});

function createIdentifier() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 10; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text.toLowerCase();
}