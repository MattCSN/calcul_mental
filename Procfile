web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
web: gunicorn app:app --log-file=-