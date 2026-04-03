package io.jenkins.plugins.darktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.Stapler;
import org.kohsuke.stapler.StaplerRequest2;

public class DarkThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_CSS = "theme.css";
    public static final String THEME_URL_NAME = "theme-dark";
    public static final String ACE_EDITOR_THEME = "tomorrow_night";
    public static final String BOOTSTRAP_THEME = "dark";
    public static final String ENTRA_ID_THEME = "dark";

    @DataBoundConstructor
    public DarkThemeManagerFactory() {}

    /**
     * Returns a context-path-relative CSS URL so the theme works regardless of
     * which host/port the user accesses Jenkins through (e.g. bypassing a
     * reverse proxy). The parent implementation uses {@code Jenkins.get().getRootUrl()}
     * which always returns the globally configured URL.
     */
    @Override
    public String getCssUrl() {
        StaplerRequest2 req = Stapler.getCurrentRequest2();
        if (req != null) {
            return req.getContextPath() + "/" + THEME_URL_NAME + "/" + THEME_CSS;
        }
        return super.getCssUrl();
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .withProperty("ace-editor", "theme", ACE_EDITOR_THEME)
                .withProperty("entra-id", "theme", ENTRA_ID_THEME)
                .withProperty("bootstrap", "theme", BOOTSTRAP_THEME)
                .build();
    }

    @Extension
    @Symbol("dark")
    public static class DarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Dark";
        }

        @Override
        public String getIconClassName() {
            return "symbol-moon-outline plugin-ionicons-api";
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "dark";
        }

        @Override
        public String getThemeKey() {
            return "dark";
        }

        @Override
        public boolean isNamespaced() {
            return true;
        }
    }
}
