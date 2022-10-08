# sample-app
sample-app

イメージの作成（jib版）
~~~bash
./mvnw compile jib:dockerBuild
~~~

イメージの作成（Dockerfile版）
~~~bash
./mvnw clean package
docker build -t sample-app:latest .
~~~

イメージの確認
~~~bash
docker images
~~~

イメージからコンテナの起動
~~~bash
docker run --env MY_ENV_VAR=環境変数です -p 8080:8080 -it sample-app:latest
~~~

ブラウザで確認  
http://localhost:8080/

swagger-uiにアクセス  
http://localhost:8080/swagger-ui.html

helthcheck用  
http://localhost:8080/actuator/health


ECRに登録
~~~
ACCOUNT_ID=XXXXXXXXXXXX
aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin ${ACCOUNT_ID}.dkr.ecr.ap-northeast-1.amazonaws.com
~~~

~~~
docker tag sample-app:latest ${ACCOUNT_ID}.dkr.ecr.ap-northeast-1.amazonaws.com/sample-app:latest
~~~

~~~
docker push ${ACCOUNT_ID}.dkr.ecr.ap-northeast-1.amazonaws.com/sample-app:latest
~~~