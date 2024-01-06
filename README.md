# Dark Theme for Jenkins

[![Build Status](https://ci.jenkins.io/job/Plugins/job/dark-theme-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/dark-theme-plugin/job/master/)
[![Gitter](https://badges.gitter.im/jenkinsci/ux-sig.svg)](https://gitter.im/jenkinsci/ux-sig?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Changelog](https://img.shields.io/github/release/jenkinsci/dark-theme.svg?label=changelog)](https://github.com/jenkinsci/dark-theme/releases/)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/dark-theme.svg)](https://plugins.jenkins.io/dark-theme)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/dark-theme.svg?color=blue)](https://plugins.jenkins.io/dark-theme)

This repository contains a dark theme for Jenkins.

## Usage

### Installing via Jenkins update center

Search for 'Dark theme' in your Jenkins update center and install it.

Then go to "Manage Jenkins" and click "Appearance", search for 'Themes' and select 'Dark (System)'

or with the [configuration-as-code](https://github.com/jenkinsci/configuration-as-code-plugin) plugin:

From Jenkins 2.421:
```yaml
appearance:
  themeManager:
    disableUserThemes: true
    theme: "darkSystem" # use 'dark' for forcing the dark theme regardless of OS settings
```

Previously:
```yaml
unclassified:
  themeManager:
    disableUserThemes: true
    theme: "darkSystem" # use 'dark' for forcing the dark theme regardless of OS settings
```

Users can configure the theme from their user profile page, see the [theme-manager documentation](https://github.com/jenkinsci/theme-manager-plugin#configuring-the-plugin),
for more information.

## Screenshots

Main screen:

![Main screen](./docs/images/screenshot_main.png)

Build console:

![Build console log](./docs/images/screenshot_build_console.PNG)

## Browser compatibility

The theme should be compatible with all modern browsers.

No version of IE will be supported.

## References

* Introduction and first demo at the Jenkins UI/UX hackfest:
  [video](https://youtu.be/hJuAO09rKLM?t=1357),
  [slides](https://docs.google.com/presentation/d/19N4B7BXu_Zfw8IDdUAZl_83-jXDAvwWC2KI6BvvNUCI/edit#slide=id.g8790db40db_0_205)
* Integration pull request with the changes:
  [jenkinsci/jenkins#4752](https://github.com/jenkinsci/jenkins/pull/4752)

## Contributing

Any contributions to the dark theme and compatibility are welcome!
See [CONTRIBUTING.md](./CONTRIBUTING.md) for the contribution guidelines.
And thanks to all [contributors](https://github.com/jenkinsci/dark-theme-plugin/graphs/contributors)!

## References

* The theme was created as a part of the [Jenkins UI/UX Hackfest](https://github.com/jenkinsci/ui-ux-hackfest-2020) on May 25-29, 2020.
* The theme is inspired by the [camalot/jenkins-dark-stylish](https://github.com/camalot/jenkins-dark-stylish) theme, but it is a new theme created by scratch.
