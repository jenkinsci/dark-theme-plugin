import org.codefirst.SimpleThemeDecorator
import jenkins.model.Jenkins
import hudson.model.PageDecorator
import org.jenkinsci.plugins.simpletheme.CssUrlThemeElement
import io.jenkins.plugins.logintheme.LoginTheme
import jenkins.model.SimplePageDecorator

boolean disabled = Boolean.getBoolean("io.jenkins.themes.dark.disabled")
boolean developerMode = Boolean.getBoolean("io.jenkins.themes.dark.developerMode")
boolean darkLogin = Boolean.getBoolean("io.jenkins.themes.dark.login")

// Simple Theme
if (!disabled) {
    String themeUrl = developerMode
        ? "http://localhost:8081/theme.css"
        : "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/src/main/resources/io/jenkins/plugins/darktheme/theme.css"
    def simpleThemeConfig = Jenkins.instance.getExtensionList(PageDecorator.class).get(SimpleThemeDecorator.class)
    simpleThemeConfig.getElements().add(new CssUrlThemeElement(themeUrl))
}

if (!darkLogin) {
    return;
}

// Login Theme
def loginThemeConfig = Jenkins.instance.getExtensionList(SimplePageDecorator.class).get(LoginTheme.class)
loginThemeConfig.useDefaultTheme = true
if (!disabled) {
    if (developerMode) {
        loginThemeConfig.head = '<link rel="stylesheet" href="http://localhost:8081/theme.css" type="text/css" />'
    } else {
        loginThemeConfig.head = '<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/src/main/resources/io/jenkins/plugins/darktheme/theme.css" type="text/css" />'
    }
}
