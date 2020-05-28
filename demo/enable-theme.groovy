// TODO: It should be in JCasC, but a demo patch is needed. We will use Groovy for now
import org.codefirst.SimpleThemeDecorator
import jenkins.model.Jenkins
import hudson.model.PageDecorator
import org.jenkinsci.plugins.simpletheme.CssUrlThemeElement;

boolean developerMode = Boolean.getBoolean("io.jenkins.themes.dark.developerMode")
String themeUrl = developerMode
    ? "http://localhost:8080/userContent/theme.css"
    : "https://cdn.jsdelivr.net/gh/jenkinsci/dark-theme@master/theme.css"

//TODO(oleg_nenashev): Use a theme served from a volume
Jenkins.instance.getExtensionList(PageDecorator.class)
    .get(SimpleThemeDecorator.class).getElements()
        .add(new CssUrlThemeElement(themeUrl))
