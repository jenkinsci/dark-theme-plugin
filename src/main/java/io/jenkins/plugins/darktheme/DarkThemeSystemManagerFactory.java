package io.jenkins.plugins.darktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebMethod;

public class DarkThemeSystemManagerFactory extends ThemeManagerFactory {

    private static final String THEME_SYSTEM_CSS = "theme-system.css";

    @DataBoundConstructor
    public DarkThemeSystemManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }
    
    @Extension
    public static class DarkThemeSystemManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @WebMethod(name = THEME_SYSTEM_CSS)
        public void doDarkThemeSystemCss(StaplerRequest req, StaplerResponse res) throws IOException {
            try (InputStream themeInputStream = getClass().getResourceAsStream(THEME_SYSTEM_CSS)) {
                res.setContentType("text/css");
                Objects.requireNonNull(themeInputStream);
                String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
                res.getWriter().print(s1);
            }
        }

        @WebMethod(name = DarkThemeManagerFactory.THEME_CSS)
        public void doDarkThemeCss(StaplerRequest req, StaplerResponse res) throws IOException {
            try (InputStream themeInputStream = getClass().getResourceAsStream(DarkThemeManagerFactory.THEME_CSS)) {
                res.setContentType("text/css");
                Objects.requireNonNull(themeInputStream);
                String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
                res.getWriter().print(s1);
            }
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Dark (Respect OS/Browser system setting)";
        }

        @Override
        public String getThemeCssSuffix() {
            return "theme-system.css";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new DarkThemeSystemManagerFactory();
        }
    }
}
