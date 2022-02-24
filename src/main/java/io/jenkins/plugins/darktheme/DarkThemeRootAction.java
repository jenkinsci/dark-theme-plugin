package io.jenkins.plugins.darktheme;

import hudson.Extension;
import hudson.Main;
import hudson.Plugin;
import hudson.PluginWrapper;
import hudson.model.UnprotectedRootAction;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import jenkins.model.Jenkins;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebMethod;

import static io.jenkins.plugins.darktheme.DarkThemeManagerFactory.THEME_CSS;
import static io.jenkins.plugins.darktheme.DarkThemeManagerFactory.THEME_URL_NAME;

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

    public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, URISyntaxException, ServletException {
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
        plugin.doDynamic(req,rsp);
    }
}
