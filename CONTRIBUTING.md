# Contributing

Any contributions to the dark theme and compatibility are welcome!
And thanks to all [contributors](https://github.com/jenkinsci/dark-theme-plugin/graphs/contributors)!

## Testing

We are also looking for early adopters and testers who are interested to try out the theme and to provide feedback.

### Quick start

We have a demo with a pre-configured Docker image you can use for trying out the Dark theme.
You can find it [here](./demo/README.md).

## Developing

Start the theme plugin with `mvn hpi:run`

You will get a development instance of Jenkins running on port 8080

Any changes you make to the theme CSS file will be reflected after refreshing the page, no need to restart Jenkins.

### Manual setup

1. Run Jenkins from a pull request
  *  ```docker run --rm -ti -p 8080:8080 -e ID=4752 jenkins/core-pr-tester```
2. Install the Simple Theme Plugin
3. Add the theme CSS from this repository to the instance
  * You can use the jsdeliver CDN to pull it directly from GitHub: https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/src/main/resources/io/jenkins/plugins/darktheme/theme.css

More detailed testing guidelines are coming soon!

### Reporting issues

Please report the discovered compatibility issues and any suggestions using the GitHub Issues in this repository.
We will triage the issues and, if needed, help with creating issues to the Jenkins core and/or plugins.

## Development

The pre-configured Docker image can be also used for development purposes.
You can find the guide [here](./demo/README.md#development).
