# Jokeapp - Chuck Norris Joke Generator

## Description
Jokeapp is a Spring Boot application that generates and displays random Chuck Norris jokes. The application uses the `ChuckNorrisQuotes` library to generate jokes and presents them through a simple web interface.

## Features
- Generation of random Chuck Norris jokes
- Display of jokes via a web interface
- Spring Boot Actuator for application monitoring

## Technologies
- Java 21
- Spring Boot 3.5.3
- Thymeleaf for template rendering
- Maven for dependency management and build process
- Docker for containerization
- Helm for Kubernetes deployment

## Prerequisites
- Java Development Kit (JDK) 21
- Maven 3.x
- Docker (optional for container builds)
- Kubernetes cluster (optional for Helm deployment)

## Webapp 

`http://localhost:8080` or `http://localhost:30080`

## Deployment

### Deployment with Helm

Be aware that we are using a different namespace here (not default).

To run maven filtering for destination target/helm
```bash
mvn clean install -DskipTests 
```

Go to the directory where the tgz file has been created after 'mvn install'
```powershell
cd target/helm/repo
```

unpack
```powershell
$file = Get-ChildItem -Filter jokeapp-v*.tgz | Select-Object -First 1
tar -xvf $file.Name
```

install
```powershell
$APPLICATION_NAME = Get-ChildItem -Directory | Where-Object { $_.LastWriteTime -ge $file.LastWriteTime } | Select-Object -ExpandProperty Name
helm upgrade --install $APPLICATION_NAME ./$APPLICATION_NAME -f "./$APPLICATION_NAME/dependencies-values.yaml" --namespace jokeapp --create-namespace --wait --timeout 8m --debug --render-subchart-notes
```

show logs
```powershell
kubectl get pods -l app.kubernetes.io/name=$APPLICATION_NAME -n jokeapp
```
replace $POD with pods from the command above
```powershell
kubectl logs $POD -n jokeapp --all-containers
```

test
```powershell
helm test $APPLICATION_NAME --namespace jokeapp --logs
```

uninstall
```powershell
helm uninstall $APPLICATION_NAME --namespace jokeapp
```

delete all
```powershell
kubectl delete all --all -n jokeapp
```

create busybox sidecar
```powershell
kubectl run busybox-test --rm -it --image=busybox:1.36 --namespace=jokeapp --command -- bash
```

You can use the actuator rest call to verify via port 30080