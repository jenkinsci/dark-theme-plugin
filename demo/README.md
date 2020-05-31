# Dark Theme demo for Jenkins

[![Docker Pulls](https://img.shields.io/docker/pulls/jenkins4eval/dark-theme)](https://hub.docker.com/r/jenkins4eval/dark-theme)

Demo that can be used for evaluation and testing of the Dark theme and the Dark Login Theme.
This demo is based on [oleg-nenashev/demo-jenkins-config-as-code](https://github.com/oleg-nenashev/demo-jenkins-config-as-code)
which includes pre-configured plugins, jobs and users.
You can use it for testing the theme Admin, SystemRead and Manage permissions.

## Usage

You will need Docker and make to run this demo.

1. `make run` will run the image.
   You can also use `make run-preview` to run the theme with other UI improvements which are in preview.
   `make run-light` can be ran to test the standard light mode.
2. Go to the `http://localhost:8080`.
3. Login with one of the user accounts (see below).
4. Try out the theme, submit a GitHub Issue to this repository if you discover any compatibility issues.

For advanced use-cases, please see the documentation in [oleg-nenashev/demo-jenkins-config-as-code](https://github.com/oleg-nenashev/demo-jenkins-config-as-code).

### User accounts

The demo includes the following user accounts.

  * `admin/admin` - for a user with full administrative access
  * `readonly/readonly` - user with global read-only access (System Read, Extended Read for jobs and agents)
  * `manager/manager` - user with global Manage permissions
  * `user/user` - common Jenkins user with access to some jobs on the instance

### Building the image

It is also possible to build the demo locally.
Use `make build` to do so.

### Development mode

By default the demo uses a dark theme from the master branch in GitHub.
If you want to make changes locally and test them, use the following commands:

* `make dev` - for the default UI
* `make dev-preview` - Jenkins UI with the preview features enabled
* `make dev-light` - for development with classic light mode
* `make dev-light-preview` - for development with classic light mode and preview features
