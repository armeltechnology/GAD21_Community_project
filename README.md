# GAD21_Community_project
## Ngounou_Remote_Hospital (NgRH):
	Is a web platform where patients and victims of violence can be consulted or assisted remotely by doctors of their choice.
## 1 Launch in your GCP:
    -Enable Cloud build API, and create cloud build service account with roles App engine Admin, Cloud build service account.
    -Enable secret Manger API, also add roles Secret Manager Secret Accessor in Compute Engine default service account , and Secret Manager Admin in App Engine default service account
    

## 2 Clone this repository by type this in your prompt shell: 
	git clone https://github.com/armeltechnology/GAD21_Community_project.git 

## 3 Open script file"initial_configuration_ngrh.sh" to change:
    - range of ip address if you want. 
    - replace all those with your own parameters [instance_Name], [database_Name], [PASSWORD], [project-Id]
	then save.
	Run the executable file by running the following script command: . initial_configuration_ngrh.sh
		This script file: 
			Creates an App Engine application. 
			Creates a Cloud Storage bucket. 
			Exports environment variables GCLOUD_PROJECT and GCLOUD_BUCKET. 
			Creates ngrhnet and ngrhsubnet for you in us-central. 
           		Creating Cloud SQL instances
           		Set the password for the root  MySQL user 
           		Create database
       		     	Create secret for data source configuration
            		list secret
			Prints out the Project ID. 

## 4 verify all previous is done befor go to next

## 5 Change to the directory that contains the project_community Healtcare NgRH by type this command : 
	cd project_GAD21_Community_Healthcare-NgRH/
	Open file to src/main/resources/application.properties and bootstrap.properties  then replace [project number] with your own povide by google cloud. 

## 6 Ensure your in the path: 
	cd GAD21_Community_project.git/project_GAD21_Community_Healthcare-NgRH/ 
	Runs this command: 
		 mvn clean install 

## 7 App Dev - Deploying the Application NgRH into App Engine Flexible Environment:Java run: 
	Click on cloud editor and open app.yaml file in GAD21_Community_project.git/project_GAD21_Community_Healthcare-NgRH/app.yaml
	Copy this file in this location /GAD21_Community_project/project_GAD21_Community_Healthcare-NgRH/target
	and then Be sure you replace [GCLOUD_BUCKET] with the actual bucket name GCLOUD_PROJECT-ngrh from your project.
 
## 8 In Cloud Shell, Open Terminal, enter the following command to deploy the NgRH application to App Engine flexible environment. 
	gcloud app deploy 
	gcloud browse 

## 9 Injoy your Ngounou_Remote_Hopital application thanks all...
