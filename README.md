Application for Managing visitor details, like visitor IP, time of visit. etc.

Currently at v0.0.4 which already has 
1. Store user IP and ts to existing DB.

Existing API endpoints
1.  GET  {BASEURL}/api/v1/welcome
2.  POST {BASEURL}/visit




################ Docker Commands  ##########################

docker network create visitorMgmt-network
docker volume create  postgres-visitMgmt-vol
##### DB ########
docker pull postgres:14.20
docker run --name postgres-cont -e POSTGRES_PASSWORD=db_passwd -d -p 5432:5432 --network visitorMgmt-network -v postgres-visitMgmt-vol:/var/lib/postgresql/data postgres:14.20


docker run --name visitor-mgmt-pod --network visitorMgmt-network -p 8080:8080 -d visitor-mgmt