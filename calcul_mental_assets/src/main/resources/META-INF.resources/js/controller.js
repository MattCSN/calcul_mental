function mathtutor($scope) {
    $scope.gametitle = "Bienvenue";
    $scope.maxNumber = 10;
    $scope.n1 = 0;
    $scope.n2 = 0;
    $scope.reloadPage = function () {
        $scope.numberOfQuestions = 0;
        $scope.noOfApples = 3;
        $scope.noOfIceCreams = 0;
        $scope.getNewQuestion();
    }
    $scope.getRandomIndex = function(length){
        return Math.floor(Math.random() * length);
    }


    // -> Fisher–Yates shuffle algorithm
    var shuffleArray = function(array) {
        var m = array.length, t, i;

        // While there remain elements to shuffle
        while (m) {
            // Pick a remaining element…
            i = Math.floor(Math.random() * m--);

            // And swap it with the current element.
            t = array[m];
            array[m] = array[i];
            array[i] = t;
        }

        return array;
    }

    $scope.getNewQuestion = function () {
        $scope.n1 = Math.floor(Math.random() * $scope.maxNumber)+1;
        $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
        $scope.question = $scope.n1 + " + " + $scope.n2;
        $scope.variable1= Math.floor(Math.random() * $scope.maxNumber);
        $scope.variable2= Math.floor(Math.random() * $scope.maxNumber);
        $scope.variable3= Math.floor(Math.random() * $scope.maxNumber);
        $scope.answer = $scope.n1 + $scope.n2;

        $scope.answersforqcm= [$scope.variable1,$scope.variable2,$scope.variable3,$scope.answer];
        $scope.tests= shuffleArray($scope.answersforqcm);

        $scope.userAnswer = "";
    }
    $scope.onVoiceAnswer = function () {
        if ($scope.userAnswer && parseInt($scope.userAnswer) == $scope.answer) {
            $scope.onRightAnswer();
        }
    }
    $scope.onSubmitAnswer = function (event) {

            console.log(event);
            $scope.inputValue = event.target.innerText;

        if ($scope.inputValue && parseInt($scope.inputValue) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
        }
    }
    $scope.onSubmitAnswer2 = function (event) {

        console.log(event);
        $scope.inputValue2 = event.target.innerText;

        if ($scope.inputValue2 && parseInt($scope.inputValue2) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
        }
    }
    $scope.onSubmitAnswer3 = function (event) {

        console.log(event);
        $scope.inputValue3 = event.target.innerText;

        if ($scope.inputValue3 && parseInt($scope.inputValue3) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
        }
    }
    $scope.onSubmitAnswer4 = function (event) {

        console.log(event);
        $scope.inputValue4 = event.target.innerText;

        if ($scope.inputValue4 && parseInt($scope.inputValue4) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
        }
    }

    $scope.onRightAnswer = function () {
        $scope.noOfIceCreams++;
        $scope.numberOfQuestions++;
        if($scope.numberOfQuestions>=10){
            $('#end-run-modal').modal();
            $('#final-score').innerHTML = ''+$scope.noOfIceCreams+' / '+
                    $scope.numberOfQuestions+' avec '+(3-$scope.noOfApples)+' erreurs';
        }
        else{$scope.getNewQuestion();}
    }

    $scope.onWrongAnswer = function () {
        $scope.noOfApples--;
        if ($scope.noOfApples <= 0) {
            $("#lost-modal").modal();
        }
    }
    $scope.skipQuestion = function () {
        $scope.getNewQuestion();
        $scope.noOfIceCreams--;
    }
    $scope.range = function (num) {
        return new Array(num);
    }
}
