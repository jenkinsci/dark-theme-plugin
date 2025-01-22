package io.jenkins.plugins.darktheme;

import static io.jenkins.plugins.darktheme.DarkThemeManagerFactory.THEME_CSS;
import static io.jenkins.plugins.darktheme.DarkThemeManagerFactory.THEME_URL_NAME;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.UnprotectedRootAction;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.net.URISyntaxException;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest2;
import org.kohsuke.stapler.StaplerResponse2;

@Extension
@Restricted(NoExternalUse.class)
public class DarkThemeRootAction implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return THEME_URL_NAME;
    }

    public void doDynamic(StaplerRequest2 req, StaplerResponse2 rsp)
            throws IOException, URISyntaxException, ServletException {
        String cssFile = req.getRestOfPath();
        if (cssFile.startsWith("/")) {
            cssFile = cssFile.substring(1);
        }
        if (!THEME_CSS.equals(cssFile) && !(THEME_CSS + ".map").equals(cssFile)) {
            rsp.sendError(404);
            return;
        }
        final Plugin plugin = Jenkins.get().getPlugin("dark-theme");
        if (plugin == null) {
            rsp.sendError(404);
            return;
        }
        plugin.doDynamic(req, rsp);
    }
}
