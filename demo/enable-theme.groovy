//TODO: cleanup oleg-nenashev/dark-theme references for JSDELIVR
import org.codefirst.SimpleThemeDecorator
import jenkins.model.Jenkins
import hudson.model.PageDecorator
import org.jenkinsci.plugins.simpletheme.CssUrlThemeElement
import io.jenkins.plugins.logintheme.LoginTheme
import jenkins.model.SimplePageDecorator

boolean disabled = Boolean.getBoolean("io.jenkins.themes.dark.disabled")
boolean developerMode = Boolean.getBoolean("io.jenkins.themes.dark.developerMode")

// Simple Theme
if (!disabled) {
    String themeUrl = developerMode
        ? "https://cdn.jsdelivr.net/gh/oleg-nenashev/dark-theme@dark-login2/theme.css"
        : "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/theme.css"
    def simpleThemeConfig = Jenkins.instance.getExtensionList(PageDecorator.class).get(SimpleThemeDecorator.class)
    simpleThemeConfig.getElements().add(new CssUrlThemeElement(themeUrl))
}

// Login Theme
def loginThemeConfig = Jenkins.instance.getExtensionList(SimplePageDecorator.class).get(LoginTheme.class)
loginThemeConfig.useDefaultTheme = false
loginThemeConfig.header = '''
<div id="loginIntroDefault">
<div class="logo"> </div>
  <h1>Welcome to Jenkins</h1>
</div>
'''
if (developerMode) {
//oleg_nenashev=will not work with the current permissions model
//    loginThemeConfig.head = '''
//        <link rel="stylesheet" href="http://localhost:8080/userContent/login-theme/simple-page.css" type="text/css" />
//        <link rel="stylesheet" href="http://localhost:8080/userContent/login-theme/simple-page.theme.css" type="text/css" />
//        <link rel="stylesheet" href="http://localhost:8080/userContent/login-theme/simple-page-forms.css" type="text/css" />
//    '''
    loginThemeConfig.head = '''
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/oleg-nenashev/dark-theme@dark-login2/login-theme/simple-page.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/oleg-nenashev/dark-theme@dark-login2/login-theme/simple-page.theme.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/oleg-nenashev/dark-theme@dark-login2/login-theme/simple-page-forms.css" type="text/css" />
    '''
} else {
    loginThemeConfig.head = '''
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/login-theme/simple-page.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/login-theme/simple-page.theme.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/login-theme/simple-page-forms.css" type="text/css" />
    '''
}

if (!disabled) {
    if (developerMode) {
        loginThemeConfig.head += '<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/oleg-nenashev/dark-theme@dark-login2/theme.css" type="text/css" />'
    } else {
        loginThemeConfig.head += '<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/theme.css" type="text/css" />'
    }
}
