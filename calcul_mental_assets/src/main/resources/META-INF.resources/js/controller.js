function mathtutor($scope) {
    $scope.gametitle = "Bienvenue";
    $scope.compteurProgressBar = 0;
    $scope.minNumber = 1;
    $scope.maxNumber = 10;
    $scope.n1 = 0;
    $scope.n2 = 0;
    $scope.lvl = 0;

    $scope.reloadPage = function () {
        $scope.numberOfQuestions = 0;
        $scope.noOfApples = 3;
        $scope.noOfGoodAnswers = 0;
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
        $scope.answer = 11;
        $scope.variable1 = 0;
        $scope.variable2 = 0;
        $scope.variable3 = 0;
        while ($scope.answer > 10
        || $scope.variable1 == $scope.variable2
        || $scope.variable1 == $scope.variable3
        || $scope.variable2 == $scope.variable3
        || $scope.answer == $scope.variable1
        || $scope.answer == $scope.variable2
        || $scope.answer == $scope.variable3 )
        {
            $scope.n1 = Math.floor(Math.random() * $scope.maxNumber)+1;
            $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
            $scope.question = $scope.n1 + " + " + $scope.n2;
            $scope.variable1= Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber +1)+ $scope.minNumber);
            $scope.variable2= Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber +1)+ $scope.minNumber);
            $scope.variable3= Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber +1)+ $scope.minNumber);
            $scope.answer = $scope.n1 + $scope.n2;
        }
        //Progress bar
        if ($scope.compteurProgressBar == 10){
            $scope.compteurProgressBar = 0;
            $scope.progressBar = "Question : " + $scope.compteurProgressBar + "/ 10"
        }else{
            $scope.compteurProgressBar ++;
            $scope.progressBar = "Question : " + $scope.compteurProgressBar + "/ 10"
        }


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

        $scope.noOfGoodAnswers++;
        $scope.numberOfQuestions++;
        if($scope.numberOfQuestions>=10){
            $('#end-run-modal').modal();
            $('#final-score').innerHTML = ''+$scope.noOfGoodAnswers+' / '+
                    $scope.numberOfQuestions+' avec '+(3-$scope.noOfApples)+' erreurs';
        }
        else{$scope.getNewQuestion();}
        /*Gestion des lvls*/
        if ($scope.numberOfQuestions == 10 && $scope.noOfGoodAnswers >= 8){
            $scope.lvl++;
        }
    }

    $scope.onWrongAnswer = function () {
        $scope.noOfGoodAnswers--;
        $scope.noOfApples--;
        if ($scope.noOfApples <= 0) {
            $("#lost-modal").modal();
        }
        //document.getElementById('btnAnswer1').disabled = 'disabled';
    }
    $scope.skipQuestion = function () {
        $scope.getNewQuestion();
        $scope.noOfGoodAnswers--;
    }
    $scope.range = function (num) {
        return new Array(num);
    }
}
