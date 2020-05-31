package io.jenkins.plugins.darktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.jenkinsci.plugins.thememanager.Theme;
import org.jenkinsci.plugins.thememanager.ThemeManagerFactory;
import org.jenkinsci.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebMethod;

public class DarkThemeManagerFactory extends ThemeManagerFactory {

    @DataBoundConstructor
    public DarkThemeManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }

    @Extension
    public static class DarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @WebMethod(name = "theme.css")
        public void doDarkThemeCss(StaplerRequest req, StaplerResponse res) throws IOException {
            try (InputStream themeInputStream = getClass().getResourceAsStream("theme.css")) {
                res.setContentType("text/css");
                Objects.requireNonNull(themeInputStream);
                String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
                res.getWriter().print(s1);
            }
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Dark";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new DarkThemeManagerFactory();
        }
    }
}
