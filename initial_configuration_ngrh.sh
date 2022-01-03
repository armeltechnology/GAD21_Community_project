# Copyright 2021 GAD2021 Armel Google Cloud Learner.
echo "Creating App Engine app"
gcloud app create --region "us-central"

echo "Making bucket: gs://$DEVSHELL_PROJECT_ID-ngrh"
gsutil mb gs://$DEVSHELL_PROJECT_ID-ngrh

echo "Exporting GCLOUD_PROJECT and GCLOUD_BUCKET"
export GCLOUD_PROJECT=$DEVSHELL_PROJECT_ID
export GCLOUD_BUCKET=$DEVSHELL_PROJECT_ID-ngrh

echo "Creating Cloud network and subnetwork"
gcloud compute networks create ngrhnet --subnet-mode=custom
gcloud compute networks subnets create ngrhsubnet-us --network=ngrhnet --region=us-central1 --range=10.65.61.0/24

echo "Creating Cloud SQL instances"
gcloud sql instances create [instance_Name] --tier=db-n1-standard-1 --region=us-central1

echo "Set the password for the root  MySQL user "
gcloud sql users set-password root --host=% --instance [instance_Name] --password [PASSWORD]

echo "Create database"
gcloud sql databases create [database_Name] --instance=[instance_Name]

echo "create secret for data source configuration"
echo -n "[project-Id]:us-central1:[instance_Name]" | gcloud secrets create spring_cloud_gcp_sql_instance_connection_name — replication-policy="automatic" — data-file=-  
echo -n "[database_Name]" | gcloud secrets create spring_cloud_gcp_sql_database_name — replication-policy="automatic" — data-file=-  
echo -n "root" | gcloud secrets create spring_datasource_username — replication-policy="automatic" — data-file=-  
echo -n "[PASSWORD]" | gcloud secrets create spring_datasource_password — replication-policy="automatic" — data-file=-

echo "list secret"
gcloud secrets list


echo "Project ID: $DEVSHELL_PROJECT_ID"
