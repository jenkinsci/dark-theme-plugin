# Dark Theme for Jenkins

[![Build Status](https://ci.jenkins.io/job/Plugins/job/dark-theme-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/dark-theme-plugin/job/master/)
[![Gitter](https://badges.gitter.im/jenkinsci/ux-sig.svg)](https://gitter.im/jenkinsci/ux-sig?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Changelog](https://img.shields.io/github/release/jenkinsci/dark-theme.svg?label=changelog)](https://github.com/jenkinsci/dark-theme/releases/)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/dark-theme.svg)](https://plugins.jenkins.io/dark-theme)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/dark-theme.svg?color=blue)](https://plugins.jenkins.io/dark-theme)

This repository contains a dark theme for Jenkins.

*Requires Jenkins >= 2.249.1*

## Usage

### Installing via Jenkins update center

To install this theme search for 'Dark theme' in your Jenkins update center.

Then go to the "Configure System" page, search for 'Built-in Themes' and select 'Dark (Respect OS/Browser system setting)'

or with the [configuration-as-code](https://github.com/jenkinsci/configuration-as-code-plugin) plugin:

```yaml
unclassified:
  themeManager:
    disableUserThemes: true
    theme: "darkSystem" # use 'dark' for forcing the dark theme regardless of OS settings
```

Users can configure the theme from their user profile page, see the [theme-manager documentation](https://github.com/jenkinsci/theme-manager-plugin#configuring-the-plugin),
for more information.

### Simple theme plugin

If you can't install this plugin for some reason you can use the [Simple Theme Plugin](https://plugins.jenkins.io/simple-theme-plugin/).

See the plugin documentation for theme installation guidelines.

_Note: replace 'tag-name' with the latest released version:_
[![GitHub release](https://img.shields.io/github/release/jenkinsci/dark-theme.svg?label=latest)](https://github.com/jenkinsci/dark-theme/releases/latest)

The CSS URLs are:

```text
https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/src/main/resources/io/jenkins/plugins/darktheme/theme.css
https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/src/main/resources/io/jenkins/plugins/darktheme/theme-system.css
```

* theme.css - forces dark theme for all users
* theme-system.css - respects users system setting for dark / light mode, in most cases this is the theme you should be using

or with the [configuration-as-code](https://github.com/jenkinsci/configuration-as-code-plugin) plugin:

```yaml
unclassified:
  simple-theme-plugin:
    elements:
      - cssUrl:
          url: "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/theme-system.css"
          #url: "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/theme.css"
```

## Screenshots

Main screen:

![Main screen](./docs/images/screenshot_main.png)

Build console:

![Build console log](./docs/images/screenshot_build_console.PNG)

## Browser compatibility

The theme should be compatible with all modern browsers.

No version of IE will be supported.

## Jenkins compatibility

This project is in active development and needs a recent version of Jenkins, at least v2.240.

We will do our best to not break new versions of the theme against older supported versions of Jenkins.

To be safe you should use our published releases instead of relying on the master branch

## References

* Introduction and first demo at the Jenkins UI/UX hackfest:
  [video](https://youtu.be/hJuAO09rKLM?t=1357),
  [slides](https://docs.google.com/presentation/d/19N4B7BXu_Zfw8IDdUAZl_83-jXDAvwWC2KI6BvvNUCI/edit#slide=id.g8790db40db_0_205)
* Integration pull request with the changes:
  [jenkinsci/jenkins#4752](https://github.com/jenkinsci/jenkins/pull/4752)

## Contributing

Any contributions to the dark theme and compatibility are welcome!
See [CONTRIBUTING.md](./CONTRIBUTING.md) for the contribution guidelines.
And thanks to all [contributors](./CONTRIBUTORS.md)!

## References

* The theme was created as a part of the [Jenkins UI/UX Hackfest](https://github.com/jenkinsci/ui-ux-hackfest-2020) on May 25-29, 2020.
* The theme is inspired by the [camalot/jenkins-dark-stylish](https://github.com/camalot/jenkins-dark-stylish) theme, but it is a new theme created by scratch.
