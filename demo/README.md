# Dark Theme demo for Jenkins

In this directory you can find a Dockerized demo which you can use for testing of the Dark theme.
This demo is based on [oleg-nenashev/demo-jenkins-config-as-code](https://github.com/oleg-nenashev/demo-jenkins-config-as-code)
which includes pre-configured plugins, jobs and users.
You can use it for testing the theme Admin, SystemRead and Manage permissions.

## Usage

You will need Docker and make to run this demo.

1. `make build` - will build the demo image.
2. `make run` will run the image.
3. Go to the `http://localhost:8080`.
4. Login with one of the user accounts.
  * `admin/admin` - for a user with full administrative access
  * `readonly/readonly` - user with global read-only access (System Read, Extended Read for jobs and agents)
  * `manager/manager` - user with global Manage permissions
  * `user/user` - common Jenkins user with access to some jobs on the instance
5. Try out the theme, submit a GitHub Issue to this repository if you discover any compatibility issues.

For advanced use-cases, please see the documentation in [oleg-nenashev/demo-jenkins-config-as-code](https://github.com/oleg-nenashev/demo-jenkins-config-as-code).
