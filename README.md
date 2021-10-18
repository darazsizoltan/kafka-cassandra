# kafka-cassandra in minikube

kubectl create namespace practice
helm install kafka --namespace practice bitnami/kafka
helm install cassandra --namespace practice --set dbUser.password=password,cluster.datacenter=datacenter1 bitnami/cassandra

---cd into the FE modul directory
kubectl apply -f configmapfe.yaml
kubectl apply -f k8s.yaml

---cd into the BE modul directory
kubectl apply -f configmap.yaml
kubectl apply -f k8s.yaml

minikube tunnel
