function mathtutor($scope, $compile, UtilisateurWS) {
    $scope.gametitle = "Bienvenue";
    $scope.compteurProgressBar = 0;

    $scope.n1 = 0;
    $scope.n2 = 0;
    $scope.lvl=0;
    $scope.userID=null;


    //TODO: fonction pour se connecter AJAX pour communiquer avec UtilisateurController sur un GET
    function getConnectedUser(){

        //recup val bouton
        /*var xml = ( window.XMLHttpRequest ) ?
        new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");

        xml.open("GET", user/myName, true);
        xml.setRequestHeader("Content-type", "application/json");

        xml.onreadystatechange = function()
        {
            if( xml.readyState === 4 &&
                xml.status     === 200 )
            {
                var serverResponse = JSON.parse(xml.responseText);
                switch(serverResponse.d)
                {
                    //GET user id et stocker sous forme userID =
                }
            }
        }
        xml.send(null);
        */
    }

    //TODO: fonction pour récupérer
    $scope.reloadPage = function () {
        $scope.numberOfQuestions = 0;
        $scope.noOfApples = 3;
        $scope.noOfGoodAnswers = 0;
        $scope.getNewQuestion();
        getConnectedUser();
        //$scope.myFunction();
        //TODO: appeler la fonction de connection si non connecté
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

        $scope.variable1 = 0;
        $scope.variable2 = 0;
        $scope.variable3 = 0;

        var generateNewAddition = function () {
            while ($scope.answer > $scope.maxNumber
            || $scope.variable1 == $scope.variable2
            || $scope.variable1 == $scope.variable3
            || $scope.variable2 == $scope.variable3
            || $scope.answer == $scope.variable1
            || $scope.answer == $scope.variable2
            || $scope.answer == $scope.variable3) {
                $scope.n1 = Math.floor(Math.random() * $scope.maxNumber) + 1;
                $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
                $scope.question = $scope.n1 + " + " + $scope.n2;
                $scope.variable1 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) + $scope.minNumber);
                $scope.variable2 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) + $scope.minNumber);
                $scope.variable3 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) + $scope.minNumber);
                $scope.answer = $scope.n1 + $scope.n2;

            }

        };

        var generateNewSoustraction = function () {
            while ($scope.answer > $scope.maxNumber
            || $scope.variable1 == $scope.variable2
            || $scope.variable1 == $scope.variable3
            || $scope.variable2 == $scope.variable3
            || $scope.answer == $scope.variable1
            || $scope.answer == $scope.variable2
            || $scope.answer == $scope.variable3
            || $scope.n1 < $scope.n2) {
                $scope.n1 = Math.floor(Math.random() * $scope.maxNumber) + 1;
                $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
                $scope.question = $scope.n1 + " - " + $scope.n2;
                $scope.variable1 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) - $scope.minNumber);
                $scope.variable2 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) - $scope.minNumber);
                $scope.variable3 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) - $scope.minNumber);
                $scope.answer = $scope.n1 - $scope.n2;

            }

        };

        var generateNewMultiplication = function () {
            while ($scope.answer > $scope.maxNumber * $scope.minNumber
            || $scope.variable1 == $scope.variable2
            || $scope.variable1 == $scope.variable3
            || $scope.variable2 == $scope.variable3
            || $scope.answer == $scope.variable1
            || $scope.answer == $scope.variable2
            || $scope.answer == $scope.variable3
            || $scope.n1 < $scope.n2) {
                $scope.n1 = Math.floor(Math.random() * $scope.maxNumber) + 1;
                $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
                $scope.question = $scope.n1 + " x " + $scope.n2;
                $scope.variable1 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) * $scope.minNumber);
                $scope.variable2 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) * $scope.minNumber);
                $scope.variable3 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) * $scope.minNumber);
                $scope.answer = $scope.n1 * $scope.n2;

            }

        }

        var generateNewDivision = function () {
            while ($scope.answer > $scope.maxNumber
            || $scope.variable1 == $scope.variable2
            || $scope.variable1 == $scope.variable3
            || $scope.variable2 == $scope.variable3
            || $scope.answer == $scope.variable1
            || $scope.answer == $scope.variable2
            || $scope.answer == $scope.variable3
            || $scope.n1 % $scope.n2 !== 0) {
                $scope.n1 = Math.floor(Math.random() * $scope.maxNumber) + 1;
                $scope.n2 = Math.floor(Math.random() * $scope.maxNumber);
                $scope.question = $scope.n1 + " / " + $scope.n2;
                $scope.variable1 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) / $scope.minNumber);
                $scope.variable2 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) / $scope.minNumber);
                $scope.variable3 = Math.floor(Math.random() * ($scope.maxNumber - $scope.minNumber + 1) / $scope.minNumber);
                $scope.answer = $scope.n1 / $scope.n2;

            }

        };

        /** ******************************************************************************************************** **/
        /** Pour ajouter un nouveau niveau de difficulté :                                                           **/
        /**                                                                                                          **/
        /** "case n:                                                                                                 **/
        /** $scope.minNumber = 1; $scope.maxNumber = 10;                                                             **/
        /** Puis :                                                                                                   **/
        /**       - Copier/Coller: "generateNewAddition(); " ci-dessous pour ajouter une nouvelle addition           **/
        /**       - Copier/Coller: "generateNewSoustraction(); " ci-dessous pour ajouter une nouvelle addition       **/
        /**       - Copier/Coller: "generateNewMultiplication(); " ci-dessous pour ajouter une nouvelle addition     **/
        /**       - Copier/Coller: "generateNewDivision(); " ci-dessous pour ajouter une nouvelle addition           **/
        /** break; "                                                                                                 **/
        /** ******************************************************************************************************** **/

        switch ($scope.lvl) {
            case 0:
                $scope.minNumber = 1;
                $scope.maxNumber = 10;
                generateNewAddition();
                break;
            case 1:
                $scope.minNumber = 1;
                $scope.maxNumber = 20;
                generateNewSoustraction();
                break;
            case 2:
                $scope.minNumber = 2;
                $scope.maxNumber = 20;
                generateNewMultiplication();
                break;
            case 3:
                $scope.minNumber = 3;
                $scope.maxNumber = 30;
                generateNewDivision();
                break;
            default:
                $scope.minNumber = 1;
                $scope.maxNumber = 70;
                generateNewDivision();

        }

        //Progress bar
        if ($scope.compteurProgressBar == 10){
            $scope.compteurProgressBar = 1;
            $scope.progressBar = "Question : " + $scope.compteurProgressBar + "/ 10"
        }else{
            $scope.compteurProgressBar ++;
            $scope.progressBar = "Question : " + $scope.compteurProgressBar + "/ 10"
        }


        $scope.answersforqcm= [$scope.variable1,$scope.variable2,$scope.variable3,$scope.answer];
        $scope.tests= shuffleArray($scope.answersforqcm);

        $scope.userAnswer = "";

        document.getElementById('btn1').disabled = '';
        document.getElementById('btn2').disabled = '';
        document.getElementById('btn3').disabled = '';
        document.getElementById('btn4').disabled = '';
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
            document.getElementById('btn1').disabled = 'disabled';
        }
    }
    $scope.onSubmitAnswer2 = function (event) {

        console.log(event);
        $scope.inputValue2 = event.target.innerText;

        if ($scope.inputValue2 && parseInt($scope.inputValue2) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
            document.getElementById('btn2').disabled = 'disabled';
        }
    }
    $scope.onSubmitAnswer3 = function (event) {

        console.log(event);
        $scope.inputValue3 = event.target.innerText;

        if ($scope.inputValue3 && parseInt($scope.inputValue3) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
            document.getElementById('btn3').disabled = 'disabled';
        }
    }
    $scope.onSubmitAnswer4 = function (event) {

        console.log(event);
        $scope.inputValue4 = event.target.innerText;

        if ($scope.inputValue4 && parseInt($scope.inputValue4) == $scope.answer) {
            $scope.onRightAnswer();
        } else {
            $scope.onWrongAnswer();
            document.getElementById('btn4').disabled = 'disabled';
        }
    }

    $scope.onRightAnswer = function () {

        var good_gif = Math.floor(Math.random()*2);

        if (good_gif==0)
            $scope.url="images/good_girl.gif";
        else
            $scope.url="images/good_boy.gif";

        $scope.noOfGoodAnswers++;
        $scope.numberOfQuestions++;
        if($scope.numberOfQuestions>=10){
            $('#end-run-modal').modal();
            $('#final-score').innerHTML = ''+$scope.noOfGoodAnswers+' / '+
                    $scope.numberOfQuestions+' avec '+(3-$scope.noOfApples)+' erreurs';
            //TODO: envoyer le score en ajax sur un POST /user/score...
        }
        else{$scope.getNewQuestion();}

        /*Gestion des lvls*/
        if ($scope.numberOfQuestions == 10 && $scope.noOfGoodAnswers >= 8){
            $scope.lvl++;
        }
    }

    $scope.onWrongAnswer = function () {

        var good_gif = Math.floor(Math.random()*2);

        if (good_gif==0)
            $scope.url="images/bad_girl.gif";
        else
            $scope.url="images/bad_boy.gif";

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
        $scope.noOfApples--;
        if ($scope.noOfApples <= 0) {
            $("#lost-modal").modal();
        }
    }
    $scope.range = function (num) {
        return new Array(num);
    }

}
