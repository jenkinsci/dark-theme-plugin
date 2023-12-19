package io.jenkins.plugins.darktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class DarkThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_CSS = "theme.css";
    public static final String THEME_URL_NAME = "theme-dark";
    public static final String ACE_EDITOR_THEME = "tomorrow_night";
    public static final String PRISM_THEME = "tomorrow";
    public static final String BOOTSTRAP_THEME = "dark";
    public static final String ENTRA_ID_THEME = "dark";

    @DataBoundConstructor
    public DarkThemeManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .withProperty("ace-editor", "theme", ACE_EDITOR_THEME)
                .withProperty("entra-id", "theme", ENTRA_ID_THEME)
                .withProperty("prism-api", "theme", PRISM_THEME)
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
