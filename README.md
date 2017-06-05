# Project Title

Android Starter Kit

## Getting Started

These instructions will get you a copy of the starter project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

For testing Starter Kit, you need following:
* [JSON Server](https://github.com/typicode/json-server) - Fake API server to server mobile app

```
json-server --watch db.json --port 3004
```
* [Ngrok](https://ngrok.com/) - Secure tunnels to localhost for giving access of localhost to mobile

```
ngrok http 80
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### Activity Examples Included

* Login Activity
	1) mayRequestContacts to request Contacts list to pickup email
	2) attemptLogin to check for valid input in email and passwrod
* Navigation Drawer Activity -NavTrialActivity
activity_nav_trial.xml contains NavigationView which contains 2 blocks. 
	1) HeaderLayout provded by nav_header_nav_trial
	2) Menu options provided by activity_nav_trial_drawer
app_bar_nav_trial.xml contains 
	1) AppBarLayout contains Toolbar visible on top
	2) content_nav_trial.xml(Costraint Layout) contains the center content - *This is the layout that we will replace on each navigation button select*
	3) FloatingActionButton visible in the bottom
* Article Fragment
	1) Added MPAndroidChart inside onCreateView



## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [GreenDao Tutorial](https://www.codementor.io/sundayakinsete/integrating-greendao-into-your-android-application-yro5fzgtw) - Integrating greenDAO Database Manager
* [Volley Tutorial](https://developer.android.com/training/volley/index.html) - Integrating Volley Network Handler
* [Volley Get JSONObject tutorial](https://developer.android.com/training/volley/request.html) - Get Call using JSONObject and Volley
* [Volley Post JSON example](https://stackoverflow.com/questions/43605793/volley-post-json-using-string-request) 
* [MPAndroidChart Wiki](https://github.com/PhilJay/MPAndroidChart/wiki/Getting-Started) Code samples for MPAndroidChart

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Shaunak Das** - *Initial work* - [ShaunakDas](https://github.com/Shaunakdas)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
