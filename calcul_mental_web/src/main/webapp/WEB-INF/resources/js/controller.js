function CalendarCtrl($scope,$compile,uiCalendarConfig,CalEventsWS) {

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    $scope.eventsF = function (start, end, callback) {
        console.log("eventsF");
        CalEventsWS.query().$promise.then(function(data){
            console.log(data);
            var retour = [];
            for(var i=0; i< data.length;i++){
                retour.push({
                    title:data[i].title,
                    start:new Date(data[i].start),
                    end:new Date(data[i].end),
                    id:data[i].id,
                    allDay:false,
                    color:data[i].color
                });
            }
            callback(retour);
        });
    };



    /* event source that contains custom events on the scope */
    $scope.events = [
        {title: 'All Day Event',start: new Date(y, m, 1)},
        {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
        {id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
        {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
        {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
        /*{title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}*/
    ];


    $scope.calEventsExt = {
        color: '#f00',
        textColor: 'yellow',
        events: [
            {type:'party',title: 'Lunch',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
            {type:'party',title: 'Lunch 2',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
            /*{type:'party',title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}*/
        ]
    };
    /* alert on eventClick */
    $scope.alertOnEventClick = function( date, jsEvent, view){
        //$scope.alertMessage = (date.title + ' was clicked ');
        CalEventsWS.get({id:date.id}).$promise.then(function(data){
            alert(data.description);
        });
    };
    /* alert on Drop */
    $scope.alertOnDrop = function(event, delta, revertFunc, jsEvent, ui, view){
        $scope.alertMessage = ('Event Droped to make dayDelta ' + delta);
    };
    /* alert on Resize */
    $scope.alertOnResize = function(event, delta, revertFunc, jsEvent, ui, view ){
        $scope.alertMessage = ('Event Resized to make dayDelta ' + delta);
    };
    /* add and removes an event source of choice */
    $scope.addRemoveEventSource = function(sources,source) {
        var canAdd = 0;
        angular.forEach(sources,function(value, key){
            if(sources[key] === source){
                sources.splice(key,1);
                canAdd = 1;
            }
        });
        if(canAdd === 0){
            sources.push(source);
        }
    };
    $scope.addEvent = function() {
        var eventToAdd = new CalEventsWS();
        eventToAdd.title = $scope.title;
        eventToAdd.description = $scope.description;
        eventToAdd.start = moment($scope.start, "DD-MM-YYYY HH:mm").unix() * 1000;
        eventToAdd.end = moment($scope.end, "DD-MM-YYYY HH:mm").unix() * 1000;
        console.log("save", eventToAdd);
        eventToAdd.$save().then(function () {
            console.log($scope.events);
            /*var evt = {title: eventToAdd.title, description: eventToAdd.description, start: eventToAdd.start, end: eventToAdd.end};
            $scope.events[0].push(evt);
*/
            uiCalendarConfig.calendars['myCalendar1'].fullCalendar( 'refetchEvents' )
            $scope.title = undefined;
            $scope.description = undefined;
            $scope.start = undefined;
            $scope.end = undefined;
            console.log($scope.events);


        });
    }
    /* remove event */
    $scope.remove = function(index) {
        $scope.events.splice(index,1);
    };
    /* Change View */
    $scope.changeView = function(view,calendar) {
        uiCalendarConfig.calendars[calendar].fullCalendar('changeView',view);
    };
    /* Change View */
    $scope.renderCalender = function(calendar) {
        if(uiCalendarConfig.calendars[calendar]){
            uiCalendarConfig.calendars[calendar].fullCalendar('render');
        }
    };
    /* Render Tooltip */
    $scope.eventRender = function( event, element, view ) {
        element.attr({'tooltip': event.title,            'tooltip-append-to-body': true});
        $compile(element)($scope);
    };
    /* config object */
    $scope.uiConfig = {
        calendar:{
            height: 450,
            editable: false,
            firstDay:1,
            header:{
                left: 'title',
                center: '',
                right: 'today prev,next'
            },
            eventClick: $scope.alertOnEventClick,
            eventDrop: $scope.alertOnDrop,
            eventResize: $scope.alertOnResize,
            eventRender: $scope.eventRender
        }
    };

    /* event sources array*/
    $scope.eventSources = [$scope.eventsF];


    /*$scope.changeView = function(view,calendar) {
      calendar.fullCalendar('changeView',view);
    };

   

    $scope.uiConfig = {
      calendar:{
    	lang:'fr',
        height: 450,
        timezone:'local',
        eventClick:function(event, allDay, jsEvent, view){
        	console.log(event);
        	CalEventsWS.get({id:event.id}).$promise.then(function(data){
        		var modalInstance = $modal.open({
        		      templateUrl: 'myModalContent.html',
        		      controller: 'ModalInstanceCtrl',
        		      resolve: {
        		        content: function () {
        		          return data.description;
        		        },
		        		title:function(){
		        			return data.title;
		        		}
        		      }
        		    });
        	});
        }
      }
    };
    
    
    $scope.events = [CalEventsWS.query()];
    $scope.renderCalender = function(calendar) {
        calendar.fullCalendar('render');
      };
    

    $scope.addEvent = function() {
    	var eventToAdd = new CalEventsWS();
    	eventToAdd.title = $scope.title;
    	eventToAdd.description = $scope.description;
    	eventToAdd.start = moment($scope.start,"DD-MM-YYYY HH:mm").unix()*1000;
    	eventToAdd.end = moment($scope.end,"DD-MM-YYYY HH:mm").unix()*1000;
    	console.log("save",eventToAdd);
    	eventToAdd.$save().then(function(){
    		console.log($scope.events);
    		var evt = {title:eventToAdd.title,description:eventToAdd.description,start:eventToAdd.start,end:eventToAdd.end};
    		$scope.events[0].push(evt);
    			  		
    		$scope.title = undefined;
    		$scope.description=undefined;
    		$scope.start=undefined;
    		$scope.end= undefined;
    		console.log($scope.events);
    		
    		 
    	});
      
    };*/

    

}
