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
gcloud compute networks subnets create ngrhsubnet-us --network=ngrhnet --region=us-central1 --range=172.16.0.0/24

echo "Project ID: $DEVSHELL_PROJECT_ID"