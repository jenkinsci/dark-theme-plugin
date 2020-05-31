### Dark Login Theme

| WARNING: Dark Login Theme is currently under development. You can try it out by using `make devel-login` and specifying a path to the local version of https://github.com/jenkinsci/jenkins/pull/4763 |
| --- |

Login theme in Jenkins is configured separately, with help of the [Login Theme Plugin](https://plugins.jenkins.io/login-theme/).
Contains overrides for the Jenkins Core CSS themes, with support for CSS variables.
This will be soon moved to upstream soon.

Jenkins config.yml sample for testing.

```yml
  login-theme-plugin:
    head: |
      <link rel="stylesheet" href="/css/simple-page.css" type="text/css" />
      <link rel="stylesheet" href="/css/simple-page.theme.css" type="text/css" />
      <link rel="stylesheet" href="/css/simple-page-forms.css" type="text/css" />
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/theme.css" type="text/css" />
    header: |
      <div id="loginIntroDefault">
        <div class="logo"> </div>
        <h1>Welcome to Jenkins</h1>
      </div>
    useDefaultTheme: false
```
