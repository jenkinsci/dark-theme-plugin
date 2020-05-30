# Dark Theme for Jenkins (Incubated project)

[![Gitter](https://badges.gitter.im/jenkinsci/ux-sig.svg)](https://gitter.im/jenkinsci/ux-sig?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

This repository contains a dark theme for Jenkins.

*Requires Jenkins >= 2.239*

## Usage

To install this theme use the [Simple Theme Plugin](https://plugins.jenkins.io/simple-theme-plugin/).

See the plugin documentation for theme installation guidelines.

_Note: replace 'tag-name' with the latest released version:_

[![GitHub release](https://img.shields.io/github/release/jenkinsci/dark-theme.svg?label=latest)](https://github.com/jenkinsci/dark-theme/releases/latest)

The CSS URL is:

```text
https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/theme.css
```

or with the [configuration-as-code](https://github.com/jenkinsci/configuration-as-code-plugin) plugin:

```yaml
unclassified:
  simple-theme-plugin:
    elements:
      - cssUrl:
          url: "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@<tag-name>/theme.css"
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

This project is in active development and needs a recent version of Jenkins, at least v2.239.

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
And thanks to all [contrhibutors](./CONTRIBUTORS.md)!

## References

* The theme was created as a part of the [Jenkins UI/UX Hackfest](https://github.com/jenkinsci/ui-ux-hackfest-2020) on May 25-29, 2020.
* The theme is inspired by the [camalot/jenkins-dark-stylish](https://github.com/camalot/jenkins-dark-stylish) theme, but it is a new theme created by scratch.
